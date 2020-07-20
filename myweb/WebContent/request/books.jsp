<%@page import="com.sample.vo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Book bo = new Book();
		List<Book> books = new ArrayList<Book>();
		
	%>
	<div>
		<div>
			<h1></h1>
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<td>제목</td>
						<td>저자</td>
						<td>장르</td>
						<td>출판사</td>
						<td>가격</td>
						<td>할인가격</td>
						<td>등록일</td>
						<td>입고수량</td>
						<td>포인트</td>
						<td>추천수</td>
					</tr>
				</thead>
				<tbody>
				<%
					for(Book book : books) {

				%>
					<tr>
						<td><%= book.getTitle() %></td>
						<td><%= book.getWriter() %></td>
						<td><%= book.getGenre() %></td>
						<td><%= book.getPublisher() %></td>
						<td><%= book.getPrice() %></td>
						<td><%= book.getDiscountPrice() %></td>
						<td><%= book.getRegisteredDate() %></td>
						<td><%= book.getPoint() %></td>
						<td><%= book.getLikes() %></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>	
	</div>
</body>
</html>