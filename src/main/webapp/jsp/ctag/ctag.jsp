<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
th, td {
    padding: 7px;
    border: 1px solid black;
    text-align: center;
}
</style>
<body>
<tags:logging/><br>
<tags:colorLogging color="green" size="20"/>
	<table>
		<tr>
			<th>학생 ID</th>
			<th>학생 이름</th>
			<th>지명 횟수</th>
			<th>등록일자</th>
		</tr>
		<c:forEach items="${studentList}" var="vo">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.name}</td>
				<td>${vo.call_cnt}</td>
				<td><fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd" /></td>
			<tr>
		</c:forEach>
	</table>
<tags:colorLogging color="blue"/><br>
<tags:logging/>
<hr>
<h3>prodSelect</h3>
<tags:prodSelect lgu="P101"/><br>
<tags:prodSelect lgu="P102"/>
</body>
</html>