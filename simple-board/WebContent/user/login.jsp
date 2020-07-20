<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id= request.getParameter("id");
	String password = request.getParameter("pwd");
	
	UserDAO userDao = new UserDAO();
	User user = userDao.getUserById(id);
	
	if(user == null) {
		response.sendRedirect("loginform.jsp?error=fail");
		return;
	} 
	
	if(!user.getUserPassword().equals(password)) {
		response.sendRedirect("loginform.jsp?error=fail");
		return;
	}
	
	session.setAttribute("이름", user.getUserName());
	session.setAttribute("아이디", user.getUserId());
	session.setAttribute("로그인여부", "Yes");
	
	response.sendRedirect("/simple-board/home.jsp");
	
%>