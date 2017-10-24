import org.apache.log4j.Priority;

import com.metalsa.meftp.utils.LogLevel;

/**
 * 
 */

/**
 * @author enrique
 *
 */
public class MEDSUserBD  {


	private static MEDSUserBD INSTANCE = null;
	
		// Private constructor
	protected  MEDSUserBD()throws MEDSServerException {
		
		
	}

	private synchronized static void createInstance() throws MEDSServerException {
        if (INSTANCE == null) { 
            INSTANCE = new MEDSUserBD();
        }
    }
    // Metodo para tomar una instancia unica
    @SuppressWarnings("deprecation")
	public static MEDSUserBD getInstance() throws MEDSServerException {
			try {
    		
    		if (INSTANCE == null) 
    		   createInstance();
            return INSTANCE;
		} catch (MEDSServerException ex) {
			System.out.println(ex.getMessage());
			LogLevel.log("MeFTP Exception creating MEDSUserBD instance : " , Priority.INFO, null);
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
	
	public void testprint(){
		
		System.out.println("Instancia");
		
		
	}
	
	
	

}
