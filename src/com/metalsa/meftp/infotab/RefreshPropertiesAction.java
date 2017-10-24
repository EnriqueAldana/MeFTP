package com.metalsa.meftp.infotab;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial", "deprecation" })
public class RefreshPropertiesAction extends ActionSupport {
	
	String CONFIGURATION_FILE 		= 	"com.metalsa.meftp.infotab.MeFTPServer";
	private InputStream inputStream;
	
	public String getProperties(){
		inputStream = new StringBufferInputStream(PropertiesReader.readProperties(CONFIGURATION_FILE).toString());
		return SUCCESS;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
