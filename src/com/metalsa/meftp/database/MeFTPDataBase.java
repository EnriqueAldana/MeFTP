package com.metalsa.meftp.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Priority;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;

import com.metalsa.meftp.administration.MeFTPServerBO;
//import com.metalsa.meftp.users.TOMeFTPUser;
import com.metalsa.meftp.user.MeftpUsersTc;
import com.metalsa.meftp.utils.Constantes;
import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MeFTPServerException;

/**
 * @author Jesus Enrique Aldana Sanchez
 *
 */
public class MeFTPDataBase {
	
	
	private static MeFTPDataBase INSTANCE = null;
	private static Server meFTPDataBase = null;
	private static Connection connectionDataBase=null;
	private static String location=null;
	private static String pathlocation=null;
		// Private constructor
	@SuppressWarnings("deprecation")
	private MeFTPDataBase()throws MeFTPServerException {
		// Load file porperties
		try {
			pathlocation=Constantes.archiconfig.getProperty("MeFTPServer.database.location");
			location=pathlocation+"/"+Constantes.archiconfig.getProperty("MeFTPServer.database.name");
			start();
			connectDataBase();
		} catch (IOException e) {
			LogLevel.log("MeFTP Exception path location or name of Data base are not correct : " , Priority.INFO, null);
			throw new MeFTPServerException("MeFTP Exception path location or name of Data base are not correct :");
	
		} catch (AclFormatException e) {
			LogLevel.log("MeFTP Exception path location or name of Data base are not correct : " , Priority.INFO, null);
			throw new MeFTPServerException("MeFTP Exception path location or name of Data base are not correct :");
	
		}catch (MeFTPServerException e) {
				LogLevel.log("MeFTP Exception path location or name of Data base are not correct " , Priority.INFO, null);
			throw new MeFTPServerException("MeFTP Exception path location or name of Data base are not correct :");
	
		}catch (NullPointerException npe){
			LogLevel.log("MeFTP Exception path location or name of Data base are not correct " , Priority.INFO, null);
			throw new MeFTPServerException("MeFTP Exception path location or name of Data base are not correct :");
	
		}
		
	}
	
	 // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    @SuppressWarnings("deprecation")
	public void start()throws IOException, AclFormatException, MeFTPServerException{
    	
        if (!isStarted()){
	        	HsqlProperties p = new HsqlProperties();
	            p.setProperty("server.database.0","file:"+location);
	            p.setProperty("server.dbname.0",Constantes.archiconfig.getProperty("MeFTPServer.database.name"));
	     		meFTPDataBase = new Server();
		        try {
		        	meFTPDataBase.setProperties(p);
				} catch (IOException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					throw new AclFormatException("MeFTP error IO into class MeFTPDataBase - loadAppFile() method");
				} catch (AclFormatException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					throw new AclFormatException("MeFTP error AclFormatException into class MeFTPDataBase - loadAppFile() method");
				}
				meFTPDataBase.setLogWriter(null); // can use custom writer
				meFTPDataBase.setErrWriter(null); // can use custom writer
				
				meFTPDataBase.start();
				LogLevel.log("MeFTP Data Base: " + "started", Priority.INFO, null);
				LogLevel.log("========== MeFTPDatabase server configurations =============" , Priority.INFO, null);
				LogLevel.log("Server product name : " + meFTPDataBase.getProductName(), Priority.INFO, null);
				LogLevel.log("Server product version : " + meFTPDataBase.getProductVersion(), Priority.INFO, null);
				LogLevel.log("Server Id : " + meFTPDataBase.getServerId().toString(), Priority.INFO, null);
				LogLevel.log("Server port : " + meFTPDataBase.getPort(), Priority.INFO, null);
				LogLevel.log("Server address : " + meFTPDataBase.getAddress(), Priority.INFO, null);
				LogLevel.log("Server protocolo : " + meFTPDataBase.getProtocol(), Priority.INFO, null);
				LogLevel.log("Server estatus : " + meFTPDataBase.getState(), Priority.INFO, null);
				LogLevel.log("Data Base name : " + meFTPDataBase.getDatabaseName(0, true), Priority.INFO, null);
				LogLevel.log("Data Base type : " + meFTPDataBase.getDatabaseType(0), Priority.INFO, null);
				LogLevel.log("Data Base name : " + meFTPDataBase.getDatabasePath(0, true), Priority.INFO, null);
				LogLevel.log("Path Location for MeFTP data base: " + pathlocation, Priority.INFO, null);
				
				// Conectar la Base de Datos
				this.connectDataBase();
				
				
				
        }
		
	}
    
    @SuppressWarnings("deprecation")
	public int stop(){
    	int ret=0;
    	if (meFTPDataBase!=null){
    		ret=meFTPDataBase.stop();
    		meFTPDataBase=null;
    		System.out.println("MeFTP Database stopped ");
    		LogLevel.log("MeFTP Database stopped " , Priority.INFO, null);
    	}
		return ret;
		
    	
    }

	private synchronized static void createInstance() throws MeFTPServerException {
        if (INSTANCE == null) { 
            INSTANCE = new MeFTPDataBase();
        }
    }
    // Metodo para tomar una instancia unica
    @SuppressWarnings("deprecation")
	public static MeFTPDataBase getInstance() throws MeFTPServerException {
			try {
    		
    		if (INSTANCE == null) 
    		   createInstance();
            return INSTANCE;
		} catch (MeFTPServerException ex) {
			System.out.println(ex.getMessage());
			LogLevel.log("MeFTP Exception creating MeFTPDatabase instance : " , Priority.INFO, null);
			throw new MeFTPServerException("Exception creating MeFTPDatabase instance");
		}
    	
    }
	
  
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
	
	
	
	@SuppressWarnings("deprecation")
	public void connectDataBase()throws MeFTPServerException{
		
		if (!isConnected()){
			
			try
			{
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
			} catch (Exception e)
			{
				System.out.println(e.getMessage());
				LogLevel.log("MeFTP Exception Database driver registration : " , Priority.INFO, null);
				throw new MeFTPServerException("MeFTP Exception Database driver registration");
			}
			
	    	try {
	    		// ;shutdown=true implica que se cierre la base de datos cuando la conexion se cierre.
	    		connectionDataBase = DriverManager.getConnection("jdbc:hsqldb:hsql://"+Constantes.archiconfig.getProperty("MeFTPServer.database.ip")+"/"+Constantes.archiconfig.getProperty("MeFTPServer.database.name")+";file:"+location+";shutdown=true", "SA", "");
	    		connectionDataBase.setAutoCommit(true);
	    		
	    	} catch (SQLException e) {
	    		   System.out.println(e.getMessage());
					LogLevel.log("MeFTP Exception can not connect to database : " , Priority.INFO, null);
					throw new MeFTPServerException("MeFTP Exception can not connect to database :");
			
				}
		}
		
	}
	public Boolean isConnected(){
		
		Boolean res;
		
		res= connectionDataBase ==  null ? false : true;
		
	return res;
		
	}
	public Boolean isStarted(){
		
		Boolean res;
		
		res= meFTPDataBase ==  null ? false : true;
		
	return res;
		
	}
	
	@SuppressWarnings("deprecation")
	public void disconnectionDataBase() throws MeFTPServerException{
	
	if (connectionDataBase!=null)
		try {
			connectionDataBase.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			LogLevel.log("MeFTP Exception can not disconnection to database : " , Priority.INFO, null);
			throw new MeFTPServerException("MeFTP Exception can not disconnection to database :");
	
		}
	
	}
	
	@SuppressWarnings("deprecation")
	public final void createMeFTPTable() throws MeFTPServerException{
		if(connectionDataBase!=null){
			// Preparamos el Insert
			try { 
				 java.sql.PreparedStatement stmDropSeq =  connectionDataBase.prepareStatement("DROP SEQUENCE IF EXISTS  SEQ_MEFTP_USERS_TC_IDUSER");
				stmDropSeq.executeUpdate();
				java.sql.PreparedStatement stmtCreateSeq =  connectionDataBase.prepareStatement("CREATE SEQUENCE SEQ_MEFTP_USERS_TC_IDUSER AS INTEGER START WITH 1 INCREMENT BY 1 MAXVALUE 999999999 MINVALUE 1 NO CYCLE");
				stmtCreateSeq.executeUpdate();
				java.sql.PreparedStatement stmDropTable =  connectionDataBase.prepareStatement("DROP TABLE IF EXISTS MEFTP_USERS_TC");
				stmDropTable.executeUpdate();
				String createtableStatment= "CREATE TABLE MEFTP_USERS_TC (" +
					"MEFTP_USERS_USERID  INTEGER GENERATED BY DEFAULT AS SEQUENCE SEQ_MEFTP_USERS_TC_IDUSER PRIMARY KEY NOT NULL ," +
					"MEFTP_USERS_USERNAME  VARCHAR(250) NOT NULL, " +
					"MEFTP_USERS_USERNAMELOGIN  VARCHAR(25) NOT NULL UNIQUE , " +
					"MEFTP_USERS_USERPASSWORD  VARCHAR(250) NOT NULL , " +
					"MEFTP_USERS__USERHOMEDIRECTORY VARCHAR(250) NOT NULL ," +
					"MEFTP_USERS_USERENABLEDFLAG BOOLEAN NOT NULL ," +
					"MEFTP_USERS_USERWRITEPERMISSION BOOLEAN NOT NULL ," +
					"MEFTP_USERS_USERIDLETIME  INTEGER NOT NULL ," +
					"MEFTP_USERS_USERCREATEDATE TIMESTAMP NOT NULL ," +
					"MEFTP_USERS_USEREXPIRES TIMESTAMP NOT NULL ," +
					"MEFTP_USERS_USERCOMMENTS  VARCHAR(250) NOT NULL)"; 
				java.sql.PreparedStatement stmtCreateTable =   connectionDataBase.prepareStatement(createtableStatment);
				stmtCreateTable.executeUpdate();
				
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				LogLevel.log("MeFTP Exception can not create MeFTP schema to database : " , Priority.INFO, null);
				throw new MeFTPServerException("MeFTP Exception can not create MeFTP schema to database :");
			}
				
		}
		
		
	}
	
	@SuppressWarnings("deprecation")
	public final void initalLoadAdminMeFTPUser() throws MeFTPServerException{
		
		if(connectionDataBase!=null){
			// Usuario : admin
			// Contraseña . admin
			String adminuser=null;
			adminuser= "INSERT INTO MEFTP_USERS_TC" +
					"(MEFTP_USERS_USERID , " +
					"MEFTP_USERS_USERNAME , " +
					"MEFTP_USERS_USERNAMELOGIN   ," +
					"MEFTP_USERS_USERPASSWORD ," +
					"MEFTP_USERS__USERHOMEDIRECTORY  ," +
					"MEFTP_USERS_USERENABLEDFLAG  ," +
					"MEFTP_USERS_USERWRITEPERMISSION  ," +
					"MEFTP_USERS_USERIDLETIME   ," +
					"MEFTP_USERS_USERCREATEDATE ," +
					"MEFTP_USERS_USEREXPIRES  ," +
					"MEFTP_USERS_USERCOMMENTS    )" +
					"VALUES" +
					"(" +
					"CURRENT VALUE FOR SEQ_MEFTP_USERS_TC_IDUSER," +
					"'MeFTP Administrator'," +
					"'MeFTPadmin'," +
					// contraseña admin
					"'MeFTPadminJEAS'," +
					// Metalsa 
					// "'/home/medsuser'," +
					"'"+Constantes.archiconfig.getProperty("MeFTPServer.homedirectory")+"'," +
					"'true'," +
					"'true'," +
					"300," +
					"CURRENT_DATE," +
					"CURRENT_DATE," +
					"'Este usuario tiene permisos de escritura '" +
					")";
			// Preparamos el Insert
			try {
				java.sql.PreparedStatement stmAdminUser =  connectionDataBase.prepareStatement(adminuser);
				stmAdminUser.executeUpdate();
							
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				LogLevel.log("MeFTP Exception can not insert MeFTP admin user to database : " , Priority.INFO, null);
				throw new MeFTPServerException("MeFTP Exception can not insert MeFTP admin user to database :");
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public final boolean pingMeFTP() throws MeFTPServerException{
		
		if(connectionDataBase!=null){
			// fIND 
			try {
				Statement stmt= connectionDataBase.createStatement();
				ResultSet rs = stmt.executeQuery("select MEFTP_USERS_USERID from MEFTP_USERS_TC");
			/*DatabaseMetaData metadata=	connectionDataBase.getMetaData();
			ResultSet rs = metadata.getTables(null, null, "%", null);*/
				
			while (rs.next()){
				/*Each table description has the following columns:

					TABLE_CAT String => table catalog (may be null)
					TABLE_SCHEM String => table schema (may be null)
					TABLE_NAME String => table name
					TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
					REMARKS String => explanatory comment on the table
					TYPE_CAT String => the types catalog (may be null)
					TYPE_SCHEM String => the types schema (may be null)
					TYPE_NAME String => type name (may be null)
					SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null)
					REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null)
					Note: Some databases may not return information for all tables.
*/
				//if(rs.getString(3).equals("MEFTP_USERS_TC")){
					return true;
				//}
				
			}
			
			//return false;
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				LogLevel.log("MeFTP Exception can not select MEFTP_USERS_TC table from MeFTP Data Base : " , Priority.INFO, null);
				throw new MeFTPServerException("MeFTP Exception can not select MEFTP_USERS_TC table from MeFTP Data Base :");
			}
				
		}else{
			System.out.println("MeFTP Exception there are connection to database for  select MEFTP_USERS_TC table from MeFTP Data Base : ");
			LogLevel.log("MeFTP Exception there are connection to database for  select MEFTP_USERS_TC table from MeFTP Data Base : " , Priority.INFO, null);
			throw new MeFTPServerException("MeFTP Exception there are connection to database for  select MEFTP_USERS_TC table from MeFTP Data Base :");
			
		}
		return false;
			
		
	}
	
	@SuppressWarnings("deprecation")
	public final  List <MeftpUsersTc> getMeFTPUsers() throws MeFTPServerException {
		List <MeftpUsersTc> listUsers= new ArrayList<MeftpUsersTc>();
		if(connectionDataBase!=null){
			Statement stmt;
			try {
				stmt = connectionDataBase.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM MEFTP_USERS_TC");
				while (rs.next()) {
					MeftpUsersTc tOMeFTPUser = new MeftpUsersTc();
					tOMeFTPUser.setMeftpUsersUserid(rs.getLong("MEFTP_USERS_USERID"));
					//tOMeFTPUser.setUserId(String.valueOf(rs.getInt("MEFTP_USERS_USERID")));
					tOMeFTPUser.setMeftpUsersUsername(rs.getString("MEFTP_USERS_USERNAME"));
					//tOMeFTPUser.setUserName(rs.getString("MEFTP_USERS_USERNAME"));
					tOMeFTPUser.setMeftpUsersUsernamelogin(rs.getString("MEFTP_USERS_USERNAMELOGIN"));
					//tOMeFTPUser.setUserNameLogin(rs.getString());
					tOMeFTPUser.setMeftpUsersUserpassword(rs.getString("MEFTP_USERS_USERPASSWORD"));
					//tOMeFTPUser.setUserPassword(rs.getString());
					tOMeFTPUser.setMeftpUsersUserhomedirectory(rs.getString("MEFTP_USERS__USERHOMEDIRECTORY"));
					//tOMeFTPUser.setUserHomeDirectory(rs.getString("MEFTP_USERS__USERHOMEDIRECTORY"));
					tOMeFTPUser.setMeftpUsersUserenabledflag(rs.getBoolean("MEFTP_USERS_USERENABLEDFLAG"));
					//tOMeFTPUser.setUserEnabledflag(Boolean.toString(rs.getBoolean("MEFTP_USERS_USERENABLEDFLAG")));
					tOMeFTPUser.setMeftpUsersUserwritepermission(rs.getBoolean("MEFTP_USERS_USERWRITEPERMISSION"));
					//tOMeFTPUser.setUserWritePermission(Boolean.toString(rs.getBoolean("MEFTP_USERS_USERWRITEPERMISSION")));
					tOMeFTPUser.setMeftpUsersUseridletime(rs.getInt("MEFTP_USERS_USERIDLETIME"));
					//tOMeFTPUser.setUserIdleTime(Integer.toString(rs.getInt("MEFTP_USERS_USERIDLETIME")));
					tOMeFTPUser.setMeftpUsersUsercreatedate(rs.getString("MEFTP_USERS_USERCREATEDATE"));
					//tOMeFTPUser.setUserCreateDate(rs.getTimestamp("MEFTP_USERS_USERCREATEDATE"));
					tOMeFTPUser.setMeftpUsersUserexpires(rs.getString("MEFTP_USERS_USEREXPIRES"));
					//tOMeFTPUser.setUserExpires(rs.getTimestamp("MEFTP_USERS_USEREXPIRES"));
					tOMeFTPUser.setMeftpUsersUsercomments(rs.getString("MEFTP_USERS_USERCOMMENTS"));
					//tOMeFTPUser.setUserComments(rs.getString("MEFTP_USERS_USERCOMMENTS"));
					listUsers.add(tOMeFTPUser);
					tOMeFTPUser=null;
					}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				LogLevel.log("MeFTP Exception can not get MeFTP Users: " , Priority.INFO, null);
				throw new MeFTPServerException("MeFTP Exception can not get MeFTP Users:");
		
			}
	}
		
		return listUsers;
		
		
	}
	
	protected void finalize () throws MeFTPServerException {
		
		if (MeFTPDataBase.getInstance().isConnected()){
			MeFTPDataBase.getInstance().disconnectionDataBase();
			}
		if (MeFTPDataBase.getInstance().isStarted()){
				MeFTPServerBO.getInstance().stop();
			}
		
	}
	
}