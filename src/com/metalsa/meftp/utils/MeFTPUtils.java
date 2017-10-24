/**
 * 
 */
package com.metalsa.meftp.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


/**
 * @author JEAS
 *
 */
public class MeFTPUtils {
	
	private static MeFTPUtils INSTANCE = null;

	private MeFTPUtils(){
		
	}
	
	public  String getTodayDate(){
		
		String todayDate = new SimpleDateFormat(Constantes.TIME_STAMP_DB_FORMAT).format(new Timestamp(new java.util.Date().getTime()));
		
		return todayDate;
		
	}
	
	
	private synchronized static void createInstance()  {
        if (INSTANCE == null) { 
            INSTANCE = new MeFTPUtils();
        }
    }
    // Metodo para tomar una instancia unica
    @SuppressWarnings("deprecation")
	public static MeFTPUtils getInstance()  {
			if (INSTANCE == null) 
    		   createInstance();
            return INSTANCE;
    	
    }
	
  
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
	

}
