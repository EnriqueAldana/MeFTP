package com.metalsa.meftp.subgroup;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.*;

public class LexerWORDSSubgroups{
	/**
	 * 
	 */
	private static final long serialVersionUID = -423678976290101237L;
	
	private static LexerWORDSSubgroups INSTANCE = null;
	
	private String newResultQuery;
	
	private LexerWORDSSubgroups(){	
	}
	
	private synchronized static void createInstance(){
		if(INSTANCE == null){
			INSTANCE = new LexerWORDSSubgroups();
			System.out.println("Obteniendo instancia");
		}
	}

	public static LexerWORDSSubgroups getInstance(){
		try{
			if(INSTANCE == null)
				createInstance();
		}catch(Exception e){//cambiar a MEDSServerException
			System.out.println(e.getMessage());
			//LogLevel.log("MEDS EXCEPTION creating MEDSUserService")
		}
		return INSTANCE;
	}
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public void finalize() throws Exception{
		System.out.print("quitando instancia");
		INSTANCE = null;
	}
	
	public void validateString(String dato, String comboValue) {
		if (dato != null && comboValue != null) {
				tokenizeString(dato,comboValue);
		}else{
			JOptionPane.showMessageDialog(null, "Debe de llenar los campos");
		}
	}
	
	public void tokenizeString(String valor1,String comboValue) {
		ArrayList<String> tokenArray = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(valor1);
		String tok = "";
		while (st.hasMoreTokens()) {
			tok = st.nextToken();
			tokenArray.add(tok);
		}
		conversorString(tokenArray,comboValue);
	}

	
	public void conversorString(ArrayList<String> tokenedArray,String comboValue) {
		
		Object[] arrayConversor = tokenedArray.toArray();
		int size = arrayConversor.length;
		String arrayAux[] = new String[size];
		
		String aux = "";
		int flagAND = 0;
		int flagOR = 0;
		int flagCOMODIN = 0;
		
		int comboVal = Integer.parseInt(comboValue);
		
		for(int i = 0; i<size;i++){
			aux = arrayConversor[i].toString();
			
			if(aux.equalsIgnoreCase("*") && size==1){
			}else{
				if(aux.contains("*") && aux.contains("\"")){
					arrayAux[i] = (aux.replace("*", "%")).replace("\"", "\'");					
				}
				
				
				else if(aux.contains("*")){
					arrayAux[i] = "'" + aux.replace("*","%") +"'";
					flagCOMODIN ++;
				}
				
				
				else if(aux.compareTo("AND") == 0){
					arrayAux[i] = aux;
					flagAND ++;
				}
				
				else if(aux.compareTo("OR") == 0){
					arrayAux[i] = aux;
					flagOR ++;
				}
				
				else if(aux.contains("\"")){
					arrayAux[i] = aux.replace("\"","\'");
				}
				
				else{
					arrayAux[i] = "'"+aux+"'";
				}					
			}	
		}
		buildSubQuery(arrayAux,flagCOMODIN,flagAND,flagOR,comboVal);
		
	}
	
	
	public void buildSubQuery(String arrayAux[],int flagCOMODIN,int flagAND,int flagOR,int comboVal){
		SentencesSQLSubgroups ssql = new SentencesSQLSubgroups();
		int size = arrayAux.length;
		String newValue = "";
		
		if(flagCOMODIN >= 1 && flagAND >= 1 && flagOR >=1){
			for(int j=0;j<size;j++ ){
				newValue += ssql.sqlCOMODINANDOR(arrayAux[j],comboVal) + " ";
			}
			buildQuery(newValue);
		}
		
		else if(flagCOMODIN >= 1 && flagAND >= 1 && flagOR == 0){
			for(int j=0;j<size;j++ ){
				newValue += ssql.sqlCOMODINANDOR(arrayAux[j],comboVal) + " ";
			}
			buildQuery(newValue);
		}
		
		else if(flagCOMODIN >= 1 && flagAND == 0  && flagOR >= 1){
			for(int j=0;j<size;j++ ){
				newValue += ssql.sqlCOMODINANDOR(arrayAux[j],comboVal) + " ";
			}
			buildQuery(newValue);
		}
		
		else if(flagCOMODIN >= 1 && flagAND == 0  && flagOR == 0){
			for(int j=0;j<size;j++ ){
				newValue += ssql.sqlCOMODIN(arrayAux[j],comboVal) + " ";
			}
			buildQuery(newValue);
		}
		
		else if(flagCOMODIN == 0 && flagAND == 0  && flagOR >= 1){
			for(int j=0;j<size;j++ ){
				newValue += ssql.sqlOR(arrayAux[j],comboVal) + " ";
			}
			buildQuery(newValue);
		}
		
		else if(flagCOMODIN == 0 && flagAND >= 1  && flagOR == 0){
			String comboValue = ssql.getComboValue(comboVal);
			newValue = comboValue +" "+ "IN" + "(";
			for(int j=0;j<size;j++ ){
				if(j< size-1 && arrayAux[j].compareTo("AND")!=0){
					newValue +=  arrayAux[j]+",";
				}
				else if(j == size-1 && arrayAux[j].compareTo("AND")!=0){
					newValue += arrayAux[j] + ")";
				}
				
			}
			buildQuery(newValue);
		}
		
		else if(flagCOMODIN == 0 && flagAND == 0 && flagOR == 0){
			for(int j=0;j<size;j++ ){
				newValue += ssql.sqlWORD(arrayAux[j],comboVal) + " ";
			}
			buildQuery(newValue);
		}
		
		else{
			JOptionPane.showMessageDialog(null,"La cadena no es soportada");
		}
		
	}
		
	
	public void buildQuery(String subQuery){
		String query="";
		final String constant = "select model from MeftpSubgroupsTc model where ";
		query = constant + " " + subQuery;
		System.out.println(query);
		setNewResultQuery(query);
	}
	
	public void setNewResultQuery(String newResultQuery) {
		this.newResultQuery = newResultQuery;
	}

	public String getNewResultQuery() {
		return newResultQuery;
	}
	
}