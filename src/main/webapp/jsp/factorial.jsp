<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	public int factorial(int fac){
		if(fac<0) return 0;
		else if(fac<2) return 1;
		else return fac*factorial(fac-1);
	}
	%>
	
	factorial(-1) : <%=factorial(-1) %> <br>
	factorial(4) : <%=factorial(4) %> <br>
	factorial(5) : <%=factorial(5) %> <br>
	factorial(6) : <%=factorial(6) %> <br>
	
	
	=============================================<br>
	
	
	<%for(int i=0; i<9; i++){ 
		int sum = i;
		for(int j=i-1; j>0; j--){
			sum*=j;%>
		<%}%>
		factorial(<%=i%>) : <%=sum%>	<br>	
	<%} %>
</body>
</html>