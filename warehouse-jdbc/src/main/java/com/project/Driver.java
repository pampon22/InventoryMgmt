package com.project;

import java.util.List;

import com.project.daos.MySQLShoeDAOImpl;
import com.project.daos.MySQLWarehouseDAOImpl;
import com.project.daos.ShoeDAO;
import com.project.daos.WarehouseDAO;
import com.project.models.Warehouse;

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
		System.out.println(warehouses);
	}
}
