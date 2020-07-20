<%@page import="com.bookstore.dao.BoardDAO"%>
<%@page import="com.bookstore.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");
	//int boardNo = Integer.parseInt(request.getParameter("boardno"));
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	int password = Integer.parseInt(request.getParameter("password"));
	
	Board board = new Board();
	//board.setBoardNo(boardNo);
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	board.setPassword(password);
	
	BoardDAO boardDao = new BoardDAO();
	boardDao.insertBoard(board);
	
	response.sendRedirect("list.jsp");
%>