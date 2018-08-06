<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%UserVo uv = (UserVo)session.getAttribute("userVo"); %>
	userId = <%=uv!=null?uv.getUserId():null %><br>
	main.jsp
	
	<h3>메뉴</h3>
	<a href="/boardList">게시판 고</a>
</body>
</html>