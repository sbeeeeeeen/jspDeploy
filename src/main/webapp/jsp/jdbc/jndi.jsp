<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
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
	//db 설정에 대한 값 설정
	Context context = new InitialContext();
	DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
		

	String driverClassName = "oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String username = "pc16";
	String password = "java";
	int poolSize = 10;
	
	Connection conn = null;
	try{
		long startTime = System.currentTimeMillis();
		//connection을 50번 얻어오고 해제한다.
		for(int i=0; i<500; i++){
			conn = dataSource.getConnection();
			out.write("Schema : " + conn.getSchema() + "<br>");
			conn.close();
		}
		long endTime = System.currentTimeMillis();
		out.write("during : " + (endTime-startTime)+"ms");
		//여기서 close하면 안됏 ! 
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(conn!=null)try{conn.close();}catch(Exception e){}
	}
	//localhost:8180/jsp/jdbc/jndi.jsp
%>
</body>
</html>