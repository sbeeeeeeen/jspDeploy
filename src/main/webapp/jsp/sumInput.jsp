<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=application.getContextPath()%>/sumCalculation" method="post"> 
	<!-- 이게뭐람 . . ? -->
		start <input type="text" name="start"><br>
		end <input type="text" name="end"><br>
		<button type="submit">보내기~!</button>
	</form>
</body>
</html>