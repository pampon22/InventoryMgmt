package com.skillstorm;

import java.util.List;

import com.skillstorm.daos.MySQLShoeDAOImpl;
import com.skillstorm.daos.MySQLWarehouseDAOImpl;
import com.skillstorm.daos.ShoeDAO;
import com.skillstorm.daos.WarehouseDAO;
import com.skillstorm.models.Shoe;
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
		
//		WarehouseDAO w = new MySQLWarehouseDAOImpl();
//		List<Warehouse> warehouses = w.findAll();
//		System.out.println(warehouses);
//
//		List<Warehouse> byState = w.findByState("MA");
//		System.out.println(byState);
//		
//		System.out.println(w.findById(1));
//		Warehouse newWarehouse = new Warehouse("NV", 10);
//		w.save(newWarehouse);
//		
//		System.out.println(w.findAll());
//		
//		System.out.println(w.delete(newWarehouse));
//		System.out.println(w.deleteById(13));
//		
////		int[] ids = new int[] {1,3,14};
////		System.out.println(w.deleteMany(ids));
//		
//		System.out.println(w.update(new Warehouse(11, "CA", 10)));
//		
//		System.out.println(w.findAll());
		
		ShoeDAO s = new MySQLShoeDAOImpl();
		List<Shoe> shoes = s.findAll();
		System.out.println(shoes);

		// List<Shoe> byName = s.findByName("Air force 1");
		// System.out.println(byName);
		
		// System.out.println(s.findById(1));
		Shoe newShoe = new Shoe("The Cacti Heel", "green", "Weebs", 1, 11);
		Shoe newShoe2 = new Shoe("The Gum Stuck To The High Heel", "pink", "GummyBears", 4, 11);
		s.save(newShoe);
		s.save(newShoe2);
		
		System.out.println(s.delete(5));
		System.out.println(s.findById(5));
		
//		System.out.println(s.update(new Shoe(6, "The Sandwich Flip Flops", 12.0, "brown", "McDonals", 11)));
//		
//		System.out.println(s.findShoeLike("The Gum Stuck To The High Heel"));
	}
}
