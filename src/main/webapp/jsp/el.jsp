<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jsp붙은게 1.2(최신)버전 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
el.jsp
<h3>request</h3>
표현식 : <%=request.getAttribute("requestScop") %><br>
EL : ${requestScope.requestScop}<br>

<h3>session</h3>
표현식 : <%=session.getAttribute("sessionScop") %><br>
EL : ${sessionScope.sessionScop}<br>

<h3>application</h3>
표현식 : <%=application.getAttribute("applicationScop") %><br>
EL : ${applicationScope.applicationScop}<br>

<h3>sameName</h3>
EL : ${sameName} 어떤 영역의 값을 가져오나?? >> 가장 작은 영역에서부터 큰 영역으로 검색<br>
pageContext > request > session > application<hr>

<h3>studentList</h3>
표현식 <br>
<br><br><br>
<table>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>call_cnt</th>
	</tr>
<%
for(StudentVo std : (List<StudentVo>)request.getAttribute("studentList")){
 	out.write("<tr>");
 	out.write("<td>" + std.getId() + "</td>");
 	out.write("<td>" + std.getName() + "</td>");
 	out.write("<td>" + std.getCall_cnt() + "</td>");
 	out.write("</tr>");
} %>
</table>
<%-- EL : ${studentList}<br> --%>
<hr>
<br><br><br>
<table>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>call_cnt</th>
	</tr>
	<c:forEach items="${studentList}" var="vo">
	<tr>
		<td>${vo.id}</td>
		<td>${vo.name}</td>
		<td>${vo.call_cnt}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>







