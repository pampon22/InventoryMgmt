package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skillstorm.config.HandleyDBCreds;
import com.skillstorm.models.User;


public class MySQLUserDAO {

	public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM users WHERE email = ? and password = ?";
		try (Connection conn = HandleyDBCreds.getInstance().getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs= stmt.executeQuery();
			User user = null;
			if (rs.next()) {
	            user = new User();
	            user.setFullname(rs.getString("fullname"));
	            user.setEmail(email);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
