package com.metalsa.meftp.advancedsearch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.metalsa.meftp.user.IMeftpUsersTcDAO;
import com.metalsa.meftp.user.MeftpUsersTc;
import com.metalsa.meftp.user.MeftpUsersTcDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserSearchAction extends ActionSupport {
	
	private List<MeftpUsersTc> userList = null;
	
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	private boolean success;
	String cmbValue =	request.getParameter("comboValue")!=null?request.getParameter("comboValue"):"";
	String cad 	=	request.getParameter("textValues")!=null?request.getParameter("textValues"):"";
	String date1 = request.getParameter("date1")!=null?request.getParameter("date1"):"";
	String date2 = request.getParameter("date2")!=null?request.getParameter("date2"):"";
	IMeftpUsersTcDAO userDao = new MeftpUsersTcDAO();
	
	public String advancedSearch(){
		
		//Busqueda general
		if(cmbValue != null && cad.equals("*")){	
				userList = userDao.findAll();
				setUserList(userList);
		}
		
		//Busqueda por rango de fechas
		else if(cmbValue.equals("8") || cmbValue.equals("9")){
				userList = userDao.findAdvancedSearch(cmbValue, date1, date2);
				setUserList(userList);
		}
		
		//Busqueda por cadena de valores ingresada a la caja de texto
		else if(cmbValue != "" && cad != ""){
				userList = userDao.findAdvancedSearch(cad, cmbValue);
				setUserList(userList);
		}
		
		else{
			userList = null;
			setSuccess(false);
		}
		
		setSuccess(true);
		return SUCCESS;
	}
	
	public void setUserList(List<MeftpUsersTc> userList) {
		this.userList = userList;
	}

	public List<MeftpUsersTc> getUserList() {
		return userList;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}
}