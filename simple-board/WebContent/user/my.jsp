<%@page import="com.simple.dto.ReplyDTO"%>
<%@page import="com.simple.dao.ReplyDAO"%>
<%@page import="com.simple.dto.BoardDTO"%>
<%@page import="com.simple.dao.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%
			String position = "user";
		%>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>나의 정보</h1>
	</div>
	<div class="body">
		<%
			BoardDAO boardDao = new BoardDAO();
			List<BoardDTO> boardDto = boardDao.getBoardById(loginUserID);
			
		%>
		<p><strong><%=loginUserName %></strong>님의 정보를 확인하세요</p>
		
		<div>
			<h3>내가 작성한 글</h3>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th>제목</th>
						<th class="text-center">조회수</th>
						<th class="text-center">댓글수</th>
						<th class="text-center">삭제여부</th>
						<th class="text-center">등록일</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(BoardDTO boards : boardDto) {
					%>
					<tr>
						<td class="text-center"><%=boards.getBoardNo() %></td>
						<td><a href="../board/detail.jsp?no=<%=boards.getBoardNo()%>"><%=boards.getBoardTitle() %></a></td>
						<td class="text-center"><%=boards.getBoardHit() %></td>
						<td class="text-center"><%=boards.getBoardReplyCnt() %></td>
						<td class="text-center"><%=boards.getBoardDelYn() %></td>
						<td class="text-center"><%=boards.getBoardCreateDate() %></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<%
			ReplyDAO replyDao = new ReplyDAO();
			List<ReplyDTO> replyDto = replyDao.getReplyById(loginUserID);
		%>
		<div>
			<h3>내가 작성한 댓글</h3>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="*">
					<col width="10%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th>내용</th>
						<th class="text-center">삭제여부</th>
						<th class="text-center">등록일</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(ReplyDTO replys : replyDto) {
					%>
					<tr>
						<td class="text-center"><%=replys.getReplyNo() %></td>
						<td><%=replys.getReplyContent() %></td>
						<td class="text-center"><%=replys.getReplyDelYn() %></td>
						<td class="text-center"><%=replys.getReplyCreateDate() %></td>
					</tr>
					<%
						}
					%>
				</tbody>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>