package com.metalsa.meftp.journaltab;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.metalsa.meftp.utils.Constantes;

public class AddJournalRegister {
	
private static AddJournalRegister INSTANCE = null;
	
	private synchronized static void createInstance(){
		if(INSTANCE == null){
			INSTANCE = new AddJournalRegister();
		}
	}
	
	public static AddJournalRegister getInstance(){
		try{
			if(INSTANCE ==  null){
				createInstance();
			}
		}catch(Exception e){
			
		}
		return INSTANCE;
	}
	
	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}
	
	protected void finalize() throws Exception{
		
	}
	
	public void addJournalEvent(String registerName,String loginName, int flag){
		
		String datesql = new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(new Timestamp(new java.util.Date().getTime()));
		IMeftpJournalTdDAO journalDAO= new MeftpJournalTdDAO();
		String eventComments = "";	
		
		switch(flag){
			
			case 1 : 	
					eventComments = registerName + " " + Constantes.saveNewUserComments;
		  			journalDAO.save(new MeftpJournalTd(Constantes.saveNewUser, eventComments, "GUSTAVO", datesql));
		  			break;
		  			
			case 2 :
					eventComments = registerName + " " + Constantes.saveNewSubgroupComments;
					journalDAO.save(new MeftpJournalTd(Constantes.saveNewSubgroup, eventComments, "GUSTAVO", datesql));
					break;
					
			case 3 :
					eventComments = registerName + " " + Constantes.saveNewGroupCommentes;
					journalDAO.save(new MeftpJournalTd(Constantes.saveNewGroup, eventComments, "GUSTAVO", datesql));
					break;
					
			case 4 :
					eventComments = registerName + " " + Constantes.saveChangesUserComments;
					journalDAO.save(new MeftpJournalTd(Constantes.saveChangesUser, eventComments, "GUSTAVO", datesql));
					break;
					
			case 5 :
					eventComments = registerName + " " + Constantes.saveChangesSubgroupsComments;
					journalDAO.save(new MeftpJournalTd(Constantes.saveChangesSubgroup, eventComments, "GUSTAVO", datesql));
					break;
					
			case 6 : 
					eventComments = registerName + " " + Constantes.saveChangesGroupsComments;
					journalDAO.save(new MeftpJournalTd(Constantes.saveChangesGroup, eventComments, "GUSTAVO", datesql));
					break;
					
			case 7 : 
					eventComments = registerName + " " + Constantes.deleteUserComments;
					journalDAO.save(new MeftpJournalTd(Constantes.deleteUser, eventComments, "GUSTAVO",datesql));
					break;
					
			case 8 :
					eventComments = registerName + " " + Constantes.deleteSubgroupComments;
					journalDAO.save(new MeftpJournalTd(Constantes.deleteSubgroup, eventComments, "GUSTAVO", datesql));
					break;
			case 9 : 
					eventComments = registerName + " " + Constantes.deleteGroupComments;
					journalDAO.save(new MeftpJournalTd(Constantes.deleteGroup, eventComments, "GUSTAVO", datesql));
					break;
			case 10 : 
					eventComments = registerName + " " + Constantes.loginUserComments;
					journalDAO.save(new MeftpJournalTd(Constantes.loginUser, eventComments, "GUSTAVO", datesql));
					break;
			default : 
					journalDAO.save(new MeftpJournalTd("default","default","default",datesql));
					break;
		}
		
	}
}
