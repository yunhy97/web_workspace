package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.ReplyDTO;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Reply;

public class ReplyDAO {

	public List<ReplyDTO> getReplyById(String userId) throws SQLException {
		List<ReplyDTO> replys = new ArrayList<ReplyDTO>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("reply.getReplyById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ReplyDTO replyDto = new ReplyDTO();
			replyDto.setBoardNo(rs.getInt("board_no"));
			replyDto.setReplyNo(rs.getInt("reply_no"));
			replyDto.setReplyWriter(rs.getString("reply_writer"));
			replyDto.setReplyContent(rs.getString("reply_content"));
			replyDto.setReplyDelYn(rs.getString("reply_del_yn"));
			replyDto.setReplyCreateDate(rs.getDate("reply_create_date"));
			
			replys.add(replyDto);
		}
		rs.close();
		conn.close();
		pstmt.close();
		return replys;
	}
	
	public List<ReplyDTO> getReplyByNo(int boardNo) throws SQLException {
		List<ReplyDTO> replys = new ArrayList<ReplyDTO>();
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("reply.getReplyByNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ReplyDTO replyDto = new ReplyDTO();
			replyDto.setBoardNo(rs.getInt("board_no"));
			replyDto.setReplyNo(rs.getInt("reply_no"));
			replyDto.setReplyWriter(rs.getString("reply_writer"));
			replyDto.setWriterName(rs.getString("reply_writer_name"));
			replyDto.setReplyContent(rs.getString("reply_content"));
			replyDto.setReplyDelYn(rs.getString("reply_del_yn"));
			replyDto.setReplyCreateDate(rs.getDate("reply_create_date"));
			
			replys.add(replyDto);
		}
		rs.close();
		conn.close();
		pstmt.close();
		return replys;
	}
	
	public void insertReply(Reply reply) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.insertReply"));
		pstmt.setString(1, reply.getReplyWriter());
		pstmt.setString(2, reply.getReplyContent());
		pstmt.setInt(3, reply.getBoardNo());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
	}
	
	public void updateReply(Reply reply) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.updateReply"));
		pstmt.setString(1, reply.getReplyContent());
		pstmt.setString(2, reply.getReplyDelYn());
		pstmt.setInt(3, reply.getReplyNo());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
	}
}
