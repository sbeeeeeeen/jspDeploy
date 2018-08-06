<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	RequestDispatcher rd = request.getRequestDispatcher("/common/header.jsp");
	request.setAttribute("userId", "brown");
	rd.include(request, response);
%>
<h3>dymanicInclude.jsp</h3>
</body>
</html>