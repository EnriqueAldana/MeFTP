package com.metalsa.meftp.utils;

import java.io.FileInputStream;
import java.util.PropertyResourceBundle;


import org.apache.log4j.Priority;


public final class Entorno {

	private static PropertyResourceBundle resourceBundle = null;
	private static final Entorno INSTANCIA = new Entorno();

	private static Entorno getInstancia() {
		return Entorno.INSTANCIA;
	}
	
	private Entorno() {
		inicia();
	}
	
	@SuppressWarnings("deprecation")
	private void inicia() {
		
		try {
			
			String nombreCompletoArchivoRecursos = Constantes.rutaArchivoConfiguracion;
			
			FileInputStream fis;
			fis = new FileInputStream(nombreCompletoArchivoRecursos);
			resourceBundle = new PropertyResourceBundle(fis);
			
		} catch (Exception ex) {
			 LogLevel.log("Fallo al cargar el archivo de variables de Entorno... :"+ ex.getMessage() , Priority.INFO, null);
			
		}
		
	}
	
	/**
	 * Obtiene el valor de una variable de Entorno de MIDAS
	 * @param nombreVariableEntorno Nombre de la variable de Entorno de MEDS en el archivo VariablesEntornoMIDAS.properties
	 * @param valorDefault Valor por defecto que regresara en caso de que exista un error al cargar la variable externa
	 * @return El valor de la variable que se encuentra en el archivo MeFTPServer.properties
	 */
	@SuppressWarnings("deprecation")
	public static String obtenerVariable(String nombreVariableEntorno, String valorDefault) {
		
		String valor = null;
		getInstancia();
		if (resourceBundle != null) {
			try {
				valor = resourceBundle.getString(nombreVariableEntorno);
			} catch (Exception ex) {
				 LogLevel.log("Fallo al cargar la variable de entorno: " + nombreVariableEntorno 
							+ " Se tomara el valor por defecto... ", Priority.INFO, null);	
				valor = valorDefault;
			}
		} else {
			valor = valorDefault;
		}
		
		return valor.trim();
	}
	
	
	
	
	
	
	
}
