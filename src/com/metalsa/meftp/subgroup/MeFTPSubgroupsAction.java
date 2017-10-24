package com.metalsa.meftp.subgroup;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.metalsa.meftp.groups.IMeftpGroupsTcDAO;
import com.metalsa.meftp.groups.MeftpGroupsTc;
import com.metalsa.meftp.groups.MeftpGroupsTcDAO;
import com.metalsa.meftp.journaltab.AddJournalRegister;
import com.metalsa.meftp.utils.Constantes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeFTPSubgroupsAction extends ActionSupport {

	/**
	 * 
	 */
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	private static final long serialVersionUID = 1L;
	private boolean success;
	IMeftpSubgroupsTcDAO subgroupDao = new MeftpSubgroupsTcDAO();
	private List<MeftpSubgroupsTc> subgroupsList = null;
	
	/**
	 *@value Search Parameters
	 **/
	String cmbValuesg =	request.getParameter("comboValuesg")!=null?request.getParameter("comboValuesg"):"";
	String cadsg 	=	request.getParameter("textValuessg")!=null?request.getParameter("textValuessg"):"";
	String date1sg = request.getParameter("date1sg")!=null?request.getParameter("date1sg"):"";
	String date2sg = request.getParameter("date2sg")!=null?request.getParameter("date2sg"):"";
	
	/**
	 *@values save and edit Parameters
	 **/
	String 	datesql 			= 	new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(new Timestamp(new java.util.Date().getTime()));
	String 	meftpSubgroupName	= 	request.getParameter("meftpSubgroupName")!=null?request.getParameter("meftpSubgroupName"):"";
	String 	meftpSubgroupDesc 	= 	request.getParameter("meftpSubgroupDesc")!=null?request.getParameter("meftpSubgroupDesc"):"";
	String 	meftpSubgroupEmail 	= 	request.getParameter("meftpSubgroupEmail")!=null?request.getParameter("meftpSubgroupEmail"):"";
	String 	meftpSubgroupExpirationDate	= 	request.getParameter("meftpSubgroupExpirationDate")!=null?request.getParameter("meftpSubgroupExpirationDate"):"";
	Boolean meftpSubgroupenabled 	= 	Boolean.parseBoolean(request.getParameter("meftpSubgroupenabled")!=null?request.getParameter("meftpSubgroupenabled"):"false");
	String 	meftpUSubgroupcreatedate 	= 	datesql;
	String 	meftpSubgroupComents 	= 	request.getParameter("meftpSubgroupComents")!=null?request.getParameter("meftpSubgroupComents"):"";;
	Boolean meftpSubgroupEmailNotification = 	Boolean.parseBoolean(request.getParameter("meftpSubgroupEmailNotification")!=null?request.getParameter("meftpSubgroupEmailNotification"):"false");
	Long meftpSubgroupId = Long.parseLong(request.getParameter("meftpSubgroupId")!=null?request.getParameter("meftpSubgroupId"):"0");
	Long meftpSubgroupGroupId = Long.parseLong(request.getParameter("meftpSubgroupGroupId")!=null?request.getParameter("meftpSubgroupGroupId"):"0");
	String 	dateExpiredTSSG 	= 	meftpSubgroupExpirationDate + " 00:00:00.00";
	
	/**
	 * CUD Methods
	 **/
	public String add(){
		
		IMeftpGroupsTcDAO groupsDAO = new MeftpGroupsTcDAO();
		
		MeftpGroupsTc li = groupsDAO.findById(meftpSubgroupGroupId);
		//MeftpGroupsTc en = (MeftpGroupsTc) li.get(0);
		
		MeftpSubgroupsTc newSubgroup =  new MeftpSubgroupsTc(li,meftpSubgroupName,meftpSubgroupDesc,
															 meftpSubgroupenabled,dateExpiredTSSG,
															 meftpSubgroupEmail,meftpSubgroupEmailNotification,
															 meftpSubgroupComents,meftpUSubgroupcreatedate);
		subgroupDao.save(newSubgroup);
		AddJournalRegister.getInstance().addJournalEvent(meftpSubgroupName, null, Constantes.JOURNAL_FLAG_TWO);
		return SUCCESS;
	}
	
	public String delete(){
		MeftpSubgroupsTc deleteSubgroup =  new MeftpSubgroupsTc();
		deleteSubgroup.setMeftpSubgroupsSubgroupid(meftpSubgroupId);
		
		subgroupDao.delete(deleteSubgroup);
		AddJournalRegister.getInstance().addJournalEvent(meftpSubgroupName, null, Constantes.JOURNAL_FLAG_EIGHT);
		return SUCCESS;
	}
	
	public String edit(){
		
		IMeftpGroupsTcDAO groupsDAO = new MeftpGroupsTcDAO();
		
		MeftpGroupsTc li = groupsDAO.findById(meftpSubgroupGroupId);
		MeftpSubgroupsTc editSubgroup =  new MeftpSubgroupsTc(li,meftpSubgroupName,meftpSubgroupDesc,
				 meftpSubgroupenabled,dateExpiredTSSG,
				 meftpSubgroupEmail,meftpSubgroupEmailNotification,
				 meftpSubgroupComents,meftpUSubgroupcreatedate);
		subgroupDao.update(editSubgroup);
		AddJournalRegister.getInstance().addJournalEvent(meftpSubgroupName, null, Constantes.JOURNAL_FLAG_FIVE);
		
		return SUCCESS;
	}
	
	/**
	 * Advanced Search Method
	 **/
	public String advancedSearch(){
		/**
		 * find all search
		 **/
		if(cmbValuesg != null && cadsg.equals("*")){
			System.out.println("12546");
				subgroupsList = subgroupDao.findAll();
				setSubgroupsList(subgroupsList);
		}
		
		/**
		 *find data with range date 
		 **/
		else if(cmbValuesg.equals("8") || cmbValuesg.equals("9")){
				subgroupsList = subgroupDao.findAdvancedSearch(cmbValuesg, date1sg, date2sg);
				setSubgroupsList(subgroupsList);
		}
		
		/**
		 * find data trough parameters give it by the user
		 **/
		else if(cmbValuesg != "" && cadsg != ""){
				subgroupsList = subgroupDao.findAdvancedSearch(cadsg, cmbValuesg);
				setSubgroupsList(subgroupsList);
		}
		
		/**
		 * Return a null list, avoids an action fail
		 **/
		else{
			subgroupsList = null;
			setSuccess(false);
		}	
		
		setSuccess(true);
		return SUCCESS;
	}
	
	/**
	 * Getters and Setters
	 **/
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<MeftpSubgroupsTc> getSubgroupsList() {
		return subgroupsList;
	}

	public void setSubgroupsList(List<MeftpSubgroupsTc> subgroupsList) {
		this.subgroupsList = subgroupsList;
	}
}