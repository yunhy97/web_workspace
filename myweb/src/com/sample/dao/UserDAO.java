package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.util.ConnectionUtil;
import com.sample.vo.User;

public class UserDAO {

	public void insertUser(User user) throws SQLException {
		String sql = "insert into sample_book_users "
					+ "(user_id, user_password, user_name, user_email, user_point) "
					+ "values "
					+ "(?, ?, ?, ?, ?) ";
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getUserPassword());
		pstmt.setString(3, user.getUserName());
		pstmt.setString(4, user.getUserName());
		pstmt.setInt(5, user.getPoint());
		pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
	}
}
