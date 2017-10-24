/**
 * 
 */
package com.metalsa.meftp.administration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Priority;
import org.hsqldb.server.ServerAcl.AclFormatException;

import com.metalsa.meftp.database.MeFTPDataBase;
import com.metalsa.meftp.utils.Constantes;
import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MeFTPServerException;

/**
 * @author root
 *
 */
public class MeFTPServer {
	
	private static final long serialVersionUID = -365606735675508099L;
	private static final String STARTED = "started";
	private static final String STOPPED = "stopped";
	private static final String ERROR = "error";
	
	/*public String execute() {
		return "SUCCESS";
		}*/
	@SuppressWarnings("deprecation")
	public String start() throws MeFTPServerException{
		try {
			//MeFTPServerBO.getInstance().start();
			
			System.out.println(Constantes.VERSION);
			System.out.println(Constantes.rutaArchivoConfiguracion);
			Properties properties = new Properties();
			try {
				properties.load(new FileInputStream(Constantes.rutaArchivoConfiguracion));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Constantes.archiconfig=properties;
			try {
				LogLevel.getInstance(Constantes.archiconfig);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LogLevel.log("MeFTP server starting. " , Priority.INFO, null);
			LogLevel.log("Version del aplicativo: " + Constantes.VERSION , Priority.INFO, null);
			LogLevel.log("Ruta del archivo de configuracion:  " + Constantes.rutaArchivoConfiguracion , Priority.INFO, null);
			MeFTPServerBO.getInstance().start();
			LogLevel.log("MeFTP server started. " , Priority.INFO, null);
			LogLevel.log("MeFTP Data Base server starting. " , Priority.INFO, null);
			try {
				MeFTPDataBase.getInstance().start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AclFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LogLevel.log("MeFTP Data Base server started. " , Priority.INFO, null);
			
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
			
			
			return STARTED;
		} catch (MeFTPServerException e) {
			System.out.println(e.getMessage());
			return ERROR;
		
		}
		
		
	}
	public String stop(){
		// Something
		try {
			MeFTPServerBO.getInstance().stop();
			return STOPPED;
		} catch (MeFTPServerException e) {
			System.out.println(e.getMessage());
			// Mandar a Log la excepcion
			return ERROR;
		
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
