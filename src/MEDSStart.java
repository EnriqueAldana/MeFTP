

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Priority;
import com.metalsa.meftp.utils.Constantes;


/**
 * @author Jesus Enrique Aldana Sanchez
 * apunte en web.xml
 *  <listener>
 *       <listener-class>com.metalsa.meds.configuration.MEDSStart</listener-class>
 *   </listener>
 */
public class MEDSStart implements ServletContextListener {

	@SuppressWarnings("deprecation")
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		LogLevel.log("MeFTP Exception in contextDestroyed of MEDSStart :" , Priority.INFO, null);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		javax.servlet.ServletContext contexto = arg0.getServletContext();
		
		//Here starting Crone Jobs

		// This call Would be last into this method -- Here start MEDSserver
		try {
			System.out.println(Constantes.VERSION);
			System.out.println(Constantes.rutaArchivoConfiguracion);
			Properties properties = new Properties();
			properties.load(new FileInputStream(Constantes.rutaArchivoConfiguracion));
			Constantes.archiconfig=properties;
			LogLevel.getInstance(Constantes.archiconfig);
			LogLevel.log("MEDS server starting. " , Priority.INFO, null);
		
	} catch (IOException e){
		LogLevel.log("MEDS server exception in contextInitialized " , Priority.DEBUG, null);
		LogLevel.log("MEDS server exception in contextInitialized " , Priority.FATAL, null);
	} catch (MEDSServerException e) {
		LogLevel.log("MEDS server exception in Loglevel get instance " , Priority.FATAL, null);

		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	


	}

	
}



