package com.metalsa.meftp.files;

import java.util.List;

import com.metalsa.meftp.utils.MeFTPServerDBException;
import com.metalsa.meftp.utils.MeFTPServerEmailException;


/**
 * Interface for MeftpFilesTdDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMeftpFilesTdDAO {
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
	 * IMeftpFilesTdDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpFilesTd entity to persist
	 * @throws MeFTPServerDBException 
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public Integer save(MeftpFilesTd entity) throws MeFTPServerDBException;
	
	public void saveContent(byte[] content,int fileId);

	/**
	 * Delete a persistent MeftpFilesTd entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMeftpFilesTdDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpFilesTd entity to delete
	 * @throws MeFTPServerDBException 
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpFilesTd entity) throws MeFTPServerDBException;

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
	 * entity = IMeftpFilesTdDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpFilesTd entity to update
	 * @return MeftpFilesTd the persisted MeftpFilesTd entity instance, may not
	 *         be the same
	 * @throws MeFTPServerDBException 
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MeftpFilesTd update(MeftpFilesTd entity) throws MeFTPServerDBException;

	public MeftpFilesTd findById(Integer id);

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
	 *            count of results to return.
	 * @return List<MeftpFilesTd> found by query
	 */
	public List<MeftpFilesTd> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

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
	public List<MeftpFilesTd> findAll(int... rowStartIdxAndCount);
	
	public List<MeftpFilesTd> findAdvancedSearch(String cadf, String cmbValuef);
	
	public List<MeftpFilesTd> findAdvancedSearch(String cmbValuef, String date1f, String date2f);
	
}