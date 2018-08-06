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
	<hr>
	session 기본 객체 sumResult : <%=session.getAttribute("sumResult") %><br>
	세션은 서버랑 연결이 끊기기 전까지 값을 갖고있삼<br>
	세션 객체 죽이는것도 있는데 뭔지 못들음
	<hr>
	<%HttpSession hs = request.getSession(); %>
	request 객체 sumResult : <%=hs.getAttribute("sumResult") %><hr>
	
	localhost:8180/jsp/implict/session.jsp
</body>
</html>