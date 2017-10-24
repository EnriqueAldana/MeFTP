package com.metalsa.meftp.passwordgen;

import java.util.Random;

public class PassGenerate {
	
	private static PassGenerate INSTANCE = null;
	
	private synchronized static void createInstance(){
		if(INSTANCE == null){
			INSTANCE = new PassGenerate();
		}
	}
	
	public static PassGenerate getInstance(){
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
		 
	public static String gen(int length){
		Random rgen = new Random();
		byte decision, numValue;
		char charValue;
		
		StringBuilder sb = new StringBuilder();
		
		while(sb.length() < length){
			decision = (byte)rgen.nextInt(2);
			numValue = (byte)rgen.nextInt(10);
			charValue = (char)(rgen.nextInt(25) + 65);
			sb.append( (decision%2 == 0) ? ( charValue + "" ) : ( numValue + "") );
		}
		return sb.toString();
	}
}