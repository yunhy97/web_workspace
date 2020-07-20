package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.util.ConnectionUtil;
import com.sample.vo.Book;

public class BookDAO {

	public void insertBook(Book book) throws SQLException {
		String sql = "insert into sample_books "
					+ "(book_no, book_title, book_writer, book_genre, book_publisher, book_price, "
					+ " book_discount_price, book_stock) "
					+ "values "
					+ "(sample_book_seq.nextval, ?, ?, ?, ?, ?, ?, ?) ";
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		pstmt.setInt(7, book.getStock());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
}
