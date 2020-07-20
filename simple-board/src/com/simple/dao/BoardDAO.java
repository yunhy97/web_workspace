package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.BoardDTO;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Board;

public class BoardDAO {

	public void insertBoard(Board board) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.insertBoard"));
		pstmt.setString(1, board.getBoardTitle());
		pstmt.setString(2, board.getBoardWriter());
		pstmt.setString(3, board.getBoardContent());
		pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
	}
	public int getTotalRows() throws SQLException {
		int totalRows = 0;
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getTotalRows"));
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRows = rs.getInt("cnt");
		rs.close();
		pstmt.close();
		conn.close();
		return totalRows;
	}
	
	public void updateBoard(Board board) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.updateBoard"));
		pstmt.setString(1, board.getBoardTitle());
		pstmt.setString(2, board.getBoardContent());
		pstmt.setInt(3, board.getBoardHit());
		pstmt.setInt(4, board.getBoardReplyCnt());
		pstmt.setString(5, board.getBoardDelYn());
		pstmt.setInt(6, board.getBoardNo());
		pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
	}
	
	public List<BoardDTO> getBoards(int beginIndex, int endIndex) throws SQLException {
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getBoards"));
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, endIndex);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			BoardDTO boardDto = new BoardDTO();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setWriterName(rs.getString("board_writer_name"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardHit(rs.getInt("board_hit"));
			boardDto.setBoardReplyCnt(rs.getInt("board_reply_cnt"));
			boardDto.setBoardDelYn(rs.getString("board_del_yn"));
			boardDto.setBoardCreateDate(rs.getDate("board_create_date"));
			boards.add(boardDto);
		}
		return boards;
	}
	
	public List<Board> getAllBoards() throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getAllBoards"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardWriter(rs.getString("board_writer"));
			board.setBoardContent(rs.getString("board_content"));
			board.setBoardHit(rs.getInt("board_hit"));
			board.setBoardReplyCnt(rs.getInt("board_reply_cnt"));
			board.setBoardDelYn(rs.getString("board_del_yn"));
			board.setBoardCreateDate(rs.getDate("board_create_date"));
			boards.add(board);
		}
		conn.close();
		rs.close();
		pstmt.close();
		return boards;
	}
	
	public List<BoardDTO> getBoardById(String userId) throws SQLException {
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getBoardById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			BoardDTO boardDto = new BoardDTO();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardHit(rs.getInt("board_hit"));
			boardDto.setBoardReplyCnt(rs.getInt("board_reply_cnt"));
			boardDto.setBoardDelYn(rs.getString("board_del_yn"));
			boardDto.setBoardCreateDate(rs.getDate("board_create_date"));
			boards.add(boardDto);
		}
		conn.close();
		rs.close();
		pstmt.close();
		return boards;
	}
	
	
	public BoardDTO getBoardByNo(int boardNo) throws SQLException {
		BoardDTO boardDto = null;
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("board.getBoardByNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			boardDto = new BoardDTO();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardHit(rs.getInt("board_hit"));
			boardDto.setBoardReplyCnt(rs.getInt("board_reply_cnt"));
			boardDto.setBoardDelYn(rs.getString("board_del_yn"));
			boardDto.setBoardCreateDate(rs.getDate("board_create_date"));
			
		}
		conn.close();
		rs.close();
		pstmt.close();
		return boardDto;
	}
}
