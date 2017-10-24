/**
 * 
 */
package com.metalsa.meftp.upload;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Priority;
import org.apache.struts2.ServletActionContext;

import com.metalsa.meftp.email.EMail;
import com.metalsa.meftp.files.MeftpFilesTd;
import com.metalsa.meftp.files.MeftpFilesTdDAO;
import com.metalsa.meftp.journaltab.AddJournalRegister;
import com.metalsa.meftp.utils.Constantes;
import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MEDSBaseAction;
import com.metalsa.meftp.utils.MeFTPServerDBException;
import com.metalsa.meftp.utils.MeFTPServerEmailException;
import com.metalsa.meftp.utils.MeFTPServerFileException;
import com.metalsa.meftp.utils.MeFTPUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



/**
 * @author Jesus Enrique Aldana Sanchez
 *
 */
public class MeftpUpload extends MEDSBaseAction
{
	
	private static final long serialVersionUID = 6359082685784799824L;
	private boolean success;
	private String return_message;
	public String getReturn_message() {
		return return_message;
	}
	public void setReturn_message(String return_message) {
		this.return_message = return_message;
	}

 	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

    @SuppressWarnings({ "static-access", "deprecation" })
	public String upload() {
    	InputStream in = null;
    	 List <String> listades = new ArrayList<String>();
    	 String FILEPATH =null;
    	 MeftpFilesTd meftpFilesTd= null;
    	 MeftpFilesTdDAO meftpFilesTdDAO= new MeftpFilesTdDAO();
		try {
			in = request.getInputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	String fileName = request.getHeader("X-File-Name")!=null?request.getHeader("X-File-Name"):"default";
    	String fileSize= request.getHeader("Content-Length")!=null?request.getHeader("Content-Length"):"default";
    	String fileContentType=request.getHeader("Content-Type")!=null?request.getHeader("Content-Type"):"default";
    	String fileUserAgent= request.getHeader("User-Agent")!=null?request.getHeader("User-Agent"):"default";
    	if (in != null){
    		 try {
    			 String OSName = System.getProperty("os.name");
    				if (OSName.toLowerCase().indexOf("windows")!=-1){
    					FILEPATH = Constantes.UPLOAD_FOLDER;
    				}else{
    					FILEPATH = Constantes.UNIX_UPLOAD_FOLDER;
    				}
    			 // Bajar la IP y el cliente ( IE , Safari , ) Meterlo en la BD
    			 // fileUserAgen
    			 // Meter el tiempo de subida.
    			LogLevel.log("TimeStamp initial time : " + MeFTPUtils.getInstance().getTodayDate(), Priority.INFO, null);
    			 // Aqui bajar el User name de la sesion y fijar el directorio 
   			 	SaveFile.getInstance().saveFile(in, fileName,FILEPATH );
   			    LogLevel.log("TimeStamp final time" + MeFTPUtils.getInstance().getTodayDate(), Priority.INFO, null);
   			    AddJournalRegister.getInstance().addJournalEvent(fileName, "Archivo guardado", Constantes.JOURNAL_FLAG_ONE);
 			
    			 // AJUSTAR EL PATH de ACUERDO AL USUARIO
    			 FILEPATH = Constantes.UNIX_UPLOAD_FOLDER;
    			 // Aqui mandar guardarlo en la base de datos
    			 meftpFilesTd= new MeftpFilesTd(fileName,FILEPATH,new Integer("1"),new Integer(fileSize),fileContentType,MeFTPUtils.getInstance().getTodayDate());
    			 meftpFilesTdDAO.save(meftpFilesTd);
    			 
    				 // Determinar si hay que mandar un email
    			 // Mandar un email
    			 listades.add("jesus.aldana@metalsa.com");
    			 // Desarollar utileria para formatear el contenido de emails de acuerdo al dise�o
    			 // AJUSTAR PARAMETROS DE JOURNAL
    			 EMail.getInstance().enviaCorreo(listades,"Upload file success", "You have a new file in your MeFTP repository <br>");
    			 LogLevel.log("File named " + fileName + " was saved in " +FILEPATH, Priority.INFO, null);
    			
        		 setSuccess(true);
        	     return SUCCESS;
    				
    		 } catch (MeFTPServerDBException e) {
    					LogLevel.log("File named " + fileName + "was not saved in database ", Priority.INFO, null);
    					try {
							 listades.add(Constantes.EMAIL_ADMINISTRADOR_TECWEB);
					  		 EMail.getInstance().enviaCorreo(listades,Constantes.DATA_BASE_EROR_MESSAGE +fileName+" ",e.getMessage());
						} catch (MeFTPServerEmailException e1) {
							LogLevel.log(Constantes.EMAIL_NOT_SENT, Priority.INFO, null);
							
						}
    					setReturn_message(Constantes.DATA_BASE_EROR_MESSAGE);
    					setSuccess(true);
    		    	    return SUCCESS;
 			
			} catch (MeFTPServerFileException e) {
							LogLevel.log("File named " + fileName + "was saved in database record ", Priority.INFO, null);
							LogLevel.log("File named " + fileName + "was not saved in " +FILEPATH, Priority.INFO, null);
							try {
								 listades.add(Constantes.EMAIL_ADMINISTRADOR_TECWEB);
					    		 EMail.getInstance().enviaCorreo(listades,"Error saved file named : " +fileName,"File named " + fileName + "was saved in database record ");
							} catch (MeFTPServerEmailException e1) {
								LogLevel.log(Constantes.EMAIL_NOT_SENT, Priority.INFO, null);
							}
							setReturn_message("File named " + fileName + "was not saved in " +FILEPATH);
	    					setSuccess(false);
	    		    	    return SUCCESS;
				   		    
			} catch (MeFTPServerEmailException e) {
							try {
								 listades.add(Constantes.EMAIL_ADMINISTRADOR_TECWEB);
						  		 EMail.getInstance().enviaCorreo(listades,"Error sent email message for : " +fileName,"");
							} catch (MeFTPServerEmailException e1) {
								LogLevel.log(Constantes.EMAIL_NOT_SENT, Priority.INFO, null);
								
							}
							setReturn_message("File was been saved , therefore has been an error sending email message for : " +fileName);
	    					setSuccess(true);
	    		    	    return SUCCESS;
		}
    }else{
	    	try {
	    		 listades.add(Constantes.EMAIL_ADMINISTRADOR_TECWEB);
				  EMail.getInstance().enviaCorreo(listades,Constantes.UPLOAD_FILE_EMPTY ,"");
			} catch (MeFTPServerEmailException e1) {
				LogLevel.log(Constantes.EMAIL_NOT_SENT, Priority.INFO, null);
				
			}
	    	setReturn_message(Constantes.UPLOAD_FILE_EMPTY);
			setSuccess(false);
    	    return SUCCESS;
    		
    }
    	
    }
}
