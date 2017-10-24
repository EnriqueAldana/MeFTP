

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.*;
import com.metalsa.meftp.utils.Constantes;

/**
 * @author MyEclipse Persistence Tools
 */
public class LogLevel {
	
	// Variable de instancia estatico
	private static LogLevel INSTANCE = null;
	
	private static final  Logger logger;
	private static  int valorlogger;
	static {
		
		logger = Logger.getLogger("MEDS_Server");
				
		}
		public LogLevel(Properties properties) throws IOException{
			try{
				valorlogger=Integer.parseInt(properties.getProperty("log.level"));
				}catch ( java.lang.NumberFormatException e)
				{
					valorlogger=Constantes.NIVEL_LOGGER_DEFECTO;
				}
				// OFF, FATAL, ERROR, WARN, INFODEBUG and ALL
				//	public static final int NIVEL_LOGGER_OFF=0;
				//	public static final int NIVEL_LOGGER_ALL=1;
				//	public static final int NIVEL_LOGGER_FATAL=10;
				//	public static final int NIVEL_LOGGER_ERROR=11;
				//	public static final int NIVEL_LOGGER_WARN=12;
				//	public static final int NIVEL_LOGGER_INFODEBUG=13;
				switch (valorlogger)
				{
				
						case Constantes.NIVEL_LOGGER_OFF:
							logger.setLevel(Level.OFF);
							break;
						case Constantes.NIVEL_LOGGER_ALL:
							logger.setLevel(Level.ALL);
							break;
						case Constantes.NIVEL_LOGGER_FATAL:
							logger.setLevel(Level.FATAL);
							break;
						case Constantes.NIVEL_LOGGER_ERROR:
							logger.setLevel(Level.ERROR);
							break;
						case Constantes.NIVEL_LOGGER_WARN:
							logger.setLevel(Level.WARN);
							break;
						case Constantes.NIVEL_LOGGER_INFO:
							logger.setLevel(Level.INFO);
							break;
						case Constantes.NIVEL_LOGGER_DEBUG:
							logger.setLevel(Level.DEBUG);
							break;					
						
						default:
						
							logger.setLevel(Level.OFF);
				};
			
				//String logfile = properties.getProperty("input.filename.location") + File.separator+ properties.getProperty("CargaAutomaticaBOMArchivoLog.log");
				SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yyyy");
				Date fecha=new Date();
				String fechaAc = formato.format(fecha);
				PatternLayout defaultLayout = new PatternLayout("%p %c,line %L,%d{dd.MM.yyyy/HH:mm:ss},%m%n");
		        RollingFileAppender rollingFileAppender = new RollingFileAppender();
		        rollingFileAppender.setFile(properties.getProperty("MeFTPServer.file.logger.location")+ File.separator+Constantes.loggerNameFile+"_"+fechaAc+".log", true, false, 0);
		        //rollingFileAppender.setMaxFileSize("10MB");
		        //rollingFileAppender.setMaxBackupIndex(5);        
		        rollingFileAppender.setLayout(defaultLayout);

		        logger.removeAllAppenders();
		        logger.addAppender(rollingFileAppender);
		        logger.setAdditivity(false);


		        //log.info("Nueva Prueba.");
		        //log.info("Exiting application.");
			
		}
		// creador sincronizado para protegerse de posibles problemas  multi-hilo
	    // otra prueba para evitar instanciación múltiple 
	    private synchronized static void createInstance(Properties properties) throws MEDSServerException, IOException {
	        if (INSTANCE == null) { 
	        	
	            INSTANCE = new LogLevel(properties);
	        }
	    }
	    // Metodo para tomar una instancia unica
	    public static LogLevel getInstance(Properties properties) throws MEDSServerException, IOException {
	    	
	    	if (INSTANCE == null) {
	        	
	        	createInstance(properties);
	        }
	        return INSTANCE;
	    }
		
	  //El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
	    public Object clone() throws CloneNotSupportedException {
	            throw new CloneNotSupportedException(); 
	    }
	public static void log(String info, Priority info2, Throwable ex) {
    	logger.log(info2, info, ex);
    }
    
    public static Logger getLogger() {
    	return logger;
    }
	
    
}
