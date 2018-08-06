<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl 사용을 하기위해 taglib 지시자 작성 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- localhost:8180/jstlServlet -->
request.userId : ${userId} / ${requestScope.userId} <br>
set : 특정 영역에 변수를 새로 생성(default:page)<br>
c:set : <c:set var="test" value="testValue"/>
${test}<br>
<% pageContext.setAttribute("test", "testValue");%>
pageContext.getAttribute("test") : <%=pageContext.getAttribute("test") %>
<br> 두개는 동일함다
<h3>c:set scope</h3>
test : <c:set var="test" value="testSessionValue" scope="session"/> ${test }<br>
sessionScope.test : ${sessionScope.test}<br><br>
el은 영역이 작은 곳부터 큰 곳으로 순차 검색<br>
page>request>session>application<br>
<hr>
${std}<br>
<c:set target="${std}" property="name" value="brown"/>
${std}<br>
</body>
</html>