package com.simple.dto;

import java.sql.Date;

public class BoardDTO {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String writerName;
	private String boardContent;
	private int boardHit;
	private int boardReplyCnt;
	private String boardDelYn;
	private Date boardCreateDate;

	
	public BoardDTO() {}

	
	public String getWriterName() {
		return writerName;
	}


	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}


	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public int getBoardReplyCnt() {
		return boardReplyCnt;
	}

	public void setBoardReplyCnt(int boardReplyCnt) {
		this.boardReplyCnt = boardReplyCnt;
	}

	public String getBoardDelYn() {
		return boardDelYn;
	}

	public void setBoardDelYn(String boardDelYn) {
		this.boardDelYn = boardDelYn;
	}

	public Date getBoardCreateDate() {
		return boardCreateDate;
	}

	public void setBoardCreateDate(Date boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}
	
	
}
