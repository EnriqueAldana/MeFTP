package com.metalsa.meftp.groups;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.metalsa.meftp.journaltab.AddJournalRegister;
import com.metalsa.meftp.journaltab.IMeftpJournalTdDAO;

import com.metalsa.meftp.journaltab.MeftpJournalTdDAO;
import com.metalsa.meftp.utils.Constantes;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeFTPGroupsAction extends ActionSupport {

	/**
		 * 
		 */
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);

	private static final long serialVersionUID = 1L;
	private boolean success;
	IMeftpGroupsTcDAO groupDao = new MeftpGroupsTcDAO();
	IMeftpJournalTdDAO journalDAO = new MeftpJournalTdDAO();
	private List<MeftpGroupsTc> groupsList  = null;
	
	/**
	 * @value Search Parameters
	 **/
	String cmbValueg = request.getParameter("comboValueg") != null ? request.getParameter("comboValueg") : "";
	String cadg = request.getParameter("textValuesg") != null ? request.getParameter("textValuesg") : "";
	String date1g = request.getParameter("date1g") != null ? request.getParameter("date1g") : "";
	String date2g = request.getParameter("date2g") != null ? request.getParameter("date2g") : "";

	/**
	 * @values save and edit Parameters
	 **/
	String datesql = new SimpleDateFormat("yyyy-MM-dd H:mm:ss")
			.format(new Timestamp(new java.util.Date().getTime()));
	String meftpGroupId = request.getParameter("meftpGroupId") != null ? request
			.getParameter("meftpGroupId") : "";
	String meftpGroupName = request.getParameter("meftpGroupName") != null ? request
			.getParameter("meftpGroupName") : "";
	String meftpGroupDesc = request.getParameter("meftpGroupDesc") != null ? request
			.getParameter("meftpGroupDesc") : "";
	String meftpGroupEmail = request.getParameter("meftpGroupEmail") != null ? request
			.getParameter("meftpGroupEmail") : "";
	String meftpGroupExpirationDate = request
			.getParameter("meftpGroupExpirationDate") != null ? request
			.getParameter("meftpGroupExpirationDate") : "";
	Boolean meftpGroupenabled = Boolean.parseBoolean(request
			.getParameter("meftpGroupenabled") != null ? request
			.getParameter("meftpGroupenabled") : "false");
	String meftpGroupcreatedate = datesql;
	Boolean meftpGroupEmailNotification = Boolean.parseBoolean(request
			.getParameter("meftpGroupEmailNotification") != null ? request
			.getParameter("meftpGroupEmailNotification") : "");
	String meftpGroupComments = request
			.getParameter("meftpGroupComments") != null ? request
			.getParameter("meftpGroupComments") : "";
	String dateExpiredTSG = meftpGroupExpirationDate + " 00:00:00.00";

	/**
	 * CUD Methods
	 **/
	public String add() {
		
		MeftpGroupsTc newGroup = new MeftpGroupsTc(meftpGroupName,
				meftpGroupDesc, meftpGroupenabled, dateExpiredTSG,
				meftpGroupEmail, meftpGroupEmailNotification,
				meftpGroupcreatedate, meftpGroupComments);
		groupDao.save(newGroup);
		
		AddJournalRegister.getInstance().addJournalEvent(meftpGroupName, null, Constantes.JOURNAL_FLAG_THREE);
				
		return SUCCESS;
	}

	public String delete() {
		long meftpGroupId = Long
				.parseLong(request.getParameter("meftpGroupId") != null ? request
						.getParameter("meftpGroupId") : "0");

		MeftpGroupsTc deleteGroup = new MeftpGroupsTc();
		deleteGroup.setMeftpGroupsGroupid(meftpGroupId);
		groupDao.delete(deleteGroup);
		
		AddJournalRegister.getInstance().addJournalEvent(meftpGroupName, null, Constantes.JOURNAL_FLAG_SIX);
		
		return SUCCESS;
	}

	public String edit() {
		long meftpGroupId = Long
				.parseLong(request.getParameter("meftpGroupId") != null ? request
						.getParameter("meftpGroupId") : "0");
		MeftpGroupsTc editGroup = new MeftpGroupsTc(meftpGroupId,meftpGroupName,
				meftpGroupDesc, meftpGroupenabled, dateExpiredTSG,
				meftpGroupEmail, meftpGroupEmailNotification,
				meftpGroupcreatedate, meftpGroupComments);
		groupDao.update(editGroup);
		
		AddJournalRegister.getInstance().addJournalEvent(meftpGroupName, null, Constantes.JOURNAL_FLAG_SIX);
		return SUCCESS;
	}

	/**
	 * Advanced Search Method
	 **/
	public String advancedSearch() {

		/**
		 * find all search
		 **/
		if (cmbValueg != null && cadg.equals("*")) {
			groupsList = groupDao.findAll();
			setGroupsList(groupsList);
		}

		/**
		 * find data with range date
		 **/
		else if (cmbValueg.equals("7") || cmbValueg.equals("8")) {
			groupsList = groupDao.findAdvancedSearch(cmbValueg, date1g, date2g);
			setGroupsList(groupsList);
		}

		/**
		 * find data trough parameters give it by the user
		 **/
		else if (cmbValueg != "" && cadg != "") {
			groupsList = groupDao.findAdvancedSearch(cadg, cmbValueg);
			setGroupsList(groupsList);
		}

		/**
		 * Return a null list, avoids an action fail
		 **/
		else {
			groupsList = null;
			setSuccess(false);
		}

		setSuccess(true);
		return SUCCESS;
	}
	
	public String getList() {
		groupsList = groupDao.findAll();
		setGroupsList(groupsList);
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
	
	public List<MeftpGroupsTc> getGroupsList() {
		return groupsList;
	}

	public void setGroupsList(List<MeftpGroupsTc> groupsList) {
		this.groupsList = groupsList;
	}

}
