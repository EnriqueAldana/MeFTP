package com.metalsa.meftp.groups;

import com.metalsa.meftp.user.EntityManagerHelper;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * MeftpGroupsTc entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.metalsa.meftp.groups.MeftpGroupsTc
 * @author MyEclipse Persistence Tools
 */

public class MeftpGroupsTcDAO implements IMeftpGroupsTcDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved MeftpGroupsTc entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpGroupsTcDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpGroupsTc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpGroupsTc entity) {
		EntityManagerHelper.log("saving MeftpGroupsTc instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent MeftpGroupsTc entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpGroupsTcDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpGroupsTc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpGroupsTc entity) {
		EntityManagerHelper.log("deleting MeftpGroupsTc instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(MeftpGroupsTc.class,
					entity.getMeftpGroupsGroupid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
			EntityManagerHelper.commit();
			entity = null;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved MeftpGroupsTc entity and return it or a copy
	 * of it to the sender. A copy of the MeftpGroupsTc entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = MeftpGroupsTcDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpGroupsTc entity to update
	 * @return MeftpGroupsTc the persisted MeftpGroupsTc entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MeftpGroupsTc update(MeftpGroupsTc entity) {
		EntityManagerHelper.log("updating MeftpGroupsTc instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			MeftpGroupsTc result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			EntityManagerHelper.commit();
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public MeftpGroupsTc findById(Long id) {
		EntityManagerHelper.log(
				"finding MeftpGroupsTc instance with id: " + id, Level.INFO,
				null);
		try {
			MeftpGroupsTc instance = getEntityManager().find(
					MeftpGroupsTc.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all MeftpGroupsTc entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MeftpGroupsTc property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<MeftpGroupsTc> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpGroupsTc> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding MeftpGroupsTc instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from MeftpGroupsTc model where model."
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
	 * Find all MeftpGroupsTc entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MeftpGroupsTc> all MeftpGroupsTc entities
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpGroupsTc> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all MeftpGroupsTc instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from MeftpGroupsTc model";
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
	@Override
	public List<MeftpGroupsTc> findAdvancedSearch(String cmbValueg, String date1g, String date2g) {
		
		String dateTimeStamp1 = date1g + " 00:00:00.000";
		String dateTimeStamp2 = date2g + " 00:00:00.000";
		String queryString = "";
		try{
			if(cmbValueg.equals("7")){
				queryString = "select model from MeftpGroupsTc model where model.meftpGroupsGroupcreateddate between"+ " '"+dateTimeStamp1+"' "+"and"+" '"+dateTimeStamp2+"'" ;	
		}else if(cmbValueg.equals("8")){
							
					queryString = "select model from MeftpGroupsTc model where model.meftpGroupsGroupexpireddate between"+ " '"+dateTimeStamp1+"' "+"and"+" '"+dateTimeStamp2+"'" ;
			
		}
		EntityManagerHelper.log("Finding Data with the give it date range", Level.INFO, null);
		Query query = getEntityManager().createQuery(queryString);
		return query.getResultList();
		}catch(RuntimeException re){
			EntityManagerHelper.log("Cannot Execute search by date range", Level.SEVERE, re);
			throw re;
		}
		
	}

	
	/**
	 * Find the selected MeftpGroupsTc entities.
	 * 
	 * @param valueCmbg --> Give it by the user
	 * 				its a column in the table
	 *            
	 * @param value
	 *            the property value to match
	 * @return List<MeftpGroupsTc> found by query
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MeftpGroupsTc> findAdvancedSearch(String cadg, String cmbValueg) {
		try {
			long value = 0;
			String queryString = "";
			try {
				value = Long.parseLong(cmbValueg);
			} catch (NumberFormatException nfe) {}
			
			if (value == 2 || value == 3 || value == 4 || value == 5 || value == 6) {
				LexerWORDSGroups.getInstance().validateString(cadg, cmbValueg);
				queryString = LexerWORDSGroups.getInstance().getNewResultQuery();
			} 
			
			else if (value == 1) {
				LexerNUMBERSGroups.getInstance().validateNumber(cadg, cmbValueg);
				queryString = LexerNUMBERSGroups.getInstance().getNewResultQuery();
			}
			Query query = getEntityManager().createQuery(queryString);
			EntityManagerHelper.log("Finding Data with the give it parameters",Level.INFO,null);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("Cannot execute Advanced Search",
					Level.SEVERE, re);
			throw re;
		}
	}

}