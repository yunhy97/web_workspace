<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>To Do</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<fmt:bundle basename="com.simple.resources.message">
<div class="container">
	<c:set var="position" value="home" />
	<%@ include file="nav.jsp" %>
	<!-- Content -->
	<div class="row mb-3">
		<div class="col-12">
			<div class="card">
				<div class="card-header"><fmt:message key="home.title"/></div>
				<div class="card-body">
					<div class="row">
					
						<c:forEach var="todo" items="${todos}">
						<div class="col-4 mb-2">
							<div class="card">
								<div class="card-header d-flex justify-content-between">
									<div>${todo.title }</div> 
									<div id="card-status-${todo.no }"><span class="badge ${todo.statusClass }">${todo.status }</span></div>
								</div>
								<div class="card-body">
									<div class="row mb-3">
										<div class="col-9">
											<small>${todo.content }</small>
										</div>
										<div class="col-3">
											<button type="button" class="btn btn-outline-secondary btn-sm" onclick="openTodoDetailModal(${todo.no})"><fmt:message key="button.label.detail"/></button>
										</div>
									</div>
									<div class="d-flex justify-content-between">
										<span class="text-secondary font-weight-bold">${todo.userName }</span>											
										<strong><fmt:formatDate value="${todo.day }"/> </strong>
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
						
					</div>
					<div class="row">
						<div class="col-12 text-center"><button class="btn btn-outline-dark btn"> <fmt:message key="button.label.more"/> </button></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 상세정보 모달창 -->
	<div class="modal" id="modal-todo-detail">
		<div class="modal-dialog modal-lg">
 			<div class="modal-content">
   				<div class="modal-header">
     				<h4 class="modal-title">상세 정보</h4>
     				<button type="button" class="close" data-dismiss="modal">&times;</button>
   				</div>
   				<div class="modal-body">
     				<div class="row">
     					<div class="col-12">
     						<table class="table table-bordered table-sm">
     							<colgroup>
     								<col width="15%">
     								<col width="35%">
     								<col width="15%">
     								<col width="35%">
     							</colgroup>
     							<tbody>
     								<tr>
     									<th>제목</th>
     									<td colspan="3" id="detail-todo-title"></td>
     								</tr>
     								<tr>
     									<th>작성자</th>
     									<td id="detail-todo-writer"></td>
     									<th>등록일</th>
     									<td id="detail-todo-create"></td>
     								</tr>
     								<tr>
     									<th>상태</th>
     									<td id="detail-todo-status">처리예정</td>
     									<th>예정일</th>
     									<td id="detail-todo-day"></td>
     								</tr>
     								<tr>
     									<th style="vertical-align: middle;">내용</th>
     									<td colspan="3" id="detail-todo-content"><small> </small></td>
     								</tr>
     							</tbody>
     						</table>
     					</div>
     				</div>
   				</div>
   				<div class="modal-footer">
   					<span id="buttons" style="display: none;">
   						<button id="detail-todo-no" style="display: none;"></button>
	     				<button id="처리완료" type="button" class="btn btn-success btn-sm" onclick="updateStatusBtn('처리완료')">처리완료</button>
	     				<button id="처리중" type="button" class="btn btn-info btn-sm" onclick="updateStatusBtn('처리중')">처리중</button>
	     				<button id="보류" type="button" class="btn btn-secondary btn-sm" onclick="updateStatusBtn('보류')">보류</button>
	     				<button id="취소" type="button" class="btn btn-danger btn-sm" onclick="updateStatusBtn('삭제')">삭제</button>
     				</span>
     				<button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal" >닫기</button>
   				</div>
 			</div>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
</div>
</fmt:bundle>
<script type="text/javascript">
	function openTodoDetailModal(todoNo) {
		$("#modal-todo-detail").modal('show');
		detailModal(todoNo);
		
	}
	
	function detailModal(todoNo){
		document.getElementById('buttons').style.display = "none";
		var data = todoNo;
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				var text = xhr.responseText;
				var resData = JSON.parse(text);
				
				console.log(resData);
				document.getElementById('detail-todo-no').textContent = resData.no;
				document.getElementById('detail-todo-title').textContent = resData.title;
				document.getElementById('detail-todo-writer').textContent = resData.userName;
				document.getElementById('detail-todo-create').textContent = resData.createDate;
				document.getElementById('detail-todo-status').textContent = resData.status;
				document.getElementById('detail-todo-day').textContent = resData.day;
				document.getElementById('detail-todo-content').textContent = resData.content;
				
				if(resData.canModify){
					document.getElementById('buttons').style.display = "";
				}
				
			}
			
		};
		
		xhr.open("get","/todo/detail.hta?todono="+data);
		xhr.send();
	}
	
	function updateStatusBtn(status) {
		var data = document.getElementById('detail-todo-no').textContent;
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				var text = xhr.responseText;
				var resData = JSON.parse(text);
				var statusClass = resData.statusClass;
				console.log(resData);
				document.getElementById('detail-todo-status').textContent = status;
				document.getElementById('card-status-'+ data).innerHTML = "<span class='badge "+statusClass + "'>"+status+"</span>"
				
			}
		};
		xhr.open("get", "/todo/updatestatus.hta?todono="+data+"&status="+status);
		xhr.send();
	}
	
	
</script>
</body>
</html>
