<%@page import="com.simple.dao.ReplyDAO"%>
<%@page import="com.simple.vo.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	int boardNo = Integer.parseInt(request.getParameter("boardno")); 
	String content = request.getParameter("content");
	String writer = (String)session.getAttribute("아이디");
	
	Reply reply = new Reply();
	reply.setBoardNo(boardNo);
	reply.setReplyContent(content);
	reply.setReplyWriter(writer);
	
	ReplyDAO replyDao = new ReplyDAO();
	replyDao.insertReply(reply);
	
	response.sendRedirect("../board/detail.jsp?no=" + boardNo);
	
%>