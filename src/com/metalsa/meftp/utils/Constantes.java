/**
 * 
 */
package com.metalsa.meftp.utils;

import java.util.Properties;

//import org.apache.ftpserver.FtpServerFactory;

/**
 * @author Jesus Enrique Aldana Sanchez
 *
 */
public class Constantes {
	// Incluye MEDS super Upload
	public static final String VERSION="Version 0.9";
	public static final String AMBIENTE="PRD";
	public static Properties archiconfig;
		// Local
	public static String rutaArchivoConfiguracion="/Users/JEAS/Documents/1-Metalsa/Workspaces/MeFTPServer/src/com/metalsa/meftp/configuration/MeFTPServer.properties";
	// Metalsa PRD
	//public static String rutaArchivoConfiguracion="/home/medsuser/MeFTPServer/configuration/MeFTPServer.properties";
	public static String rutaUserHome=Entorno.obtenerVariable("MeFTPServer.homedirectory","/Users/JEAS/Documents/1-Metalsa/Workspaces/MeFTPServer/src/com/metalsa/meftp/server/files/");	
    public static String loggerNameFile="MeFTPServer";
    public static final String RUTAESTATICA="<html:rewrite page=\"\"/>";
    // BD
	public static final String ExcepcionObjetoYaExiste = "Objeto ya existe";
	
	public static final int Diez = 10;
	public static final String DiezString = "10.0";
	public static final String DiezStringEntero = "10";
	public static final String TIME_STAMP_DB_FORMAT= "yyyy-MM-dd H:mm:ss";
	
	//Constantes Flag para identificar el evento y agregar al diario del servidor
	public static final int JOURNAL_FLAG_ONE = 1;
	public static final int JOURNAL_FLAG_TWO = 2;
	public static final int JOURNAL_FLAG_THREE = 3;
	public static final int JOURNAL_FLAG_FOUR = 4;
	public static final int JOURNAL_FLAG_FIVE = 5;
	public static final int JOURNAL_FLAG_SIX = 6;
	public static final int JOURNAL_FLAG_SEVEN = 7;
	public static final int JOURNAL_FLAG_EIGHT = 8;
	public static final int JOURNAL_FLAG_NINE = 9;
	public static final int JOURNAL_FLAG_TEN = 10;	
	
	//Constantes del diario del servidor
	public static final String saveNewUser = "NEW USER REGISTER";
	public static final String saveNewSubgroup = "NEW SUBGROUP REGISTER";
	public static final String saveNewGroup	=	"NEW GROUP REGISTER";
	public static final String saveChangesUser	= "DATA'S USER UPDATE";
	public static final String saveChangesSubgroup = "DATA'S SUBGROUP UPDATE";
	public static final String saveChangesGroup = "DATA'S GROUP UPDATE";
	public static final String deleteUser	=	"DELETE USER REGISTER";
	public static final String deleteSubgroup = "DELETE SUBGROUP REGISTER";
	public static final String deleteGroup = "DELETE GROUP REGISTER";
	public static final String loginUser = "LOG IN USER";
	public static final String saveNewUserComments = "user has been added into the database";
	public static final String saveNewSubgroupComments	= "subgroup has ben added into the database";
	public static final String saveNewGroupCommentes = "group has been added into the database";
	public static final String saveChangesUserComments = "user data has been modified";
	public static final String saveChangesSubgroupsComments = "subgroup data has been modified";
	public static final String saveChangesGroupsComments = "group data has been modified";
	public static final String deleteUserComments = "user has been removed from the database";
	public static final String deleteSubgroupComments = "subgroup has been removed from the database";
	public static final String deleteGroupComments = "group has been removed from the database";
	public static final String loginUserComments = "logged into the system";
	
	// Nivel de Logeo
	/*
	 * fija constantes para nivel del logger
	 * SEVERE ES NIVEL MAS ALTO .... LOGEA MUY POCO
	 * FINEST ES NIVEL MAS BAJO ----LOGEA TODO
	 */
	public static final int NIVEL_LOGGER_SEVERE=8;
	
	
	public static final int NIVEL_LOGGER_CONFIG=5;
	public static final int NIVEL_LOGGER_WARNING=7;
	
	public static final int NIVEL_LOGGER_FINE=4;
	public static final int NIVEL_LOGGER_FINER=3;
	public static final int NIVEL_LOGGER_FINEST=2;
	
		
	public static final int NIVEL_LOGGER_DEFECTO=9;
	
	// Log4j
	public static final int NIVEL_LOGGER_OFF=0;
	public static final int NIVEL_LOGGER_ALL=1;
	public static final int NIVEL_LOGGER_INFO=6;
	public static final int NIVEL_LOGGER_FATAL=10;
	public static final int NIVEL_LOGGER_ERROR=11;
	public static final int NIVEL_LOGGER_WARN=12;
	public static final int NIVEL_LOGGER_DEBUG=13;
	
	
	// Email and uploader implementation
	public static final String EMAIL_FROM_ADDRESS=Entorno.obtenerVariable("email.emailFromAddress","jealdana@gmail.com");
	public static final String EMAIL_HOST_NAME=Entorno.obtenerVariable("email.smtp.host.name","192.168.40.93");
	public static final String EMAIL_PORT=Entorno.obtenerVariable("email.smtp.port","25");
	public static final String EMAIL_SSL_ENABLED=Entorno.obtenerVariable("email.ssl.enabled","false");
	public static final String EMAIL_FROM_USER=Entorno.obtenerVariable("email.smtp.usuario","jaldana");
	public static final String EMAIL_FROM_PASSWORD=Entorno.obtenerVariable("email.smtp.contrasenia","Metalsa1937");
	public static final String EMAIL_ADMINISTRADOR_MEDS=Entorno.obtenerVariable("email.administrador.meds","jesus.aldana@metalsa.com");
	public static final String EMAIL_ADMINISTRADOR_TECWEB=Entorno.obtenerVariable("email.administrador.tecweb","jesus.aldana@metalsa.com");
	
	
	public static final String UPLOAD_FOLDER=Entorno.obtenerVariable("uploader.temporary.path.windows.meds","");
	//public static final String UNIX_UPLOAD_FOLDER=Entorno.obtenerVariable("uploader.unix.meds","/Users/JEAS/Documents/1-Metalsa/Workspaces/MeFTPServer/src/com/metalsa/meftp/server/files/");
	public static final String UNIX_UPLOAD_FOLDER=Entorno.obtenerVariable("uploader.temporary.path.unix.meds","/home/medsuser/MeFTPServer/tmpUploadFiles/"); 
	public static final String EMAIL_NOT_SENT= "Email not SENT";
	public static final String DATA_BASE_EROR_MESSAGE="Do not saved in database";
	public static final String UPLOAD_FILE_EMPTY="Upload file is empty";
	public static final String WELCOME_USER="Welcome to MeFTP System";
	public static final String WELCOME_USER_BODY="You have been added to MeFTP System";
	// Persistence unit define
	public static final String PERSISTENCEUNITNAME=Entorno.obtenerVariable("persistence.unit.name","MeFTPServerEntity");
	public static final String PERSISTENCEUNITDRIVER=Entorno.obtenerVariable("persistence.unit.driver", "org.hsqldb.jdbc.JDBCDriver");
	public static final String PERSISTENCEUNITSERVERNAME=Entorno.obtenerVariable("persistence.unit.server.name","localhost");
	public static final String PERSISTENCEUNITPORTNUMBER=Entorno.obtenerVariable("persistence.unit.port.number","9001");
	public static final String PERSISTENCEUNITDATABASENAME=Entorno.obtenerVariable("persistence.unit.database.name","TestMeFTPBaseDeDatos");
	public static final String PERSISTENCEUNITUSERNAME=Entorno.obtenerVariable("persistence.unit.user.name","SA");
	public static final String PERSISTENCEUNITUSERPASSWORD=Entorno.obtenerVariable("persistence.unit.user.password","");
	
	
}
