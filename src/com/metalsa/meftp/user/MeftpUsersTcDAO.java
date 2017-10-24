package com.metalsa.meftp.user;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.metalsa.meftp.advancedsearch.LexerNUMBERS;
import com.metalsa.meftp.advancedsearch.LexerWORDS;

/**
 * A data access object (DAO) providing persistence and search support for
 * MeftpUsersTc entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.metalsa.meftp.user.MeftpUsersTc
 * @author MyEclipse Persistence Tools
 */

public class MeftpUsersTcDAO implements IMeftpUsersTcDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved MeftpUsersTc entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpUsersTcDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpUsersTc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpUsersTc entity) {
		EntityManagerHelper.log("saving MeftpUsersTc instance", Level.INFO,
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
	 * Delete a persistent MeftpUsersTc entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpUsersTcDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpUsersTc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpUsersTc entity) {
		System.out.println(entity);
		EntityManagerHelper.log("deleting MeftpUsersTc instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(MeftpUsersTc.class,
					entity.getMeftpUsersUserid());
			System.out.println(entity);
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved MeftpUsersTc entity and return it or a copy of
	 * it to the sender. A copy of the MeftpUsersTc entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = MeftpUsersTcDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpUsersTc entity to update
	 * @return MeftpUsersTc the persisted MeftpUsersTc entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MeftpUsersTc update(MeftpUsersTc entity) {
		EntityManagerHelper.log("updating MeftpUsersTc instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			MeftpUsersTc result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			EntityManagerHelper.commit();
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public MeftpUsersTc findById(Integer id) {
		EntityManagerHelper.log("finding MeftpUsersTc instance with id: " + id,
				Level.INFO, null);
		try {
			MeftpUsersTc instance = getEntityManager().find(MeftpUsersTc.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all MeftpUsersTc entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MeftpUsersTc property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<MeftpUsersTc> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpUsersTc> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding MeftpUsersTc instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from MeftpUsersTc model where model."
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
	
	@SuppressWarnings("unchecked")
	public Boolean findUserLoginAdmin(String userLogin, String password){
		String queryString = "select model from MeftpUsersTc model where model.meftpUsersUsernamelogin="+" '" +userLogin+"' " +"and model.meftpUsersUserpassword="+" '"+password+"'"+
		"and model.meftpUsersUserisadmin="+true;
		Query query = getEntityManager().createQuery(queryString);
		boolean decision;
		List<MeftpUsersTc> list =  query.getResultList();
		if(list.isEmpty() == true){
			decision = false;
		}else{
			decision = true;
		}
		return decision;
	}
	
	@SuppressWarnings("unchecked")
	public Boolean findUserLoginClient(String userLogin, String password){
		String queryString = "select model from MeftpUsersTc model where model.meftpUsersUsernamelogin="+" '" +userLogin+"' " +"and model.meftpUsersUserpassword="+" '"+password+"'"+
		"and model.meftpUsersUserisadmin="+false;
		Query query = getEntityManager().createQuery(queryString);
		boolean decision;
		List<MeftpUsersTc> list =  query.getResultList();
		if(list.isEmpty() == true){
			decision = false;
		}else{
			decision = true;
		}
		return decision;
	}
	
	@SuppressWarnings("unchecked")
	public List<MeftpUsersTc> findAdvancedSearch(String cmbValue,String date1,String date2) {
		String dateTimeStamp1 = date1 + " 00:00:00.000";
		String dateTimeStamp2 = date2 + " 00:00:00.000";
		String queryString = "";
		if(cmbValue.equals("8")){
				queryString = "select model from MeftpUsersTc model where model.meftpUsersUsercreatedate between"+ " '"+dateTimeStamp1+"' "+"and"+" '"+dateTimeStamp2+"'" ;		
			
		}else if(cmbValue.equals("9")){
							
					queryString = "select model from MeftpUsersTc model where model.meftpUsersUserexpires between"+ " '"+dateTimeStamp1+"' "+"and"+" '"+dateTimeStamp2+"'" ;
			
		}
		Query query = getEntityManager().createQuery(queryString);
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MeftpUsersTc> findAdvancedSearch(String cad, String cmbValue) {
		try {
			long value = 0;
			String queryString = "";
			try {
				value = Long.parseLong(cmbValue);
			} catch (NumberFormatException nfe) {}
			
			if (value == 2 || value == 3 || value == 4 || value == 5 || value == 6 || value == 7) {
				LexerWORDS.getInstance().validateString(cad, cmbValue);
				queryString = LexerWORDS.getInstance().getNewResultQuery();
			} 
			
			else if (value == 1) {
				LexerNUMBERS.getInstance().validateNumber(cad, cmbValue);
				queryString = LexerNUMBERS.getInstance().getNewResultQuery();
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
	 * Find all MeftpUsersTc entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MeftpUsersTc> all MeftpUsersTc entities
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpUsersTc> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all MeftpUsersTc instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from MeftpUsersTc model";
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

	@Override
	public Number countEnabledUsers() {
		EntityManagerHelper.log("counting enabled users in database",Level.INFO, null);
		try {
			final String queryString = "select count(model.meftpUsersUserenabledflag) from MeftpUsersTc model where model.meftpUsersUserenabledflag ="+true;
			Query query = getEntityManager().createQuery(queryString);
			Number result = (Number) query.getSingleResult();
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("count enabled users failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public Number countDisableUsers() {
		EntityManagerHelper.log("counting disabled users in database",Level.INFO, null);
		try {
			final String queryString = "select count(model.meftpUsersUserenabledflag) from MeftpUsersTc model where model.meftpUsersUserenabledflag ="+false;
			Query query = getEntityManager().createQuery(queryString);
			Number result = (Number) query.getSingleResult();
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("count disabled users failed", Level.SEVERE, re);
			throw re;
		}
	}

}