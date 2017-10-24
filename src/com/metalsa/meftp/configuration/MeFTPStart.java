package com.metalsa.meftp.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Priority;
import org.hsqldb.server.ServerAcl.AclFormatException;

import com.metalsa.meftp.administration.MeFTPServerBO;
import com.metalsa.meftp.database.MeFTPDataBase;
import com.metalsa.meftp.utils.Constantes;
import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MeFTPServerException;
/**
 * @author Jesus Enrique Aldana Sanchez
 * apunte en web.xml
 *  <listener>
 *       <listener-class>com.metalsa.meftp.configuration.MeFTPStart</listener-class>
 *   </listener>
 */
public class MeFTPStart implements ServletContextListener {

	@SuppressWarnings("deprecation")
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			if (MeFTPDataBase.getInstance().isConnected()){
			MeFTPDataBase.getInstance().disconnectionDataBase();
			}
			if (MeFTPDataBase.getInstance().isStarted()){
				MeFTPDataBase.getInstance().stop();
			}
			
		} catch (MeFTPServerException e) {
			 LogLevel.log("MeFTP Exception in contextInitialized of MeFTP :"+ e.getMessage() , Priority.INFO, null);
				
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		javax.servlet.ServletContext contexto = arg0.getServletContext();
		inicializarRutaEstatica(contexto);
		
		//Here starting Crone Jobs
		// This call Would be last into this method -- Here start MeFTPserver
		try {
			System.out.println(Constantes.VERSION);
			System.out.println(Constantes.rutaArchivoConfiguracion);
			Properties properties = new Properties();
			properties.load(new FileInputStream(Constantes.rutaArchivoConfiguracion));
			Constantes.archiconfig=properties;
			LogLevel.getInstance(Constantes.archiconfig);
			LogLevel.log("MeFTP server starting. " , Priority.INFO, null);
			LogLevel.log("Version del aplicativo: " + Constantes.VERSION , Priority.INFO, null);
			LogLevel.log("Ruta del archivo de configuracion:  " + Constantes.rutaArchivoConfiguracion , Priority.INFO, null);
			MeFTPServerBO.getInstance().start();
			LogLevel.log("MeFTP server started. " , Priority.INFO, null);
			LogLevel.log("MeFTP Data Base server starting. " , Priority.INFO, null);
			MeFTPDataBase.getInstance().start();
			LogLevel.log("MeFTP Data Base server started. " , Priority.INFO, null);
			
			
		} catch (MeFTPServerException e) {
			LogLevel.log("Erron in start meFTP server : "+ e.getMessage() , Priority.INFO, null);
			//System.out.println(e.getMessage());
						
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
			LogLevel.log("Erron in start MeFTP Data Base server  IOException : "+ e.getMessage() , Priority.INFO, null);
			
		} catch (AclFormatException e) {
			System.out.println(e.getMessage());
			LogLevel.log("Erron in start MeFTP Data Base server AclFormatException  : "+ e.getMessage() , Priority.INFO, null);
			
		}
		
		
		// Create Table DataBase and Admin users for  MeFTP database configuration. Just if not exist.
		try {
			  createTablesAndData();
		} catch (MeFTPServerException e) {
			System.out.println(e.getMessage());
			 LogLevel.log("MeFTP Exception can not insert MeFTP admin user to database :"+ e.getMessage() , Priority.INFO, null);
			
		}
		// Load MeFTP users from MeFTP Database config.
		try {
			MeFTPServerBO.getInstance().meFTPLoadUsersFromMeFTPDatabaseConfig();
		} catch (MeFTPServerException e) {
			System.out.println(e.getMessage());
			 LogLevel.log("MeFTP Exception can not load MeFTP users from MeFTP database config :"+ e.getMessage() , Priority.INFO, null);
					}
	
		  
		
	}
	
@SuppressWarnings("deprecation")
private void inicializarRutaEstatica(javax.servlet.ServletContext contexto) { 		
		
		try {
			
			contexto.setAttribute(Constantes.RUTAESTATICA, contexto.getRealPath("/")+"/");
			LogLevel.log("Setting Static path for MeFTP to : "+Constantes.RUTAESTATICA , Priority.INFO, null);
			
			
		} catch (Exception e) {
			LogLevel.log("Have not set Static path for MeFTP" , Priority.INFO, null);	
		}
	}



@SuppressWarnings("deprecation")
private void createTablesAndData() throws MeFTPServerException {
	
					if (!MeFTPDataBase.getInstance().pingMeFTP()){
						try {
							 MeFTPDataBase.getInstance().isConnected();
						} catch (MeFTPServerException e1) {
							System.out.println(e1.getMessage());
							LogLevel.log("MeFTP Exception MeFTP is not connected with meFTP Data Base : " , Priority.INFO, null);
							throw new MeFTPServerException("MeFTP Exception MeFTP is not connected with meFTP Data Base :");
						}
						try {
							MeFTPDataBase.getInstance().createMeFTPTable();
							} catch (MeFTPServerException ex) {
								System.out.println(ex.getMessage());
								LogLevel.log("MeFTP Exception can not create MeFTP table for user to database : " , Priority.INFO, null);
								throw new MeFTPServerException("MeFTP Exception can not create MeFTP table for user to database :");
						}
						try {
							MeFTPDataBase.getInstance().initalLoadAdminMeFTPUser();
						} catch (MeFTPServerException ex) {
							System.out.println(ex.getMessage());
							LogLevel.log("MeFTP Exception can not insert MeFTP admin user to database : " , Priority.INFO, null);
							throw new MeFTPServerException("MeFTP Exception can not insert MeFTP admin user to database :");
						}
					}
			
	}
	
}



