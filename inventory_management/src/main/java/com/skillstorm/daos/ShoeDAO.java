package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Shoe;

/**
 * warehouse DAO interface that has methods representing queries specific to Shoe
 * @author Philip Ampong
 *
 */
public interface ShoeDAO {
	
	/**
	 * 
	 * @return all shoes
	 */
	public List<Shoe> findAll();
	
	/**
	 * 
	 * @param name
	 * @return 
	 */
	public List<Shoe> findByName(String name);
	
	public Shoe findById(int id);
	
	public Shoe save(Shoe shoe);
	
	@Deprecated
	public boolean delete(Shoe shoe);
	
	public boolean delete(int id);
		
	public boolean update(Shoe shoe);
}
