package com.skillstorm.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * singleton for creating configuration object where we retrieve the database credentials. 
 * we use a singleton for the DBCreds so that we only have one instance of that object in 
 * memory, making retrieval and modifications uniform  
 * @author Philip Ampong
 *
 */

public class HandleyDBCreds {
	
	// Static variable reference of single instance
	private static HandleyDBCreds instance;
	private String url;
	private String username;
	private String password;
	
	
	/**
	 * static initializer. initialized when we create the HandleyDBCreds object
	 * loaded into memory immediately
	 */
	private HandleyDBCreds() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// read properties (k-v pairs) from the application.properties file using FileIO
			try (InputStream input = HandleyDBCreds.class.getClassLoader().getResourceAsStream("application.properties")) {
				Properties props = new Properties();
				props.load(input); // loads in the application.properties file we just opened
				
				// grabbing the  keys
				this.url = props.getProperty("db.url");
				this.username = props.getProperty("db.username");
				this.password = props.getProperty("db.password");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Static method to create instance of Singleton class
	 * @return HandleyDBCreds instance
	 */
	public static HandleyDBCreds getInstance() {
		if (instance==null) {
			instance = new HandleyDBCreds();
		}
		return instance;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @return a connection object making it simpler to retrieve a connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
