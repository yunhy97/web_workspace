package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.ReviewDTO;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Review;

public class ReviewDAO {

	public List<ReviewDTO> getReviewsByBookNo(int bookNo) throws SQLException {
		List<ReviewDTO> reviews = new ArrayList<ReviewDTO>();
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("user.getReviewByBookNo"));
		pstmt.setInt(1, bookNo);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ReviewDTO reviewDto = new ReviewDTO();
			reviewDto.setNo(rs.getInt("review_no"));
			reviewDto.setUserName(rs.getString("user_name"));
			reviewDto.setPoint(rs.getInt("review_point"));
			reviewDto.setContent(rs.getString("review_content"));
			reviewDto.setRegisteredDate(rs.getDate("review_registered_date"));
			
			reviews.add(reviewDto);
		}
		conn.close();
		rs.close();
		pstmt.close();
		
		return reviews;
	}
	
	public void insertReview(Review review) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("review.insertReview"));
		pstmt.setString(1, review.getContent());
		pstmt.setInt(2, review.getPoint());
		pstmt.setInt(3, review.getBookNo());
		pstmt.setString(4, review.getUserId());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
	}
	
	//리뷰등록완료 메소드
	public List<ReviewDTO> getreviewYNByUserId(String userId) throws SQLException {
		List<ReviewDTO> reviewDtos = new ArrayList<ReviewDTO>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("review.getreviewYNByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ReviewDTO reviewDto = new ReviewDTO();
			reviewDto.setNo(rs.getInt("review_no"));
			reviewDto.setContent(rs.getString("review_content"));
			reviewDto.setPoint(rs.getInt("review_point"));
			reviewDto.setUserId(rs.getString("user_id"));
			reviewDto.setUserName(rs.getString("user_name"));
			reviewDto.setRegisteredDate(rs.getDate("review_registered_date"));
			
			reviewDtos.add(reviewDto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return reviewDtos;
	}
}
