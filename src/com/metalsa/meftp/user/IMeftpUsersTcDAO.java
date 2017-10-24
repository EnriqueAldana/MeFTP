package com.metalsa.meftp.user;

import java.util.List;

/**
 * Interface for MeftpUsersTcDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMeftpUsersTcDAO {
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
	 * IMeftpUsersTcDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpUsersTc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpUsersTc entity);
	

	/**
	 * Delete a persistent MeftpUsersTc entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMeftpUsersTcDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpUsersTc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpUsersTc entity);

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
	 * entity = IMeftpUsersTcDAO.update(entity);
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
	public MeftpUsersTc update(MeftpUsersTc entity);

	public MeftpUsersTc findById(Integer id);


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
	public List<MeftpUsersTc> findAll(int... rowStartIdxAndCount);
	
	public List<MeftpUsersTc> findAdvancedSearch(String cmbValue,String date1,String date2);
	
	public List<MeftpUsersTc> findAdvancedSearch(String cad, String cmbValue);
	
	public Boolean findUserLoginAdmin(String userLogin, String password);
	
	public Boolean findUserLoginClient(String userLogin, String password);
	
	public Number countEnabledUsers();
	
	public Number countDisableUsers();
}