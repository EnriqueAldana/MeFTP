package com.metalsa.meftp.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.transaction.SystemException;

import com.metalsa.meftp.utils.Constantes;



public class ByteArrayAttachment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombreArchivo;
	
	private TipoArchivo tipoArchivo;
	
	private byte[] contenidoArchivo;
	
	public static enum TipoArchivo {PDF, IMAGEN_JPG, TEXTO, HTML, DESCONOCIDO};
	
	/**
	 * Constructor
	 * @param nombreArchivo Nombre del archivo a adjuntar
	 * @param tipoArchivo Tipo del archivo a adjuntar
	 * @param contenidoArchivo El contenido del archivo en un arreglo de bytes
	 */
	public ByteArrayAttachment(String nombreArchivo, TipoArchivo tipoArchivo, byte[] contenidoArchivo) {
		this.nombreArchivo = nombreArchivo;
		this.tipoArchivo = tipoArchivo;
		this.contenidoArchivo = contenidoArchivo;
	}
	
	/**
	 * Constructor
	 * @param idControlArchivo id de control de archivos adjuntos de MEDS
	 * @throws SystemException , IOException
	 */
	public ByteArrayAttachment(String idControlArchivo)
		throws Exception {
		try {
			descargarArchivo(idControlArchivo);
		} catch (SystemException e) {
			throw new Exception(this.getClass().getSimpleName()+ "Error ");
		} catch (IOException ex) {
			throw new Exception(this.getClass().getSimpleName());
		}
		
	}
	
	private void descargarArchivo(String idControlArchivo)
			throws SystemException, IOException {
		String uploadFolder;
		
		if (System.getProperty("os.name").toLowerCase().indexOf("windows")!=-1)
			uploadFolder = Constantes.UPLOAD_FOLDER;
		else
			uploadFolder = Constantes.UNIX_UPLOAD_FOLDER;
		
		
		String fileName = idControlArchivo;
				
		File file = new File(uploadFolder + fileName);
		FileInputStream fin = new FileInputStream(file);
		byte byteArray[] = new byte[(int) file.length()];
		fin.read(byteArray);
		fin.close();
		
		this.nombreArchivo = idControlArchivo;
		establecerTipoArchivo(fileName);
		this.contenidoArchivo = byteArray;
		
		
	}

	
	
	
	private void establecerTipoArchivo (String nombreArchivo) {
		
		String extension = (nombreArchivo.lastIndexOf(".") == -1) ? "" : nombreArchivo
				.substring(nombreArchivo.lastIndexOf("."), nombreArchivo.length()).toUpperCase();
		
		
		if (extension.equals("PDF")) {
			this.tipoArchivo = TipoArchivo.PDF;
		} else if (extension.equals("JPG")) {
			this.tipoArchivo = TipoArchivo.IMAGEN_JPG;
		} else if (extension.equals("TXT")) {
			this.tipoArchivo = TipoArchivo.TEXTO;
		} else if (extension.equals("HTML")) {
			this.tipoArchivo = TipoArchivo.HTML;
		} else {
			this.tipoArchivo = TipoArchivo.DESCONOCIDO;
		}
		
		
	}
	
	
	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	/**
	 * @return the tipoArchivo
	 */
	public TipoArchivo getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * @param tipoArchivo the tipoArchivo to set
	 */
	public void setTipoArchivo(TipoArchivo tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	/**
	 * @return the contenidoArchivo
	 */
	public byte[] getContenidoArchivo() {
		return contenidoArchivo;
	}

	/**
	 * @param contenidoArchivo the contenidoArchivo to set
	 */
	public void setContenidoArchivo(byte[] contenidoArchivo) {
		this.contenidoArchivo = contenidoArchivo;
	}
	
	
}
