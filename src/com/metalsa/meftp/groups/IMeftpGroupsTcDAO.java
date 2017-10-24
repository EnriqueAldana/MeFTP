package com.metalsa.meftp.groups;

import java.util.List;

/**
 * Interface for MeftpGroupsTcDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMeftpGroupsTcDAO {
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
	 * IMeftpGroupsTcDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpGroupsTc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpGroupsTc entity);

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
	 * IMeftpGroupsTcDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpGroupsTc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpGroupsTc entity);

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
	 * entity = IMeftpGroupsTcDAO.update(entity);
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
	public MeftpGroupsTc update(MeftpGroupsTc entity);

	public MeftpGroupsTc findById(Long id);
	

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
	public List<MeftpGroupsTc> findAll(int... rowStartIdxAndCount);
	
	public List<MeftpGroupsTc> findAdvancedSearch(String cadg, String cmbValueg);
	
	public List<MeftpGroupsTc> findAdvancedSearch(String cmbValueg, String date1g, String date2g);
	
	
}