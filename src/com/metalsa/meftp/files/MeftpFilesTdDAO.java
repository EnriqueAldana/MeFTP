package com.metalsa.meftp.files;

import com.metalsa.meftp.user.EntityManagerHelper;
import com.metalsa.meftp.utils.LogLevel;
import com.metalsa.meftp.utils.MeFTPServerDBException;
import com.metalsa.meftp.utils.MeFTPServerEmailException;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Priority;

/**
 * A data access object (DAO) providing persistence and search support for
 * MeftpFilesTd entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.test.testFiles.MeftpFilesTd
 * @author MyEclipse Persistence Tools
 */

public class MeftpFilesTdDAO implements IMeftpFilesTdDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved MeftpFilesTd entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpFilesTdDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpFilesTd entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public Integer save(MeftpFilesTd entity) throws MeFTPServerDBException{
		EntityManagerHelper.log("saving MeftpFilesTd instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
			EntityManagerHelper.commit();
			return entity.getMeftpFilesFileid();
		} catch (RuntimeException re) {
			//EntityManagerHelper.log("save failed", Level.SEVERE, re);
			LogLevel.log("Error saving file«s data on MeFTP Data Base", Priority.FATAL, re);
			throw  new MeFTPServerDBException("Error saving file«s data on MeFTP Data Base");
		}
	}
	
	public void saveContent(byte[] content, int fileId){
		System.out.println("THis is the content: hi"+"and the fileId is: "+fileId);
		
	}

	/**
	 * Delete a persistent MeftpFilesTd entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpFilesTdDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpFilesTd entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpFilesTd entity) throws MeFTPServerDBException {
		EntityManagerHelper.log("deleting MeftpFilesTd instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(MeftpFilesTd.class,
					entity.getMeftpFilesFileid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
			EntityManagerHelper.commit();
			entity = null;
		} catch (RuntimeException re) {
			//EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			LogLevel.log("Error deleting file«s data on MeFTP Data Base", Priority.FATAL, re);
			throw  new MeFTPServerDBException("Error deleting file«s data on MeFTP Data Base");
		}
	}

	/**
	 * Persist a previously saved MeftpFilesTd entity and return it or a copy of
	 * it to the sender. A copy of the MeftpFilesTd entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = MeftpFilesTdDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpFilesTd entity to update
	 * @return MeftpFilesTd the persisted MeftpFilesTd entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	@SuppressWarnings("deprecation")
	public MeftpFilesTd update(MeftpFilesTd entity) throws MeFTPServerDBException {
		EntityManagerHelper.log("updating MeftpFilesTd instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			MeftpFilesTd result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			EntityManagerHelper.commit();
			return result;
		} catch (RuntimeException re) {
			//EntityManagerHelper.log("update failed", Level.SEVERE, re);
			LogLevel.log("Error deleting file«s data on MeFTP Data Base", Priority.FATAL, re);	
			throw  new MeFTPServerDBException("Error updating file«s data on MeFTP Data Base");
		}
	}

	public MeftpFilesTd findById(Integer id) {
		EntityManagerHelper.log("finding MeftpFilesTd instance with id: " + id,
				Level.INFO, null);
		try {
			MeftpFilesTd instance = getEntityManager().find(MeftpFilesTd.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all MeftpFilesTd entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MeftpFilesTd property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<MeftpFilesTd> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpFilesTd> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding MeftpFilesTd instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from MeftpFilesTd model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all MeftpFilesTd entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MeftpFilesTd> all MeftpFilesTd entities
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpFilesTd> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all MeftpFilesTd instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from MeftpFilesTd model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MeftpFilesTd> findAdvancedSearch(String cadf, String cmbValuef) {		 
		 try {
			long value = 0;
			String queryString = "";
			try {
				value = Long.parseLong(cmbValuef);
			} catch (NumberFormatException nfe) {
				EntityManagerHelper.log("Error in findAdvancedSearch Cannot Execute search Format Number Exception ",Level.INFO,null);
				throw nfe;
			}
			
			if (value == 2 || value == 3 || value == 4 || value == 5 || value == 6) {
				LexerWORDSFiles.getInstance().validateString(cadf, cmbValuef);
				queryString = LexerWORDSFiles.getInstance().getNewResultQuery();
			} 
			
			else if (value == 1) {
				LexerNUMBERSFiles.getInstance().validateNumber(cadf, cmbValuef);
				queryString = LexerNUMBERSFiles.getInstance().getNewResultQuery();
			}
			
			Query query = getEntityManager().createQuery(queryString);

			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("Cannot execute Advanced Search by Parameters",
					Level.INFO, null);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MeftpFilesTd> findAdvancedSearch(String cmbValuef, String date1f, String date2f) {
		
		try {
			String dateTimeStamp1 = date1f + " 00:00:00.000";
			String dateTimeStamp2 = date2f + " 00:00:00.000";
			String queryString = "";
			if(cmbValuef.equals("7")){
				queryString = "select model from MeftpGroupsTc model where model.meftpGroupsGroupcreateddate between"+ " '"+dateTimeStamp1+"' "+"and"+" '"+dateTimeStamp2+"'" ;		
			
			}else if(cmbValuef.equals("8")){
			
				queryString = "select model from MeftpGroupsTc model where model.meftpGroupsGroupexpireddate between"+ " '"+dateTimeStamp1+"' "+"and"+" '"+dateTimeStamp2+"'" ;		
			}
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		}catch(RuntimeException re){
			EntityManagerHelper.log("Cannot execute Advanced Search by Date", Level.INFO, null);
			throw re;
		}
	}

}