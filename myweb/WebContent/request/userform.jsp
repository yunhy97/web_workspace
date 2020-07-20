<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 등록 폼</h1>
	
	<h2>사용자를 등록하세요</h2>
	<form action="userregister.jsp" method="post">
	
	<div>
		<div>
			<label>아이디</label>
			<div><input type="text" name="userID"></div>
		</div>
		<div>
			<label>비밀번호</label>
			<div><input type="password" name="userPassword"></div>
		</div>
		<div>
			<label>이름</label>
			<div><input type="text" name="userName"></div>
		</div>
		<div>
			<label>이메일</label>
			<div><input type="text" name="userEmail"></div>
		</div>
		<div>
			<label>포인트</label>
			<div><input type="number" name="point"> 점</div>
		</div>
		<div>
			<button type="sumbit">제출</button>
		</div>
	</div>
	</form>
</body>
</html>