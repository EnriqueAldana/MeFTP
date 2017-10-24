package com.metalsa.meftp.user;

import java.util.List;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Priority;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.metalsa.meftp.administration.MeFTPServerBO;
import com.metalsa.meftp.createdirectory.CreateFolder;
import com.metalsa.meftp.email.EMail;
import com.metalsa.meftp.journaltab.AddJournalRegister;
import com.metalsa.meftp.passwordgen.PassGenerate;
import com.metalsa.meftp.subgroup.IMeftpSubgroupsTcDAO;
import com.metalsa.meftp.subgroup.MeftpSubgroupsTc;
import com.metalsa.meftp.subgroup.MeftpSubgroupsTcDAO;
import com.metalsa.meftp.user.IMeftpUsersTcDAO;
import com.metalsa.meftp.user.MeftpUsersTc;
import com.metalsa.meftp.utils.Constantes;
import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MeFTPServerEmailException;
import com.metalsa.meftp.utils.MeFTPServerException;
import com.metalsa.meftp.utils.MeFTPUtils;

public class MeFTPUsersAction extends ActionSupport {
	
	private static final long serialVersionUID = -365606735675508099L;
	private HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	private IMeftpUsersTcDAO userDao = new MeftpUsersTcDAO();
	
	

	String datesql = MeFTPUtils.getInstance().getTodayDate();
	String meftpUsersUsername = request.getParameter("meftpUserName")!=null?request.getParameter("meftpUserName"):"default";
	String meftpUsersUsernamelogin = request.getParameter("meftpUserLogin")!=null?request.getParameter("meftpUserLogin"):"default";
	String meftpUsersUserpassword = request.getParameter("meftpUserPassword")!=null?request.getParameter("meftpUserPassword"):"default";
	Boolean meftpUsersUserwritepermission = Boolean.parseBoolean(request.getParameter("meftpUserWritePermission")!=null?request.getParameter("meftpUserWritePermission"):"false");
	Boolean meftpUsersUserenabledflag = Boolean.parseBoolean(request.getParameter("meftpUserenabled")!=null?request.getParameter("meftpUserenabled"):"false");
	Long meftpUserSubgroupid = Long.parseLong(request.getParameter("meftpUserSubgroupid")!=null?request.getParameter("meftpUserSubgroupid"):"0");
	Integer meftpUsersUseridletime = 300;
	String meftpUsersUsercreatedate = datesql;
	String meftpUsersUserexpires = request.getParameter("meftpUserExpirationDate")!=null?request.getParameter("meftpUserExpirationDate"):"";
	String meftpUsersUsercomments = request.getParameter("meftpUserComents")!=null?request.getParameter("meftpUserComents"):"";
	String meftpUsersEmailaddress = request.getParameter("meftpUserEmail")!=null?request.getParameter("meftpUserEmail"):"";
	Boolean meftpUsersEmailnotification = Boolean.parseBoolean(request.getParameter("meftpEmailNotification")!=null?request.getParameter("meftpEmailNotification"):"false");
	String dateExpiredTS = meftpUsersUserexpires + " 00:00:00.00";
	Boolean meftpUserAutoPass = Boolean.parseBoolean(request.getParameter("meftpUserAutoPass")!=null?request.getParameter("meftpUserAutoPass"):"false");
	
	List listades =null;
	
	@SuppressWarnings({ "static-access", "unchecked", "deprecation" })
	public String add() throws IOException, MeFTPServerException {
		IMeftpSubgroupsTcDAO subgroupDAO = new MeftpSubgroupsTcDAO();
		
		MeftpSubgroupsTc listaSG = subgroupDAO.findById(meftpUserSubgroupid);		
		
		String meftpUsersUserhomedirectory = CreateFolder.createFolder(meftpUsersUsername);
		
		if(meftpUserAutoPass == true){
			 PassGenerate.getInstance();
			meftpUsersUserpassword = PassGenerate.gen(8);
		}
		
		
		MeftpUsersTc newUser = new MeftpUsersTc(listaSG,meftpUsersUsername, meftpUsersUsernamelogin,
				meftpUsersUserpassword, meftpUsersUserhomedirectory, 
				 meftpUsersUserenabledflag, meftpUsersUserwritepermission, 
				 meftpUsersUseridletime, meftpUsersUsercreatedate, 
				 dateExpiredTS, meftpUsersUsercomments, 
				 meftpUsersEmailaddress, meftpUsersEmailnotification, 
				 false
				);
		userDao.save(newUser);
		AddJournalRegister.getInstance().addJournalEvent(meftpUsersUsername, null, Constantes.JOURNAL_FLAG_ONE);
		MeFTPServerBO.getInstance().meFTPLoadUsersFromMeFTPDatabaseConfig();
		
		if(meftpUsersEmailnotification == true){
			List<String> correo = new ArrayList<String>();
			correo.add(meftpUsersEmailaddress);
			try {
				EMail.getInstance().enviaCorreo(correo, Constantes.WELCOME_USER+ " "+ meftpUsersUsername, Constantes.WELCOME_USER_BODY);
			} catch (MeFTPServerEmailException e) {
				 listades.add(Constantes.EMAIL_ADMINISTRADOR_TECWEB);
		  		 try {
					EMail.getInstance().enviaCorreo(listades,Constantes.EMAIL_NOT_SENT +"for " + meftpUsersUsernamelogin,"");
				} catch (MeFTPServerEmailException e1) {
					LogLevel.log(Constantes.EMAIL_NOT_SENT+"for " + meftpUsersUsernamelogin, Priority.INFO, null);
				}
	    		
			}
		}
		
	return SUCCESS;
	}
	
	
	public String edit() throws IOException, MeFTPServerException {
		IMeftpSubgroupsTcDAO subgroupDAO = new MeftpSubgroupsTcDAO();
		
		MeftpSubgroupsTc listaSG2 = subgroupDAO.findById(meftpUserSubgroupid);
		String meftpUsersUserhomedirectory = CreateFolder.createFolder(meftpUsersUsername);
		long meftpUserId = Long.parseLong(request.getParameter("meftpUserId")!=null?request.getParameter("meftpUserId"):"0");
		MeftpUsersTc	updateUser	=	new MeftpUsersTc(meftpUserId,listaSG2,meftpUsersUsername, meftpUsersUsernamelogin,
				meftpUsersUserpassword, meftpUsersUserhomedirectory, 
				 meftpUsersUserenabledflag, meftpUsersUserwritepermission, 
				 meftpUsersUseridletime, meftpUsersUsercreatedate, 
				 dateExpiredTS, meftpUsersUsercomments, 
				 meftpUsersEmailaddress, meftpUsersEmailnotification, 
				 false);
	
		userDao.update(updateUser);
		AddJournalRegister.getInstance().addJournalEvent(meftpUsersUsername, null, Constantes.JOURNAL_FLAG_FOUR);
		MeFTPServerBO.getInstance().meFTPLoadUsersFromMeFTPDatabaseConfig();
		
		return SUCCESS;
	}
	
	
	public String delete() throws MeFTPServerException{
		long meftpUsersUserid = Long.parseLong(request.getParameter("meftpUserId")!=null?request.getParameter("meftpUserId"):"0");
		MeftpUsersTc deleteUser = new MeftpUsersTc();
		deleteUser.setMeftpUsersUserid(meftpUsersUserid);
		userDao.delete(deleteUser);
		AddJournalRegister.getInstance().addJournalEvent(meftpUsersUsername, null, Constantes.JOURNAL_FLAG_SEVEN);
		MeFTPServerBO.getInstance().meFTPLoadUsersFromMeFTPDatabaseConfig();
		return SUCCESS;
	}
	
	public IMeftpUsersTcDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IMeftpUsersTcDAO userDao) {
		this.userDao = userDao;
	}
}