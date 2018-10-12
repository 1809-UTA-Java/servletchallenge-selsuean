package com.revature.ServletChallenge.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.ServletChallenge.models.Users;
import com.revature.ServletChallenge.util.ConnectionUtil;

public class UserDAO {
	
	public Users getUser(String usr, String pw) {
		Users u = null;
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM USERS WHERE NAME=? AND WHERE PASSWORD =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ps.setString(2,  pw);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				u = new Users(username, password);
			}
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		
		
		return u;
	}
	
}
