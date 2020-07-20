<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginYn = (String)session.getAttribute("로그인여부");
	String loginUserID = (String)session.getAttribute("아이디");
	String loginUserName = (String)session.getAttribute("이름");
%>