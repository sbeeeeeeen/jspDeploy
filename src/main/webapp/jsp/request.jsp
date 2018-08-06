<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	PrintWriter pw = response.getWriter();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//jsp 기본 객체 : request, response
	
	%>
	
	request.getLocalPort() : <%= request.getLocalPort() %><br>
	request.getLocalAddr() : <%= request.getLocalAddr() %><br>
	request.getRemoteAddr() : <%= request.getRemoteAddr() %><br>
	request.getRemoteHost() : <%= request.getRemoteHost() %><br>
	request.getRemotePort() : <%= request.getRemotePort() %><br>
	request.getCharacterEncoding() : <%= request.getCharacterEncoding() %><br>
	request.getcontentType() : <%= request.getContentType() %><br>
	request.getContextPath() : <%= request.getContextPath() %><br>
	request.getRequestURL() : <%= request.getRequestURL() %><br>
	request.getRequestURI() : <%= request.getRequestURI() %><br>
	request.getServerName() : <%= request.getServerName() %><br>
	request.getServerPort(): <%= request.getServerPort() %><br>
	request.getMethod() : <%= request.getMethod() %>
</body>
</html>