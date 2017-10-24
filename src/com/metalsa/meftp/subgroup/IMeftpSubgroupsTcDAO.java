package com.metalsa.meftp.subgroup;

import java.util.List;
/**
 * Interface for MeftpSubgroupsTcDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMeftpSubgroupsTcDAO {
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
	 * IMeftpSubgroupsTcDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpSubgroupsTc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MeftpSubgroupsTc entity);

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
	 * IMeftpSubgroupsTcDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MeftpSubgroupsTc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MeftpSubgroupsTc entity);

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
	 * entity = IMeftpSubgroupsTcDAO.update(entity);
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
	public MeftpSubgroupsTc update(MeftpSubgroupsTc entity);

	public MeftpSubgroupsTc findById(Long id);
	
	public List<MeftpSubgroupsTc> findByMeftpSubgroupsSubgroupname(
			Object meftpSubgroupsSubgroupname, int... rowStartIdxAndCount);

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
	public List<MeftpSubgroupsTc> findAll(int... rowStartIdxAndCount);
	
	public List<MeftpSubgroupsTc> findAdvancedSearch(String cmbValue,String date1,String date2);
	
	public List<MeftpSubgroupsTc> findAdvancedSearch(String cad, String cmbValue);
	
	public List<MeftpSubgroupsTc> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount);
	
}