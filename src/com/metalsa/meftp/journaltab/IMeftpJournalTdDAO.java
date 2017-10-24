package com.metalsa.meftp.journaltab;

import java.util.List;

/**
 * Interface for MeftpJournalTdDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMeftpJournalTdDAO {
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
	 * IMeftpJournalTdDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpJournalTd entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpJournalTd entity);

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
	 * IMeftpJournalTdDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpJournalTd entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpJournalTd entity);

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
	 * entity = IMeftpJournalTdDAO.update(entity);
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
	public MeftpJournalTd update(MeftpJournalTd entity);

	public MeftpJournalTd findById(Integer id);

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
	 *            count of results to return.
	 * @return List<MeftpJournalTd> found by query
	 */
	public List<MeftpJournalTd> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

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
	public List<MeftpJournalTd> findAll(int... rowStartIdxAndCount);
	
	public List<MeftpJournalTd> journalDateSearch(String date1, String date2);
	
}