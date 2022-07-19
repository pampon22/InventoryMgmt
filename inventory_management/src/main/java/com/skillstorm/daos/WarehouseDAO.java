package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Warehouse;

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
		
		public boolean delete(Warehouse warehouse);
		
		public boolean deleteById(int id);
		
		public boolean deleteMany(int[] ids);
		
		public boolean update(Warehouse warehouse);
	}

