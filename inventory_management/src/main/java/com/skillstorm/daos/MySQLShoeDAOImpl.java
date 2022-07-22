package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Statement;

import com.skillstorm.config.HandleyDBCreds;
import com.skillstorm.models.Shoe;

/**
 * Implementation of the Shoe DAO for MySQL
 * @author Philip Ampong
 *
 */
public class MySQLShoeDAOImpl implements ShoeDAO{

	
	/**
	 * Steps for JDBC:
	 * 1. Load the JDBC Driver into memory so that I know for sure I have it
	 * 2. Establish a connection using said Driver object
	 * 3. Create an SQL statement
	 * 4. Use the connection object to execute the SQL statement
	 * 5. Parse the returned ResultSet object for the data we want
	 * 6. Close the connection
	 */
	
	
	/**
	 * @return The list of all shoes from the database if successful. Null in the event of failure
	 */
	@Override
	public List<Shoe> findAll() {
		String sql = "SELECT * FROM shoe";
		
		// Connection will auto close in the event of a failure. Due to auto-closable
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			// Create a Statement using the Connection object
			Statement stmt = conn.createStatement();
			
			// Executing the query returns a ResultSet which contains all of the values returned
			ResultSet rs = stmt.executeQuery(sql);
			LinkedList<Shoe> shoes = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// Looping over individual rows of the result set
				Shoe shoe = new Shoe( rs.getInt("Shoe_ID"), rs.getString("Name"), rs.getDouble("Size"), rs.getString("Color"), rs.getString("Brand"), rs.getInt("fk_location_id"));
				shoes.add(shoe);
			}
			
			return shoes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // if failure, we receive null back from this function, indicating something went wrong
	}
	

	/**
	 * @param name
	 * @return The Shoe with the given name if found, null if the shoe does not exist
	 */
	@Override
	public List<Shoe> findByName(String name) {
		/* using
		 * String sql = "SELECT * FROM Artist WHERE name = " + name
		 * is bad. that will imply that someone  
		 * we'll use parameterized queries instead
		 */
		
		String sql = "SELECT * FROM Shoe WHERE name = ?";
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {			
			
			// Instead of using Statement, we will use PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// Java is going to check our statement ahead of time to make sure it's okay
			ps.setString(1, name); // This auto escapes any malicious characters
//			ps.setString(2, brand);
			ResultSet rs = ps.executeQuery();
			// Make sure there was at least one item there
			List<Shoe> shoes = new LinkedList<Shoe>();
			while (rs.next()) {
				shoes.add(new Shoe( rs.getInt("Shoe_ID"), rs.getString("Name"), rs.getDouble("Size"), rs.getString("Color"), rs.getString("Brand"), rs.getInt("fk_Location_id")));
			}
			return shoes;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null; // Null if not found
	}


	/**
	 * @param id
	 * @return The Shoe with the given id if found, null if the shoe does not exist
	 */
	@Override
	public Shoe findById(int id) {
		String sql = "SELECT * FROM shoe WHERE shoe_id = " + id;
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Shoe( rs.getInt("Shoe_ID"), rs.getString("Name"), rs.getDouble("Size"), rs.getString("Color"), rs.getString("Brand"), rs.getInt("fk_Location_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // Null if not found
	}
	

	@Override
	public Shoe save(Shoe shoe) {
		String sql = "INSERT INTO shoe (name, size, brand, color, fk_location_id) VALUES (?, ?, ?, ?, ?)";	
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, shoe.getName());
				ps.setDouble(2, shoe.getSize());
				ps.setString(3, shoe.getBrand());
				ps.setString(4, shoe.getColor());
				ps.setInt(5, shoe.getLocation());
				int rowsAffected = ps.executeUpdate();
				if (rowsAffected != 0) {
					ResultSet keys = ps.getGeneratedKeys();
					// List a of all generated keys
					if (keys.next()) {
						int key = keys.getInt(1); // gives the auto generated key
						shoe.setId(key);
						return shoe;
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

	@Deprecated
	@Override
	public boolean delete(Shoe shoe) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM shoe WHERE shoe_id = ?";
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
	public boolean update(Shoe shoe) {
		String sql = "UPDATE shoe SET name = ?, size = ?, color = ?, brand = ?, fk_location_id =? WHERE shoe_id = ?";
		boolean rowUpdated = false;
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			return new Shoe( rs.getInt("ShoeID"), rs.getString("Name"), rs.getDouble("Size"), rs.getString("Color"), rs.getString("Brand"), rs.getInt("Location"));
			ps.setString(1, shoe.getName());
			ps.setDouble(2, shoe.getSize());
			ps.setString(4, shoe.getBrand());
			ps.setString(3, shoe.getColor());
			ps.setInt(5, shoe.getLocation());
			
			ps.setInt(6, shoe.getId());
			rowUpdated = ps.executeUpdate() > 0;
			return rowUpdated;
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}
		return rowUpdated;
	}

}
