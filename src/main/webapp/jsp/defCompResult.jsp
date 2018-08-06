<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
파라미터 값 확인 <br>
${defComp } : 속성에서 값 확인<br>
${param.defComp } : request객체의 파라미터 값 확인<br>
${cookies.defComp } : cookie값 확인<br>
<hr>
request.defComp : ${param.defComp }<br>
</body>
</html>