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
		//값을 각 영역에 설정
		pageContext.setAttribute("pageScope", request.getParameter("pageScope"));
		request.setAttribute("requestScope", request.getParameter("requestScope"));
		session.setAttribute("sessionScope", request.getParameter("sessionScope"));
		application.setAttribute("applicationScope", request.getParameter("applicationScope"));
		
		//각 영역의 속성을 출력해줄 결과 화면으로 위임(forward)
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/scope/scopeResult.jsp");
		rd.forward(request, response);
		
	%>
	pageScope : 
	requestScope : 
	sessionScope : 
	applicationScope : 
</body>
</html>