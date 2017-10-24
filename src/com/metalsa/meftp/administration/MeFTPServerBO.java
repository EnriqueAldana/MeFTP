package com.metalsa.meftp.administration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.ssl.SslConfigurationFactory;
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor;
import org.apache.ftpserver.usermanager.Md5PasswordEncryptor;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.SaltedPasswordEncryptor;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import org.apache.ftpserver.usermanager.PasswordEncryptor;
import org.apache.ftpserver.usermanager.impl.DbUserManager;
import org.apache.log4j.Priority;

import com.metalsa.meftp.database.MeFTPDataBase;
import com.metalsa.meftp.user.MeftpUsersTc;
//import com.metalsa.meftp.users.TOMeFTPUser;
import com.metalsa.meftp.utils.Constantes;
import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MeFTPServerException;



/**
 * @author Jesus Enrique Aldana Sanchez
 *
 */
public class MeFTPServerBO {
	
	private static MeFTPServerBO INSTANCE = null;
	private ListenerFactory listenerServerFactory = null;
	private FtpServerFactory ftpServerFactory = null;
	
	private static FtpServer server=null;
	// Private constructor
	private MeFTPServerBO()throws MeFTPServerException {
		// Load file porperties
		try {
			loadAppFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	 // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() throws MeFTPServerException {
        if (INSTANCE == null) { 
            INSTANCE = new MeFTPServerBO();
        }
    }
    // Metodo para tomar una instancia unica
    public static MeFTPServerBO getInstance() throws MeFTPServerException {
			try {
    		
    		if (INSTANCE == null) 
    		   createInstance();
            return INSTANCE;
		} catch (MeFTPServerException ex) {
			throw new MeFTPServerException("Exception creating MeFTPServerBO instance");
		}
    	
    }
	
  
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }

	
	@SuppressWarnings("deprecation")
	public final void start() throws MeFTPServerException{
		
		try {
			// Arranca el Servidor - start the server 
			if (server == null) { 
				ftpServerFactory= new FtpServerFactory();
				// Reemplaza el escucha por defecto - replace the default listener
				LogLevel.log("MeFTP configuring... ", Priority.INFO, null);
				ftpServerFactory.addListener("default",  meFTPConfig().createListener());
				LogLevel.log("MeFTP configurated... ", Priority.INFO, null);
				LogLevel.log("MeFTP creatining server... ", Priority.INFO, null);
				server = ftpServerFactory.createServer();
				LogLevel.log("MeFTP server created ... ", Priority.INFO, null);
				LogLevel.log("MeFTP server starting ... ", Priority.INFO, null);
				server.start();
				LogLevel.log("MeFTP server started ... ", Priority.INFO, null);
				// Loading from MeFTP Data base in Initialization context.
				//LogLevel.log("MeFTP server loading users ... ", Priority.INFO, null);
				//meFTPLoadUsersFromMeFTPFileConfig();
				//LogLevel.log("MeFTP server been completed MeFTP Users... ", Priority.INFO, null);
				LogLevel.log("========== MeFTP server status =============" , Priority.INFO, null);
				LogLevel.log("MeFTP status: " + "Started", Priority.INFO, null);
				LogLevel.log("========== MeFTP server properties config =============" , Priority.INFO, null);
				LogLevel.log("MeFTP home directory server from properties file : " + Constantes.archiconfig.getProperty("MeFTPServer.homedirectory"), Priority.INFO, null);
				LogLevel.log("MeFTP access port server from properties file : " + Constantes.archiconfig.getProperty("MeFTPServer.port"), Priority.INFO, null);
				LogLevel.log("MeFTP passive address Ip server from properties file : " + Constantes.archiconfig.getProperty("MeFTPServer.PassiveAddress"), Priority.INFO, null);
				LogLevel.log("MeFTP passive external address Ip server from properties file : " + Constantes.archiconfig.getProperty("MeFTPServer.PassiveExternalAddress"), Priority.INFO, null);
				LogLevel.log("MeFTP passive ports server from properties file : " + Constantes.archiconfig.getProperty("MeFTPServer.PassivePorts"), Priority.INFO, null);
				LogLevel.log("MeFTP idletime server from properties file : " + Constantes.archiconfig.getProperty("MeFTPServer.IdleTime"), Priority.INFO, null);
				  /* 
				   * LogLevel.log("========== MeFTP server config =============" , Priority.INFO, null);
				LogLevel.log("MeFTP address host : " + com.metalsa.meftp.utils.TestUtil.getHostAddresses().toString(), Priority.INFO, null);
			    LogLevel.log("MeFTP base directory : " + com.metalsa.meftp.utils.TestUtil.getBaseDir(), Priority.INFO, null);
			    LogLevel.log("MeFTP passive Address Ip server : "+dataConnectionConfigFactory.getPassiveAddress(), Priority.INFO, null);
			    LogLevel.log("MeFTP passive External Address Ip server :  "+ dataConnectionConfigFactory.getPassiveExternalAddress(), Priority.INFO, null);
			    LogLevel.log("MeFTP passive Ports server : "+ dataConnectionConfigFactory.getPassivePorts(), Priority.INFO, null);
			 */   LogLevel.log("========== MeFTP client config =============" , Priority.INFO, null);
			    LogLevel.log("MeFTP client should be connected with: " + "Implicit/explicit SSL/TLS", Priority.INFO, null);
			    MeFTPDataBase.getInstance().start();
				
			}else{
	        	if (server.isSuspended()){
	        	server.resume();
				LogLevel.log("MeFTP status: " + "Resumed", Priority.INFO, null);
				// Iniciar la base de Datos
				MeFTPDataBase.getInstance().start();
				LogLevel.log("MeFTP Data Base: " + "started", Priority.INFO, null);
				
				}
	        }
			
			
			
		} catch ( Exception e) {
			
			LogLevel.log("MeFTP starting error:  " + e, Priority.ERROR, null);
			//System.out.println(e.getMessage());
			throw new MeFTPServerException("Exception starting MeFTP Server - class: MeFTPServerBO method: start() ");
			
		}
		
   
		
	}
	@SuppressWarnings("deprecation")
	public final void stop() throws MeFTPServerException{
		try{
			if (server!= null) { 
				server.suspend();
				LogLevel.log("MeFTP status: " + "Suspended", Priority.INFO, null);
				// Stop Database
				if (MeFTPDataBase.getInstance().isConnected()){
					MeFTPDataBase.getInstance().disconnectionDataBase();
				}
				if (MeFTPDataBase.getInstance().isStarted()){
					MeFTPDataBase.getInstance().stop();
					}
	        }
			
	} catch ( Exception e) {
		LogLevel.log("MeFTP suspended error:  " + e, Priority.ERROR, null);
		throw new MeFTPServerException("Exception stopping MeFTP Server - class: MeFTPServerBO method: stop() ");
		
	}
		
		
	}
	
	@SuppressWarnings("deprecation")
	private void loadAppFile() throws MeFTPServerException, IOException{
		  
		  try {
			 	LogLevel.log("Loading configuration file (loadAppFile): " + Constantes.rutaArchivoConfiguracion, Priority.INFO, null);
				LogLevel.log("Loading configuration file (loadAppFile): " + Constantes.rutaArchivoConfiguracion, Priority.DEBUG, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogLevel.log("MeFTP loadAppFile error:  " + e, Priority.ERROR, null);
			throw new MeFTPServerException("Exception loading application file configuration for MeFTP Server - class: MeFTPServerBO method: loadAppFile ");
		
		}
		   
	
	   }
	@SuppressWarnings("deprecation")
	private ListenerFactory meFTPConfig() throws MeFTPServerException{
		ListenerFactory factory = new ListenerFactory();
		
		// verificar modo pasivo
		DataConnectionConfigurationFactory dataConnectionConfigFactory= new DataConnectionConfigurationFactory();
		// Fija modo implisito de conexion
		dataConnectionConfigFactory.setImplicitSsl(true);
		// Fija las direcciones en modo Pasivo
		dataConnectionConfigFactory.setPassiveAddress(Constantes.archiconfig.getProperty("MeFTPServer.PassiveAddress"));
		dataConnectionConfigFactory.setPassiveExternalAddress(Constantes.archiconfig.getProperty("MeFTPServer.PassiveExternalAddress"));
		// Maximo tiempo de inactividad en segundos. 3600 = 1 Hra
		dataConnectionConfigFactory.setIdleTime(Integer.parseInt(Constantes.archiconfig.getProperty("MeFTPServer.IdleTime")));
		
	// ToDo VALIDAR EL RANGO VALIDO del SERVIDOR
    // Asignar puertos libre para modo pasivo en un rango disponibles.
	     /* String de parametro valido para fijar los puertos para use en modo pasivo
         * 2300 : only use port 2300 as the passive port
	       2300-2399 : use all ports in the range
	       2300- : use all ports larger than 2300
	       2300, 2305, 2400- : use 2300 or 2305 or any port larger than 2400 
       */
	    
	    // To Do  validar que el rango de puertos del servidor esté disponible
        
		//passivePort = com.metalsa.meftp.utils.TestUtil.findFreePort(Integer.parseInt("1024"));
        dataConnectionConfigFactory.setPassivePorts(Constantes.archiconfig.getProperty("MeFTPServer.PassivePorts"));
		
		// Fija la configuracion al Escucha
		factory.setDataConnectionConfiguration(dataConnectionConfigFactory.createDataConnectionConfiguration());
		System.out.println("Passive Address "+dataConnectionConfigFactory.getPassiveAddress());
		System.out.println("Passive External Address "+ dataConnectionConfigFactory.getPassiveExternalAddress());
		System.out.println("Passive Ports "+ dataConnectionConfigFactory.getPassivePorts());
      
		
		
		// Fija el puerto al escucha set the port of the listener Por defecto 2221
		//factory.setPort(2221);
		int freeport=-1;
		try {
			freeport = com.metalsa.meftp.utils.TestUtil.findFreePort(Integer.parseInt(Constantes.archiconfig.getProperty("MeFTPServer.port")));
		} catch (NumberFormatException e) {
			LogLevel.log("Exception configurating MeFTP Server freeport exception - NumberFormatException - class: MeFTPServerBO method: " + e.getStackTrace().toString(), Priority.DEBUG, null);
			throw new MeFTPServerException("Exception configurating MeFTP Server freeport exception - NumberFormatException - class: MeFTPServerBO method: MeFTPConfig ");
			
		} catch (IOException e) {
			LogLevel.log("Exception configurating MeFTP Server freeport exception IOException - class: MeFTPServerBO method: " + e.getStackTrace().toString(), Priority.DEBUG, null);
			throw new MeFTPServerException("Exception configurating MeFTP Server freeport exception - IOException  - class: MeFTPServerBO method: MeFTPConfig ");
				
		}
		if (freeport>0){
			factory.setPort(freeport);
		}else{
			try {
				factory.setPort(com.metalsa.meftp.utils.TestUtil.findFreePort());
			} catch (IOException e) {
				LogLevel.log("Exception configurating MeFTP Server freeport exception IOException - class: MeFTPServerBO method: " + e.getStackTrace().toString(), Priority.DEBUG, null);
				throw new MeFTPServerException("Exception configurating MeFTP Server freeport exception - IOException  - class: MeFTPServerBO method: MeFTPConfig ");
				}
		}
		
		
		// define SSL configuration
		SslConfigurationFactory ssl = new SslConfigurationFactory();
		ssl.setKeystoreFile(new File(Constantes.archiconfig.getProperty("MeFTPServer.file.name.jks.location") + File.separator+Constantes.archiconfig.getProperty("MeFTPServer.file.name.jks")));
		ssl.setKeystorePassword(Constantes.archiconfig.getProperty("MeFTPServer.file.name.jks.password"));
		// set the SSL configuration for the listener
		factory.setSslConfiguration(ssl.createSslConfiguration());
		factory.setImplicitSsl(true);
		
		return factory;
		
	}
	

	private void meFTPLoadUsersFromMeFTPFileConfig(){
		if (ftpServerFactory!=null){
				// Prepara usuarios - Manejo de usuarios segun archivo de propiedades
			    PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
			    
		        //userManagerFactory.setFile(new File("com/metalsa/meftp/configuration/users.properties"));
			    userManagerFactory.setFile(new File(Constantes.archiconfig.getProperty("MeFTPServer.file.name.users.location")+ File.separator+Constantes.archiconfig.getProperty("MeFTPServer.file.name.users")));
			    
			    // No permite omitir encriptacion
		        // Saltar encriptacion
		        //userManagerFactory.setPasswordEncryptor(new SaltedPasswordEncryptor());	
		        
		        //ClearTextPasswordEncryptor
		        //userManagerFactory.setPasswordEncryptor(new ClearTextPasswordEncryptor());
		        ClearTextPasswordEncryptor contra= new ClearTextPasswordEncryptor();
		        
		        // Usando esta interfaz se puede sacar la encriptacion de la contraseña
		        //String nvacontra= contra.encrypt("textoDeContraseña");
		        // Compara el password y el password almacenado
		        contra.matches("passwordToCheck", "storedPassword");
		        //System.out.println(nvacontra);
		        //Md5PasswordEncryptor
		        userManagerFactory.setPasswordEncryptor(new Md5PasswordEncryptor());
		        
		        
		        // Agregar un usuario ... 
		        UserManager um = userManagerFactory.createUserManager();
		        BaseUser user = new BaseUser();
		        user.setName("caro");
		        user.setPassword("21232F297A57A5A743894A0E4A801FC3");
		        user.setHomeDirectory("/home/enrique/.");
		        user.setMaxIdleTime(Integer.parseInt("300"));
		        user.setEnabled(true);
		        // Privilegios
		        List<Authority> auths = new ArrayList<Authority>();
		        Authority auth = new WritePermission();
		        auths.add(auth);
		        user.setAuthorities(auths);
		       
		        try {
		            um.save(user);
		        } catch (FtpException e1) {
		             e1.printStackTrace();
		        }
		        
		       ftpServerFactory.setUserManager(userManagerFactory.createUserManager());
		
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public void meFTPLoadUsersFromMeFTPDatabaseConfig() throws MeFTPServerException{
		
		if (ftpServerFactory!=null){
			List <MeftpUsersTc> listUsers = new ArrayList<MeftpUsersTc>();
			// Prepara usuarios - Manejo de usuarios segun archivo de propiedades
		    PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
		    // El archivo es mandatorio para almacenar los usuarios
		    userManagerFactory.setFile(new File(Constantes.archiconfig.getProperty("MeFTPServer.file.name.users.location")+ File.separator+Constantes.archiconfig.getProperty("MeFTPServer.file.name.users")));
		    //Md5PasswordEncryptor
	        userManagerFactory.setPasswordEncryptor(new Md5PasswordEncryptor());
	         // Agregar un usuario ... 
	        UserManager um = userManagerFactory.createUserManager();
	       
				// Set MeFTP Users into MeFTP Server
				try {
					  listUsers= MeFTPDataBase.getInstance().getMeFTPUsers();
				} catch (MeFTPServerException e) {
					 LogLevel.log("MeFTP Exception can not get MeFTP users from MeFTP database :"+ e.getMessage() , Priority.INFO, null);
				}
				if (listUsers.size()>0){
					for (MeftpUsersTc meFTPUser : listUsers)  {
						 try {
							 	BaseUser user = new BaseUser();
							 	MeftpUsersTc tOMeFTPUser = new MeftpUsersTc();
							 	tOMeFTPUser = meFTPUser;
							 	user.setName(tOMeFTPUser.getMeftpUsersUsernamelogin());
						        //user.setName(tOMeFTPUser.getUserNameLogin());
							 	user.setPassword(tOMeFTPUser.getMeftpUsersUserpassword());
						        //user.setPassword(tOMeFTPUser.getUserPassword());
							 	user.setHomeDirectory(tOMeFTPUser.getMeftpUsersUserhomedirectory());
						        //user.setHomeDirectory(tOMeFTPUser.getUserHomeDirectory());
							 	user.setMaxIdleTime(tOMeFTPUser.getMeftpUsersUseridletime());
						        //user.setMaxIdleTime(Integer.parseInt(tOMeFTPUser.getUserIdleTime()));
						        user.setEnabled(tOMeFTPUser.getMeftpUsersUserenabledflag());
						        //user.setEnabled(Boolean.parseBoolean(tOMeFTPUser.getUserEnabledflag()));
						        // Privilegios
						        if (tOMeFTPUser.getMeftpUsersUserwritepermission()){
						        	List<Authority> auths = new ArrayList<Authority>();
						 	        Authority auth = new WritePermission();
						 	        auths.add(auth);
						 	        user.setAuthorities(auths);
						 	     
						        }
						        
						        try {
						        	// Guarda o actualiza los registros de cada usuario
						            um.save(user);
						            
						        } catch (FtpException e1) {
						    		LogLevel.log("MeFTP Exception can not load MeFTP user to MeFTP Server : " , Priority.INFO, null);
						    		throw new MeFTPServerException("MeFTP Exception can not load MeFTP user to MeFTP Server :");
						    			
						        } 
						 } catch (MeFTPServerException e) {
							LogLevel.log("MeFTP Exception can not load MeFTP user named"+ meFTPUser.getMeftpUsersUsernamelogin() + " to MeFTP Server : " , Priority.INFO, null);
						 }
					  }	
				}
		
		// Fija los usuarios al escucha	 
	       ftpServerFactory.setUserManager(userManagerFactory.createUserManager());
	       
		
	}
		
	}

	
	protected void finalize () {
		// This happen when set null this instance
		
	}

	void finalizer(){
		
	}

}
