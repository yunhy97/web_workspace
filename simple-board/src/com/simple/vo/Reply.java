package com.simple.vo;

import java.sql.Date;

public class Reply {

	private int replyNo;
	private String replyWriter;
	private String replyContent;
	private String replyDelYn;
	private Date replyCreateDate;
	private int boardNo;
	
	public Reply() {}

	

	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDelYn() {
		return replyDelYn;
	}

	public void setReplyDelYn(String replyDelYn) {
		this.replyDelYn = replyDelYn;
	}

	public Date getReplyCreateDate() {
		return replyCreateDate;
	}

	public void setReplyCreateDate(Date replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}
	
	
}
