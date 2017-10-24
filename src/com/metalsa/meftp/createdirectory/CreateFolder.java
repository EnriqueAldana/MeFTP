package com.metalsa.meftp.createdirectory;

import java.io.File;
import java.io.IOException;

import com.metalsa.meftp.utils.Constantes;

public class CreateFolder {
	
	public static String createFolder(String userName) throws IOException{
		File folder = new File(Constantes.rutaUserHome+userName);
		folder.mkdirs();
		folder = new File(Constantes.rutaUserHome+userName+"/Inbox");
		folder.mkdirs();
		folder = new File(Constantes.rutaUserHome+userName+"/Outbox");
		folder.mkdirs();
		return Constantes.rutaUserHome+userName;
	}

}
