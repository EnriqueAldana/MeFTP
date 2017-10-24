package com.metalsa.meftp.infotab;

import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.metalsa.meftp.user.IMeftpUsersTcDAO;
import com.metalsa.meftp.user.MeftpUsersTcDAO;

public class PropertiesReader {
	
	
	
		public static JSONArray readProperties(String configFile) {
			IMeftpUsersTcDAO userDao = new MeftpUsersTcDAO();
		
			Number numberUsersEnabled = userDao.countEnabledUsers();
			Number numberUsersDisabled = userDao.countDisableUsers();
			
			ResourceBundle rb 		= 	ResourceBundle.getBundle(configFile);
			JSONArray arrayJson 	= 	new JSONArray();
			JSONObject prop 		= 	new JSONObject();
			
			String serverName 		= 	rb.getString("MeFTPServer.serverName")!=null?rb.getString("MeFTPServer.serverName"):"";
			String passAddIP 		= 	rb.getString("MeFTPServer.PassiveAddress")!=null?rb.getString("MeFTPServer.PassiveAddress"):"";
			String passExternAddIP 	= 	rb.getString("MeFTPServer.PassiveExternalAddress")!=null?rb.getString("MeFTPServer.PassiveExternalAddress"):"";
			String passPortsRange 	=	rb.getString("MeFTPServer.PassivePorts")!=null?rb.getString("MeFTPServer.PassivePorts"):"";
			String idleTime 		= 	rb.getString("MeFTPServer.IdleTime")!=null?rb.getString("MeFTPServer.IdleTime"):"";
			String fileNameUsers 	= 	rb.getString("MeFTPServer.file.name.users")!=null?rb.getString("MeFTPServer.file.name.users"):"";
			String fileNameUsersLoc = 	rb.getString("MeFTPServer.file.name.users.location")!=null?rb.getString("MeFTPServer.file.name.users.location"):"";
			String fileLoggerLoc 	= 	rb.getString("MeFTPServer.file.logger.location")!=null?rb.getString("MeFTPServer.file.name.users.location"):"";
			String dataBaseName 	= 	rb.getString("MeFTPServer.database.name")!=null?rb.getString("MeFTPServer.database.name"):"";
			String dataBaseIp 		= 	rb.getString("MeFTPServer.database.ip")!=null?rb.getString("MeFTPServer.database.ip"):"";
			String dataBaseLoc 		= 	rb.getString("MeFTPServer.database.location")!=null?rb.getString("MeFTPServer.database.location"):"";
			String logLevel 		= 	rb.getString("log.level")!=null?rb.getString("log.level"):"";
			
			try {
				prop.put("sN", 		serverName);
				prop.put("pAIP",	passAddIP);
				prop.put("pEAIP",	passExternAddIP);
				prop.put("pPR", 	passPortsRange);
				prop.put("iT", 		idleTime);
				prop.put("fNU", 	fileNameUsers);
				prop.put("fNUL", 	fileNameUsersLoc);
				prop.put("fLL", 	fileLoggerLoc);
				prop.put("dBN", 	dataBaseName);
				prop.put("dBIP", 	dataBaseIp);
				prop.put("dBL", 	dataBaseLoc);
				prop.put("lL", 		logLevel);
				prop.put("nUE",		numberUsersEnabled);
				prop.put("nDU", numberUsersDisabled);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			arrayJson.put(prop);
			return arrayJson;
		}
}