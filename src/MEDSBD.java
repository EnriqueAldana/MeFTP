


import org.apache.log4j.Priority;
import com.metalsa.meftp.utils.LogLevel;


/**
 * @author Jesus Enrique Aldana Sanchez
 * template for Singleton pattern
 *
 */
public class MEDSBD {
	private static MEDSBD INSTANCE = null;
	/*
	 * NOT setting static variables
	 */
	
		// Private constructor
	protected  MEDSBD()throws MEDSServerException {
	}
	
	private synchronized static void createInstance() throws MEDSServerException {
        if (INSTANCE == null) { 
            INSTANCE = new MEDSBD();
        }
    }
    // Metodo para tomar una instancia unica
    @SuppressWarnings("deprecation")
	public static MEDSBD getInstance() throws MEDSServerException {
			try {
    		
    		if (INSTANCE == null) 
    		   createInstance();
            return INSTANCE;
		} catch (MEDSServerException ex) {
			System.out.println(ex.getMessage());
			LogLevel.log("MeFTP Exception creating MEDSBD instance : " , Priority.INFO, null);
			throw new MEDSServerException("Exception creating MeFTPDatabase instance");
		}
    	
    }
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
	protected void finalize () throws MEDSServerException {
	}
	
	/*
	 * Implement custom methods
	 * 
	 */
	
}