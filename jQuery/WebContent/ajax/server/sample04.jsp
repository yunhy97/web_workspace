<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	//2초 지연
	Thread.sleep(2000);

	Map<String, Object> map = new HashMap<String,Object>();
	
	map.put("name","홍길동");
	map.put("tel","010-1234-5678");
	map.put("email","hong@gmail.com");
	map.put("age", 46);
	map.put("married",true);
	map.put("family",new String[]{"김엄마","홍아들","홍공주"});
	
	Gson gson = new Gson();
	String text = gson.toJson(map);
	out.write(text);
%>
