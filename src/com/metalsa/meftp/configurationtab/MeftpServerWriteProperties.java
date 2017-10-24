package com.metalsa.meftp.configurationtab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.metalsa.meftp.utils.Constantes;

public class MeftpServerWriteProperties {
	static String meftpServerServername = null;
	static String meftpServerServersite = null;
	static Boolean meftpServerServerenabled = null;
	static Boolean meftpServerServerssl = null;
	static String meftpServerServerpassiveaddressip = null;
	static String meftpServerPassivextaddressip = null;
	static String meftpServerServerportsrange = null;
	static String meftpServerServerusersfilename = null;
	static String meftpServerServerfileloggerloc = null;
	static String meftpServerServerdatabasename = null;
	static String meftpServerServerdatabaseip = null;
	static String meftpServerServerdatabaseloc = null;
	static String meftpServerServerloglevel = null;
	static Integer meftpServerServerdayspasswordlife = null;
	static Integer meftpServerServerdayssendingemail = null;
	static Integer meftpServerServermaximumsdays = null;
	static Integer meftpServerServerminimumsdays = null;
	static String meftpServerServerport = null;
	static String meftpServerServeridletime = null;

	public static void actualizarProperties() {
		String sFichero = Constantes.rutaArchivoConfiguracion;
		File fichero = new File(sFichero);
		IMeftpServerTdDAO dao = new MeftpServerTdDAO();
		List<MeftpServerTd> list = null;

		/*list = dao.findServer(1);

		for (MeftpServerTd c : list) {
			meftpServerServername = c.getMeftpServerServername();
			meftpServerServersite = c.getMeftpServerServersite();
			meftpServerServerenabled = c.getMeftpServerServerenabled();
			meftpServerServerssl = c.getMeftpServerServerssl();
			meftpServerServerpassiveaddressip = c.getMeftpServerServerpassiveaddressip();
			meftpServerPassivextaddressip = c.getMeftpServerPassivextaddressip();
			meftpServerServerportsrange = c.getMeftpServerServerportsrange();
			meftpServerServerusersfilename = c.getMeftpServerServerusersfilename();
			meftpServerServerfileloggerloc = c.getMeftpServerServerfileloggerloc();
			meftpServerServerdatabasename = c.getMeftpServerServerdatabasename();
			meftpServerServerdatabaseip = c.getMeftpServerServerdatabaseip();
			meftpServerServerdatabaseloc = c.getMeftpServerServerdatabaseloc();
			meftpServerServerloglevel = c.getMeftpServerServerloglevel();
			meftpServerServerdayspasswordlife = c.getMeftpServerServerdayspasswordlife();
			meftpServerServerdayssendingemail = c.getMeftpServerServerdayssendingemail();
			meftpServerServermaximumsdays = c.getMeftpServerServermaximumsdays();
			meftpServerServerminimumsdays = c.getMeftpServerServerminimumsdays();
			meftpServerServerport = c.getMeftpServerServerport().toString();
			meftpServerServeridletime = c.getMeftpServerServeridletime().toString();
		}*/
		if (fichero.exists()) {

			System.out.println(meftpServerServername);

			Properties propFile, setProperties;

			propFile = loadProperties(sFichero);
			setProperties = alterProperties(propFile);
			saveProperties(setProperties, sFichero);

		} else {
			System.out.print("No Existe el archivo");
		}

	}

	private static void saveProperties(Properties p, String fileName) {

		OutputStream outPropFile;
		try {
			outPropFile = new FileOutputStream(fileName);
			p.store(outPropFile, "Properties File MeFTPServer");
			outPropFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(0);
		}

	}

	private static Properties loadProperties(String fileName) {

		InputStream inPropFile;
		Properties tempProp = new Properties();

		try {
			inPropFile = new FileInputStream(fileName);
			tempProp.load(inPropFile);
			inPropFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(0);
		}

		return tempProp;

	}

	@SuppressWarnings("rawtypes")
	private static Properties alterProperties(Properties p) {

		Properties newProps = new Properties();

		Enumeration enumProps = p.propertyNames();
		String key = "";

		while (enumProps.hasMoreElements()) {

			key = (String) enumProps.nextElement();

			if (key.equals("MeFTPServer.serverName")) {
				newProps.setProperty(key, meftpServerServername);
			} else if (key.equals("MeFTPServer.serverSite")) {
				newProps.setProperty(key, meftpServerServersite);
			} else if (key.equals("MeFTPServer.port")) {
				newProps.setProperty(key, meftpServerServerport);
			} else if (key.equals("MeFTPServer.PassiveAddress")) {
				newProps.setProperty(key, meftpServerServerpassiveaddressip);
			} else if (key.equals("MeFTPServer.PassiveExternalAddress")) {
				newProps.setProperty(key, meftpServerPassivextaddressip);
			} else if (key.equals("MeFTPServer.PassivePorts")) {
				newProps.setProperty(key, meftpServerServerportsrange);
			} else if (key.equals("MeFTPServer.IdleTime")) {
				newProps.setProperty(key, meftpServerServeridletime);
			} else if (key.equals("MeFTPServer.file.name.users")) {
				newProps.setProperty(key, meftpServerServerusersfilename);
			} else if (key.equals("MeFTPServer.file.logger.location")) {
				newProps.setProperty(key, meftpServerServerfileloggerloc);
			} else if (key.equals("MeFTPServer.database.ip")) {
				newProps.setProperty(key, meftpServerServerdatabaseip);
			} else if (key.equals("MeFTPServer.database.name")) {
				newProps.setProperty(key, meftpServerServerdatabasename);
			} else if (key.equals("MeFTPServer.database.location")) {
				newProps.setProperty(key, meftpServerServerdatabaseloc);
			} else if (key.equals("")) {
				newProps.setProperty(key, meftpServerServerloglevel);
			} else {
				newProps.setProperty(key, p.getProperty(key));
			}
		}
		return newProps;
	}
}
