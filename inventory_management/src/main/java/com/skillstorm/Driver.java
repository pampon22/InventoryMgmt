package com.skillstorm;

import java.util.List;

import com.skillstorm.daos.MySQLShoeDAOImpl;
import com.skillstorm.daos.MySQLWarehouseDAOImpl;
import com.skillstorm.daos.ShoeDAO;
import com.skillstorm.daos.WarehouseDAO;
import com.skillstorm.models.Warehouse;

/**
 * has the main method for starting up the application.
 * communicates between the Java app and the database
 * @author Philip Ampong
 *
 */
public class Driver {
	
	/*
	 * main method: entry point of the class
	 */
	public static void main(String[] args) {
//		ShoeDAO s = new MySQLShoeDAOImpl();
//		List<Shoe> shoes = s.findAll();
//		System.out.println(shoes);
		
		WarehouseDAO w = new MySQLWarehouseDAOImpl();
		List<Warehouse> warehouses = w.findAll();
//		System.out.println(warehouses);

		List<Warehouse> byState = w.findByState("MA");
		System.out.println(byState);
		
		System.out.println(w.findById(1));
		Warehouse newWarehouse = new Warehouse("NV");
		System.out.println(w.save(newWarehouse));
	}
}
