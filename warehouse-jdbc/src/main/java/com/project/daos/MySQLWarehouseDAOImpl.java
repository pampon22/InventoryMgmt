package com.project.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.project.config.HandleyDBCreds;
import com.project.models.Warehouse;

public class MySQLWarehouseDAOImpl implements WarehouseDAO {

	@Override
	public List<Warehouse> findAll() {
		String sql = "SELECT * FROM shoe";
		
		// Connection will auto close in the event of a failure. Due to auto-closable
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			// Create a Statement using the Connection object
			Statement stmt = conn.createStatement();
			
			// Executing the query returns a ResultSet which contains all of the values returned
			ResultSet rs = stmt.executeQuery(sql);
			LinkedList<Warehouse> warehouses = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// Looping over individual rows of the result set
				Warehouse warehouse = new Warehouse( rs.getInt("warehouse_id"), rs.getString("state") );
				System.out.println("warehouse: " + warehouse );
				warehouses.add(warehouse);
			}			
			System.out.println("here");
			return warehouses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // if failure, we receive null back from this function, indicating something went wrong
	}

	@Override
	public List<Warehouse> findByState(String state) {
		String sql = "SELECT * FROM WHERE name=?";
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, state); // This auto escapes any malicious characters
			ResultSet rs = ps.executeQuery();
			LinkedList<Warehouse> warehouses = new LinkedList<>();
			while (rs.next()) {
				warehouses.add(new Warehouse(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null; // Null if not found
	}
	

	@Override
	public Warehouse findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Warehouse save(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Warehouse Warehouse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}

}
