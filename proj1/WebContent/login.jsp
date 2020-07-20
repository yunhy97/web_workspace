<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width" initial-scale="1">
	<!-- viewport=화면상의 표시영역, content=모바일 장치들에 맞게 크기조정, initial=초기화면 배율 설정 -->
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- 스타일시트로 css폴더의 bootstrap.css파일 사용 -->
	
	<title>jsp 게시판 웹사이트</title>
</head>
<body>

 <nav class="navbar navbar-default">
  <div class="navbar-header">
   <button type="button" class="navbar-toggle collapsed" 
    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
    aria-expanded="false">
    <!-- class="navbar-toggle collapsed"=>네비게이션의 화면 출력유무 
				data-toggle="collapse" : 모바일 상태에서 클릭하면서 메뉴가 나오게 설정 -->
				
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="main.jsp">JSP 게시판</a>
    <!-- Bootstrap navbar 기본 메뉴바 -->
    
  </div>
  <div class="collapse navbar-collapse" id="#bs-example-navbar-collapse-1">
   <ul class="nav navbar-nav">
    <li><a href="main.jsp">메인</a></li>
    <li><a href="bbs.jsp">게시판</a></li>
    <!-- 메뉴, 게시판의 main.jsp와 bbs.jsp의 파일로 각각 이동 -->
    
   </ul>
   <ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
     <a href="#" class="dropdown-toggle"
      data-toggle="dropdown" role="button" aria-haspopup="true"
      aria-expanded="false">접속하기<span class="caret"></span></a>
      <!-- 임시의 주소링크 "#"을 기재한다. -->
	  <!-- caret = creates a caret arrow icon (▼) -->
      
     <ul class="dropdown-menu">
     <!-- dropdown-menu : 버튼을 눌렀을때, 생성되는 메뉴(접속하기를 눌렀을때 로그인, 회원가입 메뉴 -->
     
      <li class="active"><a href="login.jsp">로그인</a></li>
      <!-- active = 활성화 되었을때 로그인, 회원가입-->
							
      <li><a href="join.jsp">회원가입</a></li>
     </ul>
    </li>
   </ul>
  </div> 
 </nav>

 <div class="container">
 <!-- 전체 레이아웃 감싸주기 -->
  <div class="col-lg-4"></div>
  <div class="col-lg-4">
   <div class="jumbotron" style="padding-top: 20px;">
   <!-- jumbotron indicates a big box(큰 상자) -->
   
   <form method="post" action="loginAction.jsp">
    <h3 style="text-align: center;"> 로그인화면 </h3>
    <div class="form-group">
     <input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
    </div>
    <div class="form-group">
     <input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
    </div>
    <input type="submit" class="btn btn-primary form-control" value="로그인">
   </form>
  </div>
 </div>
</div>
 <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
 <script src="js/bootstrap.js"></script>
</body>
</html>
