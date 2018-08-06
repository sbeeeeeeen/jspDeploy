<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	FileReader reader = new FileReader(application.getRealPath("/main.jsp"));
	pageContext.setAttribute("reader", reader);
// 	application.getRealPath("/main.jsp");
%>
<%-- <%=application.getRealPath("/main.jsp") %> --%>
<c:out value="${reader}"></c:out>
</body>
</html>