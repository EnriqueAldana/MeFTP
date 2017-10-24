/**
 * 
 */
package com.metalsa.meftp.utils;

import org.apache.log4j.Priority;

/**
 * @author Jesus Enrique Aldana Sanchez.
 * Session management class
 */
public class MeFTPServerSessionManagement {
	private static MeFTPServerSessionManagement INSTANCE = null;
	private  MeFTPServerSessionManagement(){
		
	}
	
	private synchronized static void createInstance()  {
        if (INSTANCE == null) { 
            INSTANCE = new MeFTPServerSessionManagement();
        }
    }
    // Metodo para tomar una instancia unica
    @SuppressWarnings("deprecation")
	public static MeFTPServerSessionManagement getInstance() {
			
    		
    		if (INSTANCE == null) 
    		   createInstance();
            return INSTANCE;
	
    	
    }
	
  
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
	
    public static void invalidateSession(org.apache.struts2.dispatcher.SessionMap session){
	if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
	    try {
	        ((org.apache.struts2.dispatcher.SessionMap) session).invalidate();
	    } catch (IllegalStateException e) {
	    	LogLevel.log("MeFTP Exception can not invalidate session " , Priority.INFO, null);
	    }
	}
    }

}
