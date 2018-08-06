<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	sumResult : <%=request.getAttribute("sumResult") %>
	<% %>
	<hr>
	session 기본 객체 sumResult : <%=session.getAttribute("sumResult") %>
	<hr>
	<%HttpSession hs = request.getSession(); %>
	request 객체 sumResult : <%=hs.getAttribute("sumResult") %>
</body>
</html>