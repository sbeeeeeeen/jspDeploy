<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
request객체에 code속성이 "02"값으로 존재<br>
엥..근데 else가 없음...<br>
choose가 일반적인 if<br>
<c:if test="${code=='02'}">
	sally<br>
</c:if>
<h3>choose</h3>
c:when test="${code=='01'}" EL안에서 테스트를 거쳐야함<br>
c:otherwise <hr>
<c:choose>
	<c:when test="${code == '01' }">brown</c:when>
	<c:when test="${code == '02' }">sally</c:when>
	<c:when test="${code == '03' }">cony</c:when>
	<c:otherwise>line rangers</c:otherwise>
</c:choose>
</body>
</html>