<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">	
	<div class="row">
		<div class="col-12">
			<h1>입력폼</h1>
		</div>
		<div class="row">
			<div class="col-12">
				<form method="post" action="sample4.jsp">
					<div class="form-group">
						<label>이름</label>
						<input type="text" name="username" class="form-control"/>
					</div>
					
					<div class="form-group">
						<label>연락처</label>
						<input type="text" name="usertel" class="form-control"/>
					</div>
					
					<div class="text-right">
						<button type="submit" class="btn btn-primary">제출</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>