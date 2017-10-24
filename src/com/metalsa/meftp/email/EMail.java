package com.metalsa.meftp.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Authenticator;

import org.apache.log4j.Priority;

import com.metalsa.meftp.utils.Constantes;
import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MeFTPServerEmailException;

/**
 * @author Jesus Enrique Aldana Sanchez
 * Class for send a email from MEDS platform
 *
 */
public class EMail  {
	private static EMail INSTANCE = null;
	
	private static final String emailFromAddress = Constantes.EMAIL_FROM_ADDRESS;
    private static final String SMTP_HOST_NAME = Constantes.EMAIL_HOST_NAME;
	private static final String SMTP_PORT = Constantes.EMAIL_PORT;
	private static final String  SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	

	private EMail (){
		
	}
	
	/**
	 * Envia un correo sencillo desde la cuenta configurada del sistema
	 * @param destinatarios Destinatarios del correo
	 * @param titulo Titulo del correo
	 * @param contenido Contenido del correo
	 * @param adjuntos Rutas absolutas de archivos adjuntos al correo (en caso de haberlos)
	 * @throws MeFTPServerEmailException 
	 */
	@Deprecated
	public static void enviaCorreo(List<String> destinatarios, String titulo, String contenido, String[] adjuntos) throws MeFTPServerEmailException {
		try {
			sendMessage(destinatarios, titulo, contenido, emailFromAddress, adjuntos, null);
		} catch (MeFTPServerEmailException e) {
			throw new MeFTPServerEmailException("MeFTP Exception can not send message");
			
		}
		
	}
	
	/**
	 * Envia un correo sencillo desde la cuenta configurada del sistema
	 * @param destinatarios Destinatarios del correo
	 * @param titulo Titulo del correo
	 * @param contenido Contenido del correo
	 * @param adjuntos Listado de objetos archivo adjuntos al correo (en caso de haberlos)
	 * @throws MeFTPServerEmailException 
	 */
	public static void enviaCorreo(List<String> destinatarios, String titulo, String contenido, List<ByteArrayAttachment> adjuntos) throws MeFTPServerEmailException {
		try {
			sendMessage(destinatarios, titulo, contenido, emailFromAddress, null, adjuntos);
		} catch (MeFTPServerEmailException e) {
			throw new MeFTPServerEmailException("MeFTP Exception can not send message");
			
		}
		
	}
	
	/**
	 * Envia un correo sencillo desde la cuenta configurada del sistema
	 * @param destinatarios Destinatarios del correo
	 * @param titulo Titulo del correo
	 * @param contenido Contenido del correo
	 * @throws MeFTPServerEmailException 
	 */
	public static void enviaCorreo(List<String> destinatarios, String titulo, String contenido) throws MeFTPServerEmailException {
		try {
			sendMessage(destinatarios, titulo, contenido, emailFromAddress, null, null);
		} catch (MeFTPServerEmailException e) {
			throw new MeFTPServerEmailException("MeFTP Exception can not send message");
			
		}
		
	}
	
	/**
	 * Envia un correo sencillo de notificacion a los correos de los administradores de Midas y Sistemas Afirme
	 * @param titulo Titulo del correo
	 * @param contenido Contenido del correo
	 * @throws MeFTPServerEmailException 
	 */
	public static void enviaCorreoNotificacionAdmins(String titulo, String contenido) throws MeFTPServerEmailException {
		
		List<String> destinatarios = new ArrayList<String>();
		destinatarios.add(Constantes.EMAIL_ADMINISTRADOR_MEDS);
		destinatarios.add(Constantes.EMAIL_ADMINISTRADOR_TECWEB);
		
		Date fecha = new Date();
		
		contenido = contenido + " - Registrado el " + fecha;
		
		try {
			sendMessage(destinatarios, titulo, contenido, emailFromAddress, null, null);
		} catch (MeFTPServerEmailException e) {
			throw new MeFTPServerEmailException("MeFTP Exception can not send message");
			
		}
	}
	
	

	/**
	 * @param recipients
	 * @param subject
	 * @param messageContent
	 * @param from
	 * @param attachments 
	 * @throws MeFTPServerEmailException 
	 * @throws MessagingException
	 */
	private static void sendMessage(List<String> recipients, String subject,
			String messageContent, String from, String[] attachments, List<ByteArrayAttachment> fileAttachments) throws MeFTPServerEmailException {
		try {
			boolean debug = false;
			Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", SMTP_PORT);
			if(Constantes.EMAIL_SSL_ENABLED.equals("true")){
				props.put("mail.smtp.socketFactory.port", SMTP_PORT);
				props.put("mail.smtp.socketFactory.class", SSL_FACTORY);	
			}
			
			props.put("mail.smtp.socketFactory.fallback", "false");

			Session session = Session.getDefaultInstance(props,new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Constantes.EMAIL_FROM_USER, Constantes.EMAIL_FROM_PASSWORD);
				}
			});
			session.setDebug(debug);
			
			Message message = new MimeMessage(session);
			InternetAddress addressFrom = new InternetAddress(from);
			message.setFrom(addressFrom);
			for (Iterator<String> it = recipients.iterator(); it.hasNext();) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(
						(String) it.next()));
			}
			// Setting the Subject and Content Type
			message.setSubject(subject);
			// Create a message part to represent the body text
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(messageContent, "text/html");
			// use a MimeMultipart as we need to handle the file attachments
			Multipart multipart = new MimeMultipart();
			// add the message body to the mime message
			multipart.addBodyPart(messageBodyPart);
			
			// Crear la firma
			BodyPart firma = new MimeBodyPart();
			firma.setContent("MEDS platform - MeFTP application "+Constantes.AMBIENTE + " " + Constantes.VERSION + " " , "text/html");
			multipart.addBodyPart(firma);
			// add any file attachments to the message
			if(attachments != null && attachments.length > 0) {
				addAtachments(attachments, multipart);
			}
			if(fileAttachments != null && fileAttachments.size() > 0) {
				addAtachments(fileAttachments, multipart);
			}
			// Put all message parts in the message
			message.setContent(multipart);
	
			Transport.send(message);
			LogLevel.log("Envio de correo asertado " , Priority.INFO, null);
			
		}catch(RuntimeException r){
			LogLevel.log("Excepcion en el envio de Correo electronico " + r.getMessage(), Priority.INFO, null);
			LogLevel.log("Email host "+ SMTP_HOST_NAME, Priority.INFO, null);
			LogLevel.log("Email port "+ SMTP_PORT, Priority.INFO, null);
			LogLevel.log("Email user name "+ Constantes.EMAIL_FROM_USER, Priority.INFO, null);
			LogLevel.log("Email user password "+ Constantes.EMAIL_FROM_PASSWORD, Priority.INFO, null);
			throw new MeFTPServerEmailException("MeFTP Exception can not send message");	
		}catch(MessagingException me){
			LogLevel.log("Excepcion en el envio de Correo electronico "+ me.getMessage() , Priority.INFO, null);
			LogLevel.log("Email host "+ SMTP_HOST_NAME, Priority.INFO, null);
			LogLevel.log("Email port "+ SMTP_PORT, Priority.INFO, null);
			LogLevel.log("Email user name "+ Constantes.EMAIL_FROM_USER, Priority.INFO, null);
			LogLevel.log("Email user password "+ Constantes.EMAIL_FROM_PASSWORD, Priority.INFO, null);
		    throw new MeFTPServerEmailException("MeFTP Exception can not send message");	
		}
		catch (Exception mex) {
			LogLevel.log("Excepcion en el envio de Correo electronico "+ mex.getMessage(), Priority.INFO, null);
			LogLevel.log("Email host "+ SMTP_HOST_NAME, Priority.INFO, null);
			LogLevel.log("Email port "+ SMTP_PORT, Priority.INFO, null);
			LogLevel.log("Email user name "+ Constantes.EMAIL_FROM_USER, Priority.INFO, null);
			LogLevel.log("Email user password "+ Constantes.EMAIL_FROM_PASSWORD, Priority.INFO, null);
			throw new MeFTPServerEmailException("MeFTP Exception can not send message");
		}

	}

	protected static void addAtachments(String[] attachments, Multipart multipart)
			throws MessagingException, AddressException {
		for (int i = 0; i <= attachments.length - 1; i++) {
			String filename = attachments[i];
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			// use a JAF FileDataSource as it does MIME type detection
			DataSource source = new FileDataSource(filename);
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			// assume that the filename you want to send is the same as the
			// actual file name - could alter this to remove the file path
			String cleanFileName = filename.substring(filename.lastIndexOf("\\") + 1);
			attachmentBodyPart.setFileName(cleanFileName);
			// add the attachment
			multipart.addBodyPart(attachmentBodyPart);
		}
	}
	
	protected static void addAtachments(List<ByteArrayAttachment> files, Multipart multipart)
			throws MessagingException, AddressException {
		
		for (ByteArrayAttachment file : files) {
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			// ByteArrayDataSource as it does MIME type detection
			
			String tipoMIME = null;
			switch (file.getTipoArchivo()) {
			
				case PDF: {
					tipoMIME = "application/pdf";
					break;
				}
				case IMAGEN_JPG: {
					tipoMIME = "image/jpeg";
					break;
				}
				case TEXTO: {
					tipoMIME = "text/plain";
					break;
				}
				case HTML: {
					tipoMIME = "text/html";
					break;
				}
				case DESCONOCIDO: {
					tipoMIME = "application/unknown";
					break;
				}
				default : {
					tipoMIME = "application/unknown";
					break;
				}
			}
				
			DataSource source = new ByteArrayDataSource(file.getContenidoArchivo(), tipoMIME);
			
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			// assume that the filename you want to send is the same as the
			// actual file name - could alter this to remove the file path
			attachmentBodyPart.setFileName(file.getNombreArchivo());
			// add the attachment
			multipart.addBodyPart(attachmentBodyPart);
		}
	}
	
	
	public static  void sendEmailForRol(String rol,String titulo, String contenido){
	    /*if(rol==null){
		return;
	    }
	    List<String> destinatarios= new ArrayList<String>();
	    DummyFiller dummyFiller= new DummyFiller();
	    List<Usuario> usuariosPorRol= dummyFiller.obtieneUsuariosPorRol(rol);
	    if(usuariosPorRol!=null&&!usuariosPorRol.isEmpty() ){
		for(Usuario usuario:usuariosPorRol){
		    if(!UtileriasWeb.esCadenaVacia(usuario.getEmail())){
			destinatarios.add(usuario.getEmail());
		    }
		}
	    }
	    if(!destinatarios.isEmpty()){
	     sendMessage(destinatarios, titulo, contenido, emailFromAddress, null, null);
	    }*/
	}
	
	
	public static  void sendEmailForRols(String[] roles,String titulo, String contenido){
	   /* List<Usuario> usuariosPorRol;
	    List<String> destinatarios= new ArrayList<String>();
	    List<String> destinatariosPorRol;
	    DummyFiller dummyFiller= new DummyFiller();
	    if(roles==null || roles.length==0){
		return;
	    }
	    for(String rol:roles){
    	       usuariosPorRol= dummyFiller.obtieneUsuariosPorRol(rol);
        	  if(usuariosPorRol!=null&&!usuariosPorRol.isEmpty() ){
        		destinatariosPorRol=new ArrayList<String>();
        		for(Usuario usuario:usuariosPorRol){
        		    if(!UtileriasWeb.esCadenaVacia(usuario.getEmail())){
        			destinatariosPorRol.add(usuario.getEmail());
        		    }
        		}
        		if(!destinatariosPorRol.isEmpty()){
        		    destinatarios.addAll(destinatariosPorRol);
        		}
        	 }
	    }
	    if(!destinatarios.isEmpty()){
	      sendMessage(destinatarios, titulo, contenido, emailFromAddress, null, null);
	    }*/
	}
	

	
	/**
	 * Envia un correo sencillo de notificacion a los correos de los administradores de Midas 
	 * @param titulo Titulo del correo
	 * @param contenido Contenido del correo
	 * @throws MeFTPServerEmailException 
	 */
	public static void sendEmailForMEDSAdmin(String titulo, String contenido) throws MeFTPServerEmailException {
		
		List<String> destinatarios = new ArrayList<String>();
		destinatarios.add(Constantes.EMAIL_ADMINISTRADOR_MEDS);
			
		Date fecha = new Date();
		
		contenido = contenido + " - Updated " + fecha;
		
		try {
			sendMessage(destinatarios, titulo, contenido, emailFromAddress, null, null);
		} catch (MeFTPServerEmailException e) {
			throw new MeFTPServerEmailException("MeFTP Exception can not send message");
			
		}
	}
	/**
	 * Envia un correo sencillo de notificacion a los correos de los administradores de MEDS
	 * @param titulo Titulo del correo
	 * @param contenido Contenido del correo
	 * @throws MeFTPServerEmailException 
	 */
	public static void enviaCorreoNotificacionAdminsMEDS(String titulo, String contenido) throws MeFTPServerEmailException {
		
		List<String> destinatarios = new ArrayList<String>();
		destinatarios.add(Constantes.EMAIL_ADMINISTRADOR_TECWEB);
		
		Date fecha = new Date();
		
		contenido = contenido + " - Updated el " + fecha;
		
		try {
			sendMessage(destinatarios, titulo, contenido, emailFromAddress, null, null);
		} catch (MeFTPServerEmailException e) {
			throw new MeFTPServerEmailException("MeFTP Exception can not send message");
			
		}
	}
	
	
	private synchronized static void createInstance() throws MeFTPServerEmailException {
        if (INSTANCE == null) { 
            INSTANCE = new EMail();
        }
    }
    // Metodo para tomar una instancia unica
    @SuppressWarnings("deprecation")
	public static EMail getInstance() throws MeFTPServerEmailException {
			try {
    		
    		if (INSTANCE == null) 
    		   createInstance();
            return INSTANCE;
		} catch (MeFTPServerEmailException ex) {
			System.out.println(ex.getMessage());
			LogLevel.log("MeFTP Exception creating EMail instance : " , Priority.INFO, null);
			throw new MeFTPServerEmailException("Exception creating EMail instance");
		}
    	
    }
	
  
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
	
	
	
	
}