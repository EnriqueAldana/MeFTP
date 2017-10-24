package com.metalsa.meftp.subgroup;

import com.metalsa.meftp.subgroup.LexerWORDSSubgroups;
import com.metalsa.meftp.subgroup.LexerNUMBERSSubgroups;
import com.metalsa.meftp.user.EntityManagerHelper;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * MeftpSubgroupsTc entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.metalsa.meftp.subgroup.MeftpSubgroupsTc
 * @author MyEclipse Persistence Tools
 */

public class MeftpSubgroupsTcDAO implements IMeftpSubgroupsTcDAO {
	
	public static final String MEFTP_SUBGROUPS_SUBGROUPNAME = "meftpSubgroupsSubgroupname";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved MeftpSubgroupsTc entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpSubgroupsTcDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpSubgroupsTc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpSubgroupsTc entity) {
		EntityManagerHelper.log("saving MeftpSubgroupsTc instance", Level.INFO,
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
	 * Delete a persistent MeftpSubgroupsTc entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpSubgroupsTcDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpSubgroupsTc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpSubgroupsTc entity) {
		EntityManagerHelper.log("deleting MeftpSubgroupsTc instance",
				Level.INFO, null);
		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(MeftpSubgroupsTc.class,
					entity.getMeftpSubgroupsSubgroupid());
			getEntityManager().remove(entity);
			EntityManagerHelper.commit();
			entity = null;
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved MeftpSubgroupsTc entity and return it or a
	 * copy of it to the sender. A copy of the MeftpSubgroupsTc entity parameter
	 * is returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = MeftpSubgroupsTcDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpSubgroupsTc entity to update
	 * @return MeftpSubgroupsTc the persisted MeftpSubgroupsTc entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MeftpSubgroupsTc update(MeftpSubgroupsTc entity) {
		EntityManagerHelper.log("updating MeftpSubgroupsTc instance",
				Level.INFO, null);
		try {
			EntityManagerHelper.beginTransaction();
			MeftpSubgroupsTc result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			EntityManagerHelper.commit();
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public MeftpSubgroupsTc findById(Long id) {
		EntityManagerHelper.log("finding MeftpSubgroupsTc instance with id: "
				+ id, Level.INFO, null);
		try {
			MeftpSubgroupsTc instance = getEntityManager().find(
					MeftpSubgroupsTc.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}
	
	public List<MeftpSubgroupsTc> findByMeftpSubgroupsSubgroupname(
			Object meftpSubgroupsSubgroupname, int... rowStartIdxAndCount) {
		return findByProperty(MEFTP_SUBGROUPS_SUBGROUPNAME,
				meftpSubgroupsSubgroupname, rowStartIdxAndCount);
	}
	
	/**
	 * Find all MeftpSubgroupsTc entities with match with the params.
	 * 
	 * @param valueCmb --> Give it by the user
	 * 				its a column in the table
	 *            
	 * @param value
	 *            the property value to match
	 * @return List<MeftpSubgroupsTc> found by query
	 */
	
	
	
	@SuppressWarnings("unchecked")
	public List<MeftpSubgroupsTc> findAdvancedSearch(String cmbValue,String date1,String date2) {
		String dateTimeStamp1 = date1 + " 00:00:00.000";
		String dateTimeStamp2 = date2 + " 00:00:00.000";
		String queryString = "";
		if(cmbValue.equals("8")){
				queryString = "select model from MeftpSubgroupsTc model where model.meftpSubgroupsSubgroupcreateddate between"+ " '"+dateTimeStamp1+"' "+"and"+" '"+dateTimeStamp2+"'" ;		
			
		}else if(cmbValue.equals("9")){
							
					queryString = "select model from MeftpSubgroupsTc model where model.meftpSubgroupsSubgroupexpireddate between"+ " '"+dateTimeStamp1+"' "+"and"+" '"+dateTimeStamp2+"'" ;
			
		}
		Query query = getEntityManager().createQuery(queryString);
		return query.getResultList();
	}
	
	/**
	 * Find the selected MeftpSubgroupsTc entities.
	 * 
	 * @param valueCmb --> Give it by the user
	 * 				its a column in the table
	 *            
	 * @param value
	 *            the property value to match
	 * @return List<MeftpSubgroupsTc> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpSubgroupsTc> findAdvancedSearch(String cad, String cmbValue) {
		try {
			long value = 0;
			String queryString = "";
			try {
				value = Long.parseLong(cmbValue);
			} catch (NumberFormatException nfe) {}
			
			if (value == 2 || value == 3 || value == 4 || value == 5 || value == 6 || value == 7) {
				LexerWORDSSubgroups.getInstance().validateString(cad, cmbValue);
				queryString = LexerWORDSSubgroups.getInstance().getNewResultQuery();
			} 			
			else if (value == 1 || value == 10) {
				LexerNUMBERSSubgroups.getInstance().validateNumber(cad, cmbValue);
				queryString = LexerNUMBERSSubgroups.getInstance().getNewResultQuery();
			}
			Query query = getEntityManager().createQuery(queryString);

			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("Cannot execute Advanced Search",
					Level.INFO, null);
			throw re;
		}
	}
	/**
	 * Find all MeftpSubgroupsTc entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MeftpSubgroupsTc property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<MeftpSubgroupsTc> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpSubgroupsTc> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding MeftpSubgroupsTc instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from MeftpSubgroupsTc model where model."
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
	 * Find all MeftpSubgroupsTc entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MeftpSubgroupsTc> all MeftpSubgroupsTc entities
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpSubgroupsTc> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all MeftpSubgroupsTc instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from MeftpSubgroupsTc model";
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
}