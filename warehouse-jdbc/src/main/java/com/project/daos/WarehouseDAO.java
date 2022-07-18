package com.project.daos;

import java.util.List;

import com.project.models.Warehouse;

/**
	 * warehouse DAO interface that has methods representing queries specific to Warehouse
	 * @author Philip Ampong
	 *
	 */
	public interface WarehouseDAO {
		
		/**
		 * 
		 * @return
		 */
		public List<Warehouse> findAll();
		
		public List<Warehouse> findByState(String state);
		
//		public Warehouse findByPostalcode(int code);
		
		public Warehouse findById(int id);
		
		public Warehouse save(Warehouse warehouse);
		
		public void delete(Warehouse Warehouse);
		
		public void delete(int id);
		
		public void deleteMany(int[] ids);
		
		public void update(Warehouse warehouse);
	}

