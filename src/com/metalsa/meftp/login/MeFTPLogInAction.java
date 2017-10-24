package com.metalsa.meftp.login;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.metalsa.meftp.user.IMeftpUsersTcDAO;
import com.metalsa.meftp.user.MeftpUsersTc;
import com.metalsa.meftp.user.MeftpUsersTcDAO;
import com.metalsa.meftp.utils.MEDSBaseAction;


@SuppressWarnings("deprecation")
public class MeFTPLogInAction extends MEDSBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InputStream inputStream;
	
	public String loginService(){
		String usernameLogin = request.getParameter("userLogin")!=null?request.getParameter("userLogin"):"";
	    String userPassword = request.getParameter("userPassword")!=null?request.getParameter("userPassword"):"";
		IMeftpUsersTcDAO loginDAO = new MeftpUsersTcDAO();
		JSONObject login = new JSONObject();
		JSONArray log = new JSONArray();
		
		
		boolean exists = loginDAO.findUserLoginAdmin(usernameLogin,userPassword);
		boolean clientexists = loginDAO.findUserLoginClient(usernameLogin, userPassword);
		if(exists == true){
			try{
				login.put("admin", true);
				login.put("success", true);
			}catch(JSONException jsone){
				jsone.printStackTrace();
			}
			log.put(login);
			session.put("logged-in", true);
			inputStream = new StringBufferInputStream(log.toString());
			return SUCCESS;
		}else if(clientexists == true){
			try{
				login.put("admin", false);
				login.put("success", true);
			}catch(JSONException jsone){
				jsone.printStackTrace();
			}
			log.put(login);
			session.put("logged-in", true);
			inputStream = new StringBufferInputStream(log.toString());
			return com.opensymphony.xwork2.Action.INPUT;
		}else{
			try{
				login.put("admin", false);
				login.put("success", false);
			}catch(JSONException jsone){
				jsone.printStackTrace();
			}
			log.put(login);
			inputStream = new StringBufferInputStream(log.toString());
			return ERROR;
			
		}
	}

	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
