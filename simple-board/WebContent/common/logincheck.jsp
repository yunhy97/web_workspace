<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(loginYn == null) {
		response.sendRedirect("/simple-board/user/loginform.jsp?error=deny");
		return;
	}
%>