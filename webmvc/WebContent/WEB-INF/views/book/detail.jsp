  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>책 상세정보</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../common/nav.jsp" %>
	<div class="row">
		<div class="col-12">
			<h1>책 상세정보</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<table class="table table-bordered text-center mt-3">
				<thead>
					<tr>
						<th>제목</th>
						<td colspan="3">${detailBook.title }</td>
					</tr>
					<tr>
						<th>저자</th>
						<td>${detailBook.writer }</td>
						<th>출판사</th>
						<td>${detailBook.publisher }</td>
					</tr>
					<tr>
						<th>평점</th>
						<td><fmt:formatNumber value="${detailBook.point }" pattern="0.0"/> 점</td>
						<th>추천수</th>
						<td><fmt:formatNumber value="${detailBook.likes }"/> 개</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><fmt:formatNumber value="${detailBook.price }" pattern="#,###"/> 원</td>
						<th>할인가격</th>
						<td><fmt:formatNumber value="${detailBook.discountPrice }"/> 원</td>
					</tr>
					<tr>
						<th>재고현황</th>
						<td><fmt:formatNumber value="${detailBook.stock }"/> 권</td>
						<th>등록일</th>
						<td><fmt:formatDate value="${detailBook.registeredDate }" pattern="yyyy.M.d"/></td>
					</tr>
				</thead>
			</table>
			<div class="mt-3 text-right">
				<a href="list.hta" class="btn btn-primary">목록</a>
			</div>
		</div>
	</div>
	<div class="row mt-3">
		<div class="col-12">
			<h3>리뷰 목록</h3>
			<!-- 전체 리뷰 시작 -->
			<div>
				
				<c:if test="${'deny' eq param.error }">
					<div class="alert alert-danger">
						<strong>삭제 불가</strong>
						다른 사용자의 리뷰글을 삭제할 수 없습니다.
					</div>
				</c:if>
				
				<c:choose>
					<c:when test="${not empty reviews }">
						<c:forEach var="review" items="${reviews }" >
							<!-- 리뷰 글 시작 -->
							<div class="card mb-3">
								<div class="card-body p-2">
									<div class="border border-top-0 border-right-0 border-left-0">
										<strong>${review.userId }</strong>
										<span class="float-right text-secondary">
											<fmt:formatDate value="${review.registeredDate }" pattern="yyyy.MM.dd"/>
										</span>
									</div>
									<div class="mt-2">
										<c:out value="${review.content }"/>
										<c:if test="${review.userId eq loginUser.id }">
											<a href="delReview.hta?reviewno=${review.no }" class="btn btn-danger btn-sm float-right">x</a>
										</c:if>
									</div>
								</div>
							</div>
							<!-- 리뷰 글 끝 -->
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="card">
							<div class="card-body p-2">
								<p> 등록된 리뷰 없음 </p>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- 전체 리뷰 끝 -->
		</div>
	</div>
</div>
</body>
</html>