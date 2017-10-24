package com.metalsa.meftp.configurationtab;

import java.util.List;

/**
 * Interface for MeftpServerTdDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMeftpServerTdDAO {
	/**
	 * Perform an initial save of a previously unsaved MeftpServerTd entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMeftpServerTdDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpServerTd entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpServerTd entity);

	/**
	 * Delete a persistent MeftpServerTd entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMeftpServerTdDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpServerTd entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpServerTd entity);

	/**
	 * Persist a previously saved MeftpServerTd entity and return it or a copy
	 * of it to the sender. A copy of the MeftpServerTd entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IMeftpServerTdDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpServerTd entity to update
	 * @return MeftpServerTd the persisted MeftpServerTd entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MeftpServerTd update(MeftpServerTd entity);

	public MeftpServerTd findById(Integer id);

	/**
	 * Find all MeftpServerTd entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MeftpServerTd property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MeftpServerTd> found by query
	 */
	public List<MeftpServerTd> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all MeftpServerTd entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MeftpServerTd> all MeftpServerTd entities
	 */
	public List<MeftpServerTd> findAll(int... rowStartIdxAndCount);
}