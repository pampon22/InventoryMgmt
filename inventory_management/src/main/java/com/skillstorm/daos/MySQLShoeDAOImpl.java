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
//				Shoe shoe = new Shoe(rs.getInt("ShoeID"), rs.getString("Name"));
				Shoe shoe = new Shoe( rs.getInt("ShoeID"), rs.getString("Name"), rs.getString("Brand") );
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
	public Shoe findByName(String name) {
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
			if (rs.next()) {
				return new Shoe(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
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
				return new Shoe(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // Null if not found
	}
	

	@Override
	public Shoe save(Shoe shoe) {
		String sql = "INSERT INTO shoe (name, brand, color ...) VALUES (?)";
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, shoe.getId());
				ps.setString(2, shoe.getName());

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	
	@Override
	public void delete(Shoe shoe) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Shoe shoe) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void deleteMany(int[] ids) {
		// TODO Auto-generated method stub
		
	}

}
