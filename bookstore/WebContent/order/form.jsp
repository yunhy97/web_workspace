<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.dto.BookDetailDTO"%>
<%@page import="com.bookstore.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css"/>
<link href='http://fonts.googleapis.com/css?family=Jua' rel='stylesheet' type='text/css'> 
</head>
<body>
	<div class="wrapper">
		<div class="navi">
			<%
				String position="order";
			%>
			<%@ include file="../common/navibar.jsp" %>
		</div>
		<div class="header">
			<h1>주문하기</h1>
		</div>
		<div class="body">
			<%
				//주문처리 1.요청URL에 해당하는 bookno와 amount의 요청 파라미터를 조회한다.
				int bookNo = Integer.parseInt(request.getParameter("bookno"));
				int amount = Integer.parseInt(request.getParameter("amount"));
				
				//주문처리 2.책정보 조회하기<-요청파라미터에서 획득한 bookno로 DB 조히
				BookDAO bookDao = new BookDAO();
				BookDetailDTO bookDto = bookDao.getBookByNo(bookNo);
			%>
			<p>주문정보를 확인하세요.</p>
			<div>
				<!-- 주문처리 3.주문하는 책 정보 표시 -->
				<table class="table bordered">
					<tbody>
						<tr>
							<th>제목</th>
							<td colspan="3"><%=bookDto.getTitle() %></td>
						</tr>
						<tr>
							<th>저자</th>
							<td><%=bookDto.getWriter() %></td>
							<th>출판사</th>
							<td><%=bookDto.getWriter() %></td>
						</tr>
						<tr>
							<th>가격</th>
							<td><%=NumberUtil.numberWithComma(bookDto.getPrice()) %> 원</td>
							<th>할인가격</th>
							<td><%=NumberUtil.numberWithComma(bookDto.getDiscountPrice()) %> 원</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<!-- 
				주문처리 4.주문정보 폼 구성 
					-책번호, 주문가격, 주문수량은 hidden으로 전달
					 (폼에 보이는 input은 보이게만하고 데이터 전달은 hidden폼을 구성하여 전달)
					-구매자는 hidden을 사용하지 않고 전달
					-구매가격, 주문수량은 disabled상태여서 서버로 제출되지 않고 폼의 형태를 보이게만 한다.
					 (위에 hidden을 사용한 input폼을 통해서 서버로 제출)
			 -->
			<div class="well">
				<form action="order.jsp" method="post">
					<input type="hidden" name="price" value="<%=bookDto.getDiscountPrice()%>"/>
					<input type="hidden" name="amount" value="<%=amount%>"/>
					<input type="hidden" name="bookno" value="<%=bookNo%>"/>
					
					<div  class="form-group">
						<label>구매가격</label>
						<div><input type="text" value="<%=NumberUtil.numberWithComma(bookDto.getDiscountPrice())%> 원" disabled/></div>
					</div>
					<div  class="form-group">
						<label>구매수량</label>
						<div><input type="text" value="<%=amount%>" disabled/></div>
					</div>
					<div class="text-right">
						<button type="submit">주문하기</button>
					</div>
				</form>
			</div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>