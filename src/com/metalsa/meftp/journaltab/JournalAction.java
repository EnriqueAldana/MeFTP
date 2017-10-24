package com.metalsa.meftp.journaltab;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class JournalAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4785310284211436153L;
	private List<MeftpJournalTd> serverList = null;
	private Boolean success = false;
	
	IMeftpJournalTdDAO journalDAO = new MeftpJournalTdDAO();

	public String execute(){
		
		Calendar resultDate = Calendar.getInstance();
		String datesql = new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(resultDate.getTime());
		resultDate.add(Calendar.DATE, -3);
		String datesql2 = new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(resultDate.getTime());
		
		serverList = journalDAO.journalDateSearch(datesql2, datesql);
		setSuccess(true);
		
		return SUCCESS;
		
	}
	
	public List<MeftpJournalTd> getServerList() {
		return serverList;
	}

	public void setServerList(List<MeftpJournalTd> serverList) {
		this.serverList = serverList;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
