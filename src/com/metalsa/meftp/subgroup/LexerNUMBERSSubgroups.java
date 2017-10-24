package com.metalsa.meftp.subgroup;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.*;

//import com.metalsa.dinamycquery.ConnectionQuery;

public class LexerNUMBERSSubgroups{
	/**
	 * 
	 */
	private static final long serialVersionUID = -423678976290101237L;
	
	private static LexerNUMBERSSubgroups INSTANCE = null;
	
	private String newResultQuery;
	
	private synchronized static void createInstance(){
		if(INSTANCE == null){
			INSTANCE = new LexerNUMBERSSubgroups();
		}
	}
	
	public static LexerNUMBERSSubgroups getInstance(){
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
	
	public void validateNumber(String dato, String comboValue) {
		if (dato != null && comboValue != null) {
				tokenizeString(dato, comboValue);
		} else {
			dato = "*"; 
			comboValue = "1";
		}
	}

	public void tokenizeString(String valor1, String comboValue) {
		ArrayList<String> tokenArray = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(valor1);
		String tok = "";
		while (st.hasMoreTokens()) {
			tok = st.nextToken();
			tokenArray.add(tok);
		}
		conversorNumber(tokenArray, comboValue);
	}

	public void conversorNumber(ArrayList<String> tokenedArray,
			String comboValue) {

		Object[] arrayConversor = tokenedArray.toArray();
		int size = arrayConversor.length;
		String arrayAux[] = new String[size];

		String aux = "";
		int flagAND = 0;
		int flagOR = 0;
		int flagMAYORQUE = 0;
		int flagMENORQUE = 0;
		int flagBT = 0;

		int comboVal = Integer.parseInt(comboValue);

		for (int i = 0; i < size; i++) {
			aux = arrayConversor[i].toString();
			if (aux.equalsIgnoreCase("*") && size == 1) {
			} else {
				if (aux.compareTo("<") == 0) {
					arrayAux[i] = aux;
					flagMENORQUE++;
				}

				else if (aux.compareTo(">") == 0) {
					arrayAux[i] = aux;
					flagMAYORQUE++;
				}

				else if (aux.compareTo("AND") == 0) {
					arrayAux[i] = aux;
					flagAND++;
				}

				else if (aux.compareTo("OR") == 0) {
					arrayAux[i] = aux;
					flagOR++;
				} else if (aux.compareTo("->") == 0) {
					arrayAux[i] = aux.replace("->", "AND");
					flagBT++;
				}

				else {
					arrayAux[i] = aux;
				}
			}
		}
		buildSubQuery(arrayAux, flagAND, flagOR, flagMAYORQUE, flagMENORQUE,
				flagBT, comboVal);

	}

	public void buildSubQuery(String arrayAux[], int flagAND, int flagOR,
			int flagMAYORQUE, int flagMENORQUE, int flagBT, int comboVal) {
		SentencesSQLSubgroups ssql = new SentencesSQLSubgroups();
		int size = arrayAux.length;
		String newValue = "";

		if (flagAND >= 1 && flagOR >= 1 && flagBT == 0 && flagMAYORQUE == 0
				&& flagMENORQUE == 0) {
			for (int j = 0; j < size; j++) {

				newValue += ssql.sqlANDORNUMBER(arrayAux[j], comboVal) + " ";
			}
			buildQuery(newValue);
		}

		else if (flagBT >= 1 && flagAND == 0 && flagOR == 0
				&& flagMAYORQUE == 0 && flagMENORQUE == 0) {
			String comboValue = ssql.getComboValue(comboVal);
			newValue = comboValue + " " + "BETWEEN" + " ";

			if (SentencesSQLSubgroups.validaNum(arrayAux[0]) == true
					&& SentencesSQLSubgroups.validaNum(arrayAux[2]) == true) {

				Long n1 = Long.parseLong(arrayAux[0]);
				Long n2 = Long.parseLong(arrayAux[2]);
				if (n1 > n2) {
					arrayAux[0] = n2.toString();
					arrayAux[2] = n1.toString();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"LA GRAMATICA ES INCORRECTA");
			}

			for (int j = 0; j < size; j++) {

				if (SentencesSQLSubgroups.validaNum(arrayAux[j]) == true) {

				}

				newValue += ssql.sqlBTAND(arrayAux[j], comboVal) + " ";
			}
			buildQuery(newValue);
		}

		else if (flagBT == 0 && flagAND == 0 && flagOR == 0
				&& flagMAYORQUE >= 1 && flagMENORQUE == 0) {
			for (int j = 0; j < size; j++) {
				newValue += ssql.sqlMAYORQUE(arrayAux[j], comboVal) + " ";
			}
			buildQuery(newValue);
		}

		else if (flagAND == 0 && flagOR == 0 && flagBT == 0 && flagMAYORQUE == 0 && flagMENORQUE >= 1) {
			for (int j = 0; j < size; j++) {
				newValue += ssql.sqlMENORQUE(arrayAux[j], comboVal) + " ";
			}
			buildQuery(newValue);
		}

		else if (flagAND == 0 && flagOR >= 1 && flagBT == 0
				&& flagMAYORQUE == 0 && flagMENORQUE == 0) {
			for (int j = 0; j < size; j++) {
				newValue += ssql.sqlNUMOR(arrayAux[j], comboVal) + " ";
			}
			buildQuery(newValue);
		}

		else if (flagAND >= 1 && flagOR == 0 && flagBT == 0
				&& flagMAYORQUE == 0 && flagMENORQUE == 0) {
			String comboValue = ssql.getComboValue(comboVal);
			newValue = comboValue + " " + "IN" + "(";
			for (int j = 0; j < size; j++) {
				if (j < size - 1 && arrayAux[j].compareTo("AND") != 0) {
					newValue += arrayAux[j] + ",";
				} else if (j == size - 1 && arrayAux[j].compareTo("AND") != 0) {
					newValue += arrayAux[j] + ")";
				}

			}
			buildQuery(newValue);
		}

		else if (flagBT == 0 && flagAND == 0 && flagOR == 0
				&& flagMAYORQUE == 0 && flagMENORQUE == 0) {
			for (int j = 0; j < size; j++) {
				newValue += ssql.sqlNUMBER(arrayAux[j], comboVal) + " ";
			}
			buildQuery(newValue);
		}

		else {
			JOptionPane.showMessageDialog(null, "La cadena no es soportada");
		}

	}

	public void buildQuery(String subQuery) {
		String query = "";
		final String constant = "select model from MeftpSubgroupsTc model where ";
		query = constant + " " + subQuery;
		setNewResultQuery(query);
	}

	public void setNewResultQuery(String newResultQuery) {
		this.newResultQuery = newResultQuery;
	}

	public String getNewResultQuery() {
		return newResultQuery;
	}
}