<%@page import="com.bookstore.dao.UserDAO"%>
<%@page import="com.bookstore.vo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
<link href='http://fonts.googleapis.com/css?family=Jua' rel='stylesheet' type='text/css'> 
</head>
<body>
	<%
		UserDAO userDao = new UserDAO();
		List<User> users = userDao.getAllUsers();
	%>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "user";
			%>
			<%@include file="../common/navibar.jsp" %>
		</div>
		<div class="header">
			<h1>사용자 리스트</h1>
		</div>
		<div class="body">
			<div>
				<h3>모든 사용자 리스트</h3>
				<table class="table">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>누적포인트</th>
							<th>가입일</th>
						</tr>
					</thead>
					<tbody>
					<%
						for(User user : users) {
					%>
						<tr>
							<td><a href="../order/list.jsp?userid=<%=user.getId() %>"><%=user.getId() %></a></td>
							<td><a href="../order/list.jsp?userid=<%=user.getId() %>"><%=user.getName() %></a></td>
							<td><%=user.getEmail() %></td>
							<td><%=user.getPoint() %></td>
							<td><%=user.getRegisteredDate() %></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
		<%@include file="../common/footer.jsp" %>
	</div>
</body>
</html>