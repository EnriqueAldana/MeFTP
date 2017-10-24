package com.metalsa.meftp.email;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParseException;

public class ByteArrayDataSource implements DataSource {
	     private byte[] data; // data
	 private String  type; // content-type
	 private String  name = "";
	
	     /**
	      * Create a ByteArrayDataSource with data from the
	      * specified InputStream and with the specified MIME type.
	      * The InputStream is read completely and the data is
	      * stored in a byte array.
	      *
	      * @param is the InputStream
	      * @param type the MIME type
	      * @exception IOException errors reading the stream
	      */
	     public ByteArrayDataSource(InputStream is, String type) throws IOException {
	     ByteArrayOutputStream os = new ByteArrayOutputStream();
	     byte[] buf = new byte[8192];
	     int len;
	     while ((len = is.read(buf)) > 0)
	         os.write(buf, 0, len);
	     this.data = os.toByteArray();
	         this.type = type;
	     }
	
	     /**
	      * Create a ByteArrayDataSource with data from the
	      * specified byte array and with the specified MIME type.
	      *
	      * @param data the data
	      * @param type the MIME type
	      */
	     public ByteArrayDataSource(byte[] data, String type) {
	         this.data = data;
	     this.type = type;
	     }
	
	     /**
	      * Create a ByteArrayDataSource with data from the
	      * specified String and with the specified MIME type.
	      * The MIME type should include a <code>charset</code>
	      * parameter specifying the charset to be used for the
	      * string. If the parameter is not included, the
	      * default charset is used.
	      *
	      * @param data the String
	      * @param type the MIME type
	      * @exception IOException errors reading the String
	      */
	     public ByteArrayDataSource(String data, String type) throws IOException {
	     String charset = null;
	     try {
	         ContentType ct = new ContentType(type);
	         charset = ct.getParameter("charset");
	     } catch (ParseException pex) { }
	     if (charset == null)
	         charset = MimeUtility.getDefaultJavaCharset();
	     // XXX - could convert to bytes on demand rather than copying here
	 this.data = data.getBytes(charset);
	     this.type = type;
	     }
	
	     /**
	      * Return an InputStream for the data.
	      * Note that a new stream is returned each time
	      * this method is called.
	      *
	      * @return the InputStream
	      * @exception IOException if no data has been set
	      */
	     public InputStream getInputStream() throws IOException {
	     if (data == null)
	         throw new IOException("no data");
	     return new ByteArrayInputStream(data);
	     }
	
	     /**
	      * Return an OutputStream for the data.
	      * Writing the data is not supported; an <code>IOException</code>
	      * is always thrown.
	      *
	      * @exception IOException always
	      */
	     public OutputStream getOutputStream() throws IOException {
	     throw new IOException("cannot do this");
	     }
	
	     /**
	      * Get the MIME content type of the data.
	      *
	      * @return the MIME type
	      */
	     public String getContentType() {
	         return type;
	     }
	
	     /**
	      * Get the name of the data.
	      * By default, an empty string ("") is returned.
	      *
	      * @return the name of this data
	      */
	     public String getName() {
	         return name;
	     }
	
	     /**
	      * Set the name of the data.
	      *
	      * @param name the name of this data
	      */
	     public void setName(String name) {
	     this.name = name;
	     }
	 }


