package com.metalsa.meftp.user;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import com.metalsa.meftp.utils.Constantes;
/**
 * @author MyEclipse Persistence Tools
 */
public class EntityManagerHelper {
	
	private static  EntityManagerFactory emf; 
	private static final ThreadLocal<EntityManager> threadLocal;
	private static final Logger logger;

		@SuppressWarnings("unchecked")
		private static EntityManagerFactory getEntityManagerFactory() {
		   if (emf == null) {
			@SuppressWarnings("rawtypes")
			Map properties = new HashMap();
		      properties.put(PersistenceUnitProperties.JDBC_DRIVER, Constantes.PERSISTENCEUNITDRIVER);
		      properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:hsqldb:hsql://"+Constantes.PERSISTENCEUNITSERVERNAME+":"+Constantes.PERSISTENCEUNITPORTNUMBER+"/"+Constantes.PERSISTENCEUNITDATABASENAME);
		      properties.put(PersistenceUnitProperties.JDBC_USER, Constantes.PERSISTENCEUNITUSERNAME);
		      properties.put(PersistenceUnitProperties.JDBC_PASSWORD, Constantes.PERSISTENCEUNITUSERPASSWORD);   
		      emf = Persistence.createEntityManagerFactory(Constantes.PERSISTENCEUNITNAME, properties);
		   }
		   return emf;
		} 
	static {
		emf =getEntityManagerFactory();
		threadLocal = new ThreadLocal<EntityManager>();
		logger = Logger.getLogger(Constantes.PERSISTENCEUNITNAME);
		logger.setLevel(Level.ALL);
	}
		
	public static EntityManager getEntityManager() {
		EntityManager manager = threadLocal.get();		
		if (manager == null || !manager.isOpen()) {
			manager = emf.createEntityManager();
			threadLocal.set(manager);
		}
		return manager;
	}
	
	 public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        threadLocal.set(null);
        if (em != null) em.close();
    }
    
    public static void beginTransaction() {
    	getEntityManager().getTransaction().begin();
    }
    
    public static void commit() {
    	getEntityManager().getTransaction().commit();
    }  
    
    public static void rollback() {
    	getEntityManager().getTransaction().rollback();
    } 
    
    public static Query createQuery(String query) {
		return getEntityManager().createQuery(query);
	}
	
	public static void log(String info, Level level, Throwable ex) {
    	logger.log(level, info, ex);
    }
    
}
