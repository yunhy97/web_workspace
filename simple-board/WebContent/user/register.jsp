<%@page import="com.simple.dao.UserDAO"%>
<%@page import="com.simple.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String userName = request.getParameter("name");
	String userId = request.getParameter("id");
	String userEmail = request.getParameter("email");
	String userPassword = request.getParameter("pwd");
	
	User user = new User();
	user.setUserId(userId);
	user.setUserName(userName);
	user.setUserEmail(userEmail);
	user.setUserPassword(userPassword);
	
	UserDAO userDao = new UserDAO();
	User savedUser = userDao.getUserById(userId);
	
	if(savedUser != null){
		response.sendRedirect("form.jsp?error=dup");
		return;
	}
	userDao.insertUser(user);
	
	
	
	response.sendRedirect("../home.jsp");
%>