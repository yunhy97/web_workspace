package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.OrderDTO;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Order;

public class OrderDAO {

	public void insertOrder(Order order) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("order.insertOrder"));
		pstmt.setString(1, order.getUserId());
		pstmt.setInt(2, order.getBookNo());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getAmount());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
	}
	
	public List<OrderDTO> getAllOrders() throws SQLException {
		List<OrderDTO> orderDtos = new ArrayList<OrderDTO>();
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("order.getAllOrders"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			OrderDTO orderDto = new OrderDTO();
			orderDto.setOrderNo(rs.getInt("order_no"));
			orderDto.setUserName(rs.getString("user_name"));
			orderDto.setBookTitle(rs.getString("book_title"));
			orderDto.setGenre(rs.getString("book_genre"));
			orderDto.setPrice(rs.getInt("order_price"));
			orderDto.setAmount(rs.getInt("order_amount"));
			orderDto.setRegisteredDate(rs.getDate("order_registered_date"));
			
			orderDtos.add(orderDto);
		}
		conn.close();
		rs.close();
		pstmt.close();
		
		return orderDtos;
	}
	
	public List<OrderDTO> getOrderByGenre(String genre) throws SQLException {
		List<OrderDTO> orderDtos = new ArrayList<OrderDTO>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("order.getOrderByGenre"));
		pstmt.setString(1, genre);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			OrderDTO orderDto = new OrderDTO();
			orderDto.setOrderNo(rs.getInt("order_no"));
			orderDto.setUserName(rs.getString("user_name"));
			orderDto.setBookTitle(rs.getString("book_title"));
			orderDto.setPrice(rs.getInt("order_price"));
			orderDto.setAmount(rs.getInt("order_amount"));
			orderDto.setRegisteredDate(rs.getDate("order_registered_date"));
			orderDto.setGenre(rs.getString("book_genre"));
			orderDtos.add(orderDto);
		}
		conn.close();
		rs.close();
		pstmt.close();
		
		return orderDtos;
	}
	
	public List<OrderDTO> getOrdersByUserId(String userId) throws SQLException {
		List<OrderDTO> orders = new ArrayList<OrderDTO>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrdersByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			OrderDTO orderDto = new OrderDTO();
			orderDto.setOrderNo(rs.getInt("order_no"));
			orderDto.setUserId(rs.getString("user_id"));
			orderDto.setUserName(rs.getString("user_name"));
			orderDto.setUserPoint(rs.getInt("user_point"));
			orderDto.setBookNo(rs.getInt("book_no"));
			orderDto.setBookTitle(rs.getString("book_title"));
			orderDto.setPrice(rs.getInt("order_price"));
			orderDto.setAmount(rs.getInt("order_amount"));
			orderDto.setRegisteredDate(rs.getDate("order_registered_date"));
			orderDto.setReviewYN(rs.getString("review_yn"));
			
			orders.add(orderDto);
		}
		rs.close();
		pstmt.close();
		connection.close();
		return orders;
	}

}
