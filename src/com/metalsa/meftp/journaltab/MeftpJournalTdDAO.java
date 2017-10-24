package com.metalsa.meftp.journaltab;

import com.metalsa.meftp.user.EntityManagerHelper;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * MeftpJournalTd entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.metalsa.meftp.journaltab.MeftpJournalTd
 * @author MyEclipse Persistence Tools
 */

public class MeftpJournalTdDAO implements IMeftpJournalTdDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved MeftpJournalTd entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpJournalTdDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpJournalTd entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpJournalTd entity) {
		EntityManagerHelper.log("saving MeftpJournalTd instance", Level.INFO,
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
	 * Delete a persistent MeftpJournalTd entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MeftpJournalTdDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpJournalTd entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpJournalTd entity) {
		EntityManagerHelper.log("deleting MeftpJournalTd instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			entity = getEntityManager().getReference(MeftpJournalTd.class,
					entity.getMeftpJournalJournaleventid());
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
	 * Persist a previously saved MeftpJournalTd entity and return it or a copy
	 * of it to the sender. A copy of the MeftpJournalTd entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = MeftpJournalTdDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpJournalTd entity to update
	 * @return MeftpJournalTd the persisted MeftpJournalTd entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MeftpJournalTd update(MeftpJournalTd entity) {
		EntityManagerHelper.log("updating MeftpJournalTd instance", Level.INFO,
				null);
		try {
			EntityManagerHelper.beginTransaction();
			MeftpJournalTd result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			EntityManagerHelper.commit();
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public MeftpJournalTd findById(Integer id) {
		EntityManagerHelper.log("finding MeftpJournalTd instance with id: "
				+ id, Level.INFO, null);
		try {
			MeftpJournalTd instance = getEntityManager().find(
					MeftpJournalTd.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all MeftpJournalTd entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MeftpJournalTd property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<MeftpJournalTd> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpJournalTd> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding MeftpJournalTd instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from MeftpJournalTd model where model."
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
	 * Find all MeftpJournalTd entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MeftpJournalTd> all MeftpJournalTd entities
	 */
	@SuppressWarnings("unchecked")
	public List<MeftpJournalTd> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all MeftpJournalTd instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from MeftpJournalTd model";
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
	public List<MeftpJournalTd> journalDateSearch(String date1, String date2) {
		String queryString = "";
		queryString = "select model from MeftpJournalTd model where model.meftpJournalJournaldateevent between"+ " '"+date1+"' "+"and"+" '"+date2+"'" ;			
		Query query = getEntityManager().createQuery(queryString);
		return query.getResultList();
	}

}