<%@page import="com.sample.dao.UserDAO"%>
<%@page import="com.sample.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자정보 조회</h1>
	<%
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		int point = Integer.parseInt(request.getParameter("point"));
	
		User user = new User();
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setPoint(point);
		
		UserDAO userDao = new UserDAO();
		userDao.insertUser(user);
	%>
	<h2>사용자 등록 완료</h2>
	<p>새로운 사용자가 등록되었습니다.</p>
	
	
	<h3>신규 사용자정보 조회하기</h3>
	<dl>
		<dt>아이디</dt>
		<dd><%=userId  %></dd>
	</dl>
	<dl>
		<dt>비밀번호</dt>
		<dd><%=userPassword  %></dd>
	</dl>
	<dl>
		<dt>이름</dt>
		<dd><%=userName  %></dd>
	</dl>
	<dl>
		<dt>이메일</dt>
		<dd><%=userEmail  %></dd>
	</dl>
	<dl>
		<dt>포인트</dt>
		<dd><%=point  %></dd>
	</dl>
</body>
</html>