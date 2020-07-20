<%@page import="java.io.PrintWriter"%>
<%@page import="users.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="users" class="users.Users" scope="page" /><!-- 자바빈은  -->
<jsp:setProperty name="users" property="userID" /> <!-- setter의 의미를 가지고 있음 -->
<jsp:setProperty name="users" property="userPassword" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!게시판!</title>
</head>
<body>
	<%
		UsersDAO usersDao = new UsersDAO();
		int result= usersDao.login(users.getUserID(), users.getUserPassword());
		
		if(result == 1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}else if(result == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result == -2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류입니다..')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>
</body>
</html>