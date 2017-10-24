package com.metalsa.meftp.advancedsearch;

import javax.swing.JOptionPane;

public class SentencesSQL {

	public String sqlCOMODINANDOR(String cad, int cmbValue) {
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);

		if (cad.contains("%")) {
			newValue = valueCombo + " " + "LIKE" + cad;
		}

		else if (cad.compareTo("AND") == 0) {
			newValue = cad;
		}

		else if (cad.compareTo("OR") == 0) {
			newValue = cad;
		}

		else {
			newValue = valueCombo + " " + "=" + cad;
		}
		return newValue;
	}

	public String sqlCOMODIN(String cad, int cmbValue) {
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);

		if (cad.contains("%")) {
			newValue = valueCombo + " " + "LIKE" + cad;
		} else {
			JOptionPane.showMessageDialog(null,
					"Cadena no permitida, pero si gustas continuar");
			newValue = valueCombo + " " + "=" + cad;
		}
		return newValue;
	}

	public String sqlOR(String cad, int cmbValue) {
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);

		if (cad.compareTo("OR") == 0) {
			newValue = cad;
		}

		else {
			newValue = valueCombo + " " + "=" + cad;
		}
		return newValue;
	}
	
	public String sqlNUMOR(String cad, int cmbValue) {
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);

		if (cad.compareTo("OR") == 0) {
			newValue = cad;
		}

		else {
			newValue = valueCombo + " " + "=" + cad;
		}
		return newValue;
	}
	
	public String sqlMAYORQUE(String cad, int cmbValue) {
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);

		if (cad.compareTo(">") == 0) {
			newValue = valueCombo + " " +cad;
		}

		else {
			newValue = cad;
		}
		return newValue;
	}
	
	
	public String sqlMENORQUE(String cad, int cmbValue) {
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);

		if (cad.compareTo("<") == 0) {
			newValue = valueCombo + " " +cad;
		}

		else {
			newValue = cad;
		}
		return newValue;
	}
	
	
	public String sqlWORD(String cad, int cmbValue) {
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);
		newValue += valueCombo + "=" + cad;
		return newValue;
	}
	
	public String sqlNUMBER(String cad, int cmbValue) {
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);
		newValue += valueCombo + "=" + cad;
		return newValue;
	}
	
	
	public String sqlANDORNUMBER(String cad, int cmbValue){
		String newValue = "";
		String valueCombo = getComboValue(cmbValue);
		if (cad.compareTo("AND") == 0) {
			newValue = cad;
		}

		else if (cad.compareTo("OR") == 0) {
			newValue = cad;
		}

		else {
			newValue = valueCombo + " " + "=" + cad;
		}
		return newValue;
	}
	
	public String sqlBTAND(String cad,int cmbValue){
		String newValue="";
		
		if(cad.compareTo("AND") == 0){
			newValue = cad;
		}
		
		else{
			newValue = cad;
		}

		return newValue;
	}
		
	public String getComboValue(int cmbValue) {
		String valueCombo = "";
		
		switch (cmbValue) {
		case 1:
			valueCombo = "model.meftpUsersUserid";
			break;
		case 2:
			valueCombo = "model.meftpUsersUsername";
			break;
		case 3:
			valueCombo = "model.meftpUsersUsernamelogin";
			break;
		case 4:
			valueCombo = "model.meftpUsersUserenabledflag";
			break;
		case 5:
			valueCombo = "model.meftpUsersUserwritepermission";
			break;
		case 6:
			valueCombo = "model.meftpUsersEmailaddress";
			break;
		case 7:
			valueCombo = "model.meftpUsersEmailnotification";
			break;
		}

		return valueCombo;
	}
	
	public static boolean validaNum(String Valor) {
		try {
			Integer.parseInt(Valor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
