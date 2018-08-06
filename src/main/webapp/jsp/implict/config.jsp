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
		//config : 설정 --> application으로 대체 가능 
		config.getInitParameter("ADMIN_USER");
		application.getInitParameter("ADMIN_USER");
	%>
	config.getInitParameter("ADMIN_USER") : <%=config.getInitParameter("ADMIN_USER") %><br>
	application.getInitParameter("ADMIN_USER") : <%=application.getInitParameter("ADMIN_USER") %>
</body>
</html>