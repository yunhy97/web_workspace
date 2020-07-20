package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.BoardDTO;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Board;
import com.bookstore.vo.Reply;

public class BoardDAO {

	public void insertBoard(Board board) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.insertBoard"));
		
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		pstmt.setInt(4, board.getPassword());
		pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
		
	}
	
	public List<Board> getAllBoards() throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getAllBoards"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setHit(rs.getInt("board_hit"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return boards;
	}
	
	public BoardDTO getBoardByNo(int boardNo) throws SQLException{
		BoardDTO boardDto = null;
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getBoardByNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			boardDto = new BoardDTO();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setTitle(rs.getString("board_title"));
			boardDto.setWriter(rs.getString("board_writer"));
			boardDto.setContent(rs.getString("board_content"));
			boardDto.setHit(rs.getInt("board_hit"));
			boardDto.setRegisteredDate(rs.getDate("board_registered_date"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return boardDto;
	}
	
	public List<Board> getBoardByTitle(String keyword) throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getBoardByTitle"));
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setHit(rs.getInt("board_hit"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		return boards;
	}
	
	public List<Board> getBoardByWriter(String keyword) throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getBoardByWriter"));
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setHit(rs.getInt("board_hit"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		return boards;
	}
	
	public List<Board> getBoardByContent(String keyword) throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getBoardByContent"));
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setHit(rs.getInt("board_hit"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		return boards;
	}
	
	public void insertReply(Reply reply) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("reply.insertReply"));
		pstmt.setString(1, reply.getWriter());
		pstmt.setString(2, reply.getContent());
		pstmt.setInt(3, reply.getBoardNo());
		pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
	}
	
	public List<Reply> getReplyByBoardNo(int boardNo) throws SQLException {
		List<Reply> replys = new ArrayList<Reply>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("reply.getReplyByBoardNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Reply reply = new Reply();
			reply.setNo(rs.getInt("reply_no"));
			reply.setWriter(rs.getString("reply_writer"));
			reply.setContent(rs.getString("reply_content"));
			reply.setRegisteredDate(rs.getDate("reply_registered_date"));
			reply.setBoardNo(rs.getInt("board_no"));
			
			replys.add(reply);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return replys;
	}
}
