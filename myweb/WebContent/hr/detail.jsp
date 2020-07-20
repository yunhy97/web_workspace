<%@page import="com.sample.vo.Employee"%>
<%@page import="com.sample.dao.EmployeeDao"%>
<%@page import="com.sample.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사원 리스트</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<h1>사원 정보</h1>
		</div>
		<div class="body">
			<div>
			<%
				int employeeId = NumberUtil.stringToInt(request.getParameter("empid"));
				int pageNo = NumberUtil.stringToInt(request.getParameter("page"), 1);
				
				EmployeeDao dao = new EmployeeDao();
				Employee emp = dao.getEmployeeById(employeeId);
			%>
				<p>사원정보를 확인하세요.</p>
				<table class="table bordered">
					<tbody>
						<tr>
							<th>아이디</th>
							<td><%=emp.getId() %></td>
							<th>이름</th>
							<td><%=emp.getFirstName() %> <%=emp.getLastName() %></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><%=emp.getEmail() %></td>
							<th>전화번호</th>
							<td><%=emp.getPhoneNumber() %></td>
						</tr>
						<tr>
							<th>입사일</th>
							<td><%=emp.getHireDate() %></td>
							<th>직종</th>
							<td><%=emp.getJobId() %></td>
						</tr>
						<tr>
							<th>급여</th>
							<td><%=NumberUtil.numberWithComma((int)emp.getSalary()) %></td>
							<th>커미션</th>
							<td><%=emp.getCommissionPct() %></td>
						</tr>
						<tr>
							<th>매니저</th>
							<td><%=emp.getManagerFirstName() %> <%=emp.getManagerLastName() %></td>
							<th>소속부서</th>
							<td><%=emp.getDepartmentName() %></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="text-right">
				<a href="modifyform.jsp">수정</a>
				<a href="list.jsp?page=<%=pageNo%>">목록</a>
			</div>
		</div>
	</div>
</body>
</html>