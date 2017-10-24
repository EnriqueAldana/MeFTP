/**
 * 
 */
package com.metalsa.meftp.upload;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Priority;

import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MeFTPServerFileException;

/**
 * @author Jesus Enrique Aldana Sanchez
 * Class for to save a file from InputStream file content
 *
 */
public class SaveFile  {
	private static SaveFile INSTANCE = null;
	private SaveFile(){}
	
	@SuppressWarnings("deprecation")
	public void saveFile(final InputStream in, final String fileName,final String FilePath) throws MeFTPServerFileException{
		
		if (in != null){
   		 try {
   			 // Aqui mandar guardarlo en la base de datos
   			 // Si hay excepcion , guardarlo en un directorio temperal determinado
   			 // Aqui bajar el User name de la sesion y fijar el directorio 
   			 
   			  File dirs = new File(FilePath);
		  		  File uploadedFileSaved = new File(dirs, fileName);
   			  OutputStream out=new FileOutputStream(uploadedFileSaved);
   			  byte buf[]=new byte[1024];
   			  int len;
   			  while((len=in.read(buf))>0)
   			  out.write(buf,0,len);
   			  out.close();
   			  in.close();
   			  /*System.out.println("\nFile " +fileName +"is created.");
   			  System.out.println("\nUser Id: " +userId );
   			  System.out.println("\nNavegator: " +strUserAgent );*/
   					 
   		} catch (IOException e) {
				LogLevel.log("MeFTP Exception can not Save file for IOException", Priority.ERROR, null);
				throw new MeFTPServerFileException("MeFTP Exception can not Save file for IOException");
		}
   	
   	
   }else{
	   LogLevel.log("MeFTP Exception can not Save file for IOException", Priority.ERROR, null);
	   throw new MeFTPServerFileException("MeFTP Exception can not Save file for InputStream is NULL ");
   }
	
	}
	
	
	
	private synchronized static void createInstance() throws MeFTPServerFileException {
        if (INSTANCE == null) { 
            INSTANCE = new SaveFile();
        }
    }
    // Metodo para tomar una instancia unica
    @SuppressWarnings("deprecation")
	public static SaveFile getInstance() throws MeFTPServerFileException {
			try {
    		
    		if (INSTANCE == null) 
    		   createInstance();
            return INSTANCE;
		} catch (MeFTPServerFileException ex) {
			System.out.println(ex.getMessage());
			LogLevel.log("MeFTP Exception creating SaveFile instance : " , Priority.INFO, null);
			throw new MeFTPServerFileException("Exception creating SaveFile instance");
		}
    	
    }
	
  
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
	
	
	
	
	
	
}
