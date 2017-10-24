package com.metalsa.meftp.configurationtab;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeFTPConfigurationTabAction extends ActionSupport {

	/**
	 * 
	 */
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	private static final long serialVersionUID = -2780546335608636890L;	
	IMeftpServerTdDAO serverDAO = new MeftpServerTdDAO();
	
	List<String> propertiesList = null;
	List<MeftpServerTd> tablePropertiesList = null;
	List<String> tableKeyProperties = null;
	int i = 1;
	String meftpServerServername = request.getParameter("meftpServerName") != null ? request.getParameter("meftpServerName") : "";
	String meftpServerServersite = request.getParameter("meftpServerSite") != null ? request.getParameter("meftpServerSite") : "";
	String meftpServerServerenabled = request.getParameter("meftpServerEnabled") != null ? request.getParameter("meftpServerEnabled") : "";
	String meftpServerServerssl = request.getParameter("meftpServerSSLConnections") != null ? request.getParameter("meftpServerSSLConnections") : "";
	String meftpServerServerpassiveaddressip = request.getParameter("meftpServerPassiveAddress") != null ? request.getParameter("meftpServerPassiveAddress") : "";
	String meftpServerPassivextaddressip = request.getParameter("meftpServerPassiveExtAdddress") != null ? request.getParameter("meftpServerPassiveExtAdddress") : "";
	String meftpServerServerportsrange = request.getParameter("meftpSercerPassivePorts") != null ? request.getParameter("meftpSercerPassivePorts") : "";
	String meftpServerServerusersfilename = request.getParameter("meftpServerFileName") != null ? request.getParameter("meftpServerFileName") : "";
	String meftpServerServerfileloggerloc = request.getParameter("meftpServerFileLoggerLocation") != null ? request.getParameter("meftpServerFileLoggerLocation") : "";
	String meftpServerServerdatabasename = request.getParameter("meftpServerDatabaseName") != null ? request.getParameter("meftpServerDatabaseName") : "";
	String meftpServerServerdatabaseip =  request.getParameter("meftpServerDatabaseIp") != null ? request.getParameter("meftpServerDatabaseIp") : "";
	String meftpServerServerdatabaseloc = request.getParameter("meftpServerDatabaseLocation") != null ? request.getParameter("meftpServerDatabaseLocation") : "";
	String meftpServerServerloglevel = request.getParameter("meftpServerLogLevel") != null ? request.getParameter("meftpServerLogLevel") : "";
	String meftpServerServerdayspasswordlife = request.getParameter("meftpServerPasswordLife") != null ? request.getParameter("meftpServerPasswordLife") : "";
	String meftpServerServerdayssendingemail = request.getParameter("meftpServerEmailSending") != null ? request.getParameter("meftpServerEmailSending") : "";
	String meftpServerServermaximumsdays = request.getParameter("meftpServerMaximumsDays") != null ? request.getParameter("meftpServerMaximumsDays") : "";
	String meftpServerServerminimumsdays = request.getParameter("meftpServerMinimumsDays") != null ? request.getParameter("meftpServerMinimumsDays") : "";
	String meftpServerServerport = "2221";
	String meftpServerServeridletime = request.getParameter("meftpServerIdleTime") != null ? request.getParameter("meftpServerIdleTime") : "";

	public String saveProperties(){
		
		tablePropertiesList = serverDAO.findAll();
		for (MeftpServerTd c : tablePropertiesList) {
			tableKeyProperties.add(c.getMeftpServerServerkeypropertie());
		}
		
		String[] keyProp = (String[]) tableKeyProperties.toArray();
		
		propertiesList.add(1, meftpServerServerfileloggerloc);
		propertiesList.add(2, meftpServerServerloglevel);
		propertiesList.add(3, meftpServerServerdatabaseip);
		propertiesList.add(6, meftpServerServername);
		propertiesList.add(8, meftpServerServeridletime);
		propertiesList.add(11, meftpServerServerpassiveaddressip);
		propertiesList.add(12, meftpServerServerport);
		propertiesList.add(13, meftpServerServerdatabasename);
		propertiesList.add(14, meftpServerServersite);
		propertiesList.add(15, meftpServerServerdatabaseloc);
		propertiesList.add(16, meftpServerServerusersfilename);
		propertiesList.add(17, meftpServerServerportsrange);
		propertiesList.add(18, meftpServerPassivextaddressip);
		propertiesList.add(19, meftpServerServerenabled);
		propertiesList.add(20, meftpServerServerssl);
		propertiesList.add(21, meftpServerServerdayspasswordlife);
		propertiesList.add(22, meftpServerServerdayssendingemail);
		propertiesList.add(23, meftpServerServermaximumsdays);
		propertiesList.add(24, meftpServerServerminimumsdays);
		
		Iterator<String> iterarList =  propertiesList.iterator();
		while(iterarList.hasNext()){
			
			MeftpServerTd serverTd	= new MeftpServerTd(i,keyProp[i] ,propertiesList.get(i));
			serverDAO.update(serverTd);
			i++;
			
		}
		
		MeftpServerWriteProperties.actualizarProperties();
		return SUCCESS;
	}
}