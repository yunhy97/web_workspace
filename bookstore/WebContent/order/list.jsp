<%@page import="com.bookstore.dao.ReviewDAO"%>
<%@page import="com.bookstore.dto.ReviewDTO"%>
<%@page import="com.bookstore.dto.UserDetailDTO"%>
<%@page import="com.bookstore.dao.UserDAO"%>
<%@page import="com.bookstore.vo.User"%>
<%@page import="java.util.List"%>

<%@page import="com.bookstore.dao.UserDAO"%>
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
		String userId = request.getParameter("userid");
	
		UserDAO userDao = new UserDAO();
		User user = userDao.getUserById(userId);
		
		List<UserDetailDTO> userDetailDtos = userDao.getOrderByUserId(userId);
		
	%>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "user";
				
			%>
			<%@include file="../common/navibar.jsp" %>
		</div>
		<div class="header">
			<h1>주문내역 조회</h1>
		</div>
		<div class="body">
			<div>
				<h3><%=user.getName() %>님의 주문내역입니다.</h3>
				<p><strong>누적포인트 : </strong><%=user.getPoint() %></p>
				<table class="table">
					<thead>
						<tr>
							<th>주문번호</th>
							<th>제목</th>
							<th>가격</th>
							<th>수량</th>
							<th>결제금액</th>
							<th>주문날짜</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
						for(UserDetailDTO userDetailDto : userDetailDtos) {
						%>
						<tr>
							<td><%=userDetailDto.getNo() %></td>
							<td><a href="../book/detail.jsp?bookno=<%=userDetailDto.getBookNo()%>"><%=userDetailDto.getTitle() %></a></td>
							<td><%=userDetailDto.getPrice() %></td>
							<td><%=userDetailDto.getAmount() %></td>
							<td><%=userDetailDto.getOrderPrice()%></td>
							<td><%=userDetailDto.getRegisteredDate() %></td>
							<td><a href="../review/form.jsp?userid=<%=userDetailDto.getUserId()%>&bookno=<%=userDetailDto.getBookNo()%>">리뷰작성</a></td>
							<td><a href="../book/like.jsp?userid=<%=userDetailDto.getUserId()%>&bookno=<%=userDetailDto.getBookNo()%>">추천하기</a></td>
						<%
						
						}
						%>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<%@include file="../common/footer.jsp" %>
	</div>
</body>
</html>