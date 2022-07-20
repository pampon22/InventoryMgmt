package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.config.HandleyDBCreds;
import com.skillstorm.models.Warehouse;

public class MySQLWarehouseDAOImpl implements WarehouseDAO {

	@Override
	public List<Warehouse> findAll() {
		String sql = "SELECT * FROM warehouse";
		
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
				Warehouse warehouse = new Warehouse( rs.getInt("warehouse_id"), rs.getString("state"), rs.getInt("capacity") );
				warehouses.add(warehouse);
			}			
			return warehouses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // if failure, we receive null back from this function, indicating something went wrong
	}

	@Override
	public List<Warehouse> findByState(String state) {
		String sql = "SELECT * FROM warehouse WHERE state=?";
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, state); // This auto escapes any malicious characters
			ResultSet rs = ps.executeQuery();
			LinkedList<Warehouse> warehouses = new LinkedList<>();
			while (rs.next()) {
				warehouses.add(new Warehouse(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			return warehouses;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null; // Null if not found
	}
	

	@Override
	public Warehouse findById(int id) {
		String sql = "SELECT * FROM warehouse WHERE warehouse_id = " + id;
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Warehouse(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Warehouse save(Warehouse warehouse) {
		String sql = "INSERT INTO warehouse (state, capacity) VALUES (?, ?)";
					
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
		
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, warehouse.getState());
			ps.setInt(2, warehouse.getCapacity());
			int rowsAffected = ps.executeUpdate();
			// System.out.println(rowsAffected); 
			// If 0 is returned, my data didn't save
			if (rowsAffected != 0) {
				ResultSet keys = ps.getGeneratedKeys();
				// List a of all generated keys
				if (keys.next()) {
					int key = keys.getInt(1); // gives the auto generated key
					warehouse.setId(key);
					return warehouse;
				}
				conn.commit();		// Executes ALL queries in a given transaction. Green button
			} else {
				conn.rollback();	// Undoes any of the queries. Database pretends those never happened
			}
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean delete(Warehouse warehouse) {
		String sql = "DELETE FROM warehouse WHERE warehouse_id = ?";
		boolean rowDeleted = false;
		
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
		
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, warehouse.getId());
			rowDeleted = ps.executeUpdate() > 0;
			return rowDeleted;
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}

		return rowDeleted;
		
	}

	@Override
	public boolean deleteById(int id) {
		String sql = "DELETE FROM warehouse WHERE warehouse_id = ?";
		boolean rowDeleted = false;
		
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
		
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
			return rowDeleted;
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}

		return rowDeleted;
	}

	@Override
	public boolean deleteMany(int[] ids) {
		String sql = "DELETE FROM warehouse WHERE warehouse_id IN (?)";
		boolean rowDeleted = false;
		
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
		
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setObject(1, ids);
			rowDeleted = ps.executeUpdate() > 0;
			return rowDeleted;
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}

		return rowDeleted;	}

	@Override
	public boolean update(Warehouse warehouse) {
		String sql = "UPDATE warehouse SET state = ?, capacity = ? WHERE warehouse_id = ?";
		boolean rowUpdated = false;
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ps.setInt(1, warehouse.getId());
			ps.setString(1, warehouse.getState());
			ps.setInt(2, warehouse.getCapacity());
			ps.setInt(3, warehouse.getId());
			rowUpdated = ps.executeUpdate() > 0;
			return rowUpdated;
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}
		return rowUpdated;
	}

}
