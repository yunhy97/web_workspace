package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simple.dto.UserDTO;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.User;

public class UserDAO {

	public void insertUser(User user) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.insertUser"));
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getUserName());
		pstmt.setString(3, user.getUserPassword());
		pstmt.setString(4, user.getUserEmail());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
	}
	
	public User getUserById(String userId) throws SQLException {
		User user = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			user = new User();
			user.setUserId(rs.getString("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setUserPassword(rs.getString("user_password"));
			user.setUserEmail(rs.getString("user_email"));
			user.setUserDisabled(rs.getString("user_disabled"));
			user.setUserCreateDate(rs.getDate("user_create_date"));
			
		}
		rs.close();
		pstmt.close();
		connection.close();
		return user;
		
	}
	
	public void updateUser(User user) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.updateUser"));
		pstmt.setString(1, user.getUserPassword());
		pstmt.setString(2, user.getUserEmail());
		pstmt.setString(3, user.getUserDisabled());
		pstmt.setString(4, user.getUserId());
		
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
	}
	
	public UserDTO getCountQuestionUserByNo(int userNo) throws SQLException {
		UserDTO userDto = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getCountQuestionUserByNo"));
		pstmt.setInt(1, userNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			userDto = new UserDTO();
		
			userDto.setNo(rs.getInt("user_no"));
			userDto.setUserTotalPrice(rs.getInt("count_question"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return userDto;
}
}
