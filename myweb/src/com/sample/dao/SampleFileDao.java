package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.util.ConnectionUtil;
import com.sample.vo.SampleFile;

public class SampleFileDao {

	public void insertFile(SampleFile sampleFile) throws SQLException {
		String sql = "insert into sample_files "
					+ "values "
					+ "(sample_file_seq.nextval, ?, ? ,sysdate) ";
		
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sampleFile.getTitle());
		pstmt.setString(2, sampleFile.getName());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public List<SampleFile> getAllFiles() throws SQLException {
		List<SampleFile> files = new ArrayList<SampleFile>();
		String sql = "select * from sample_files order by file_no desc ";
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			SampleFile samplefile = new SampleFile();
			samplefile.setNo(rs.getInt("file_no"));
			samplefile.setTitle(rs.getString("file_title"));
			samplefile.setName(rs.getString("file_name"));
			samplefile.setCreatedate(rs.getDate("file_create_date"));
			
			files.add(samplefile);
		}
		rs.close();
		conn.close();
		pstmt.close();
		return files;
	}
	
	public SampleFile getFileByNo(int fileNo) throws SQLException {
		SampleFile sampleFile = null;
		String sql = "select * from sample_files where file_no = ? ";
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, fileNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			sampleFile = new SampleFile();
			sampleFile.setNo(rs.getInt("file_no"));
			sampleFile.setTitle(rs.getString("file_title"));
			sampleFile.setName(rs.getString("file_name"));
			sampleFile.setCreatedate(rs.getDate("file_create_date"));
		}
		rs.close();
		conn.close();
		pstmt.close();
		return sampleFile;
	}
}
