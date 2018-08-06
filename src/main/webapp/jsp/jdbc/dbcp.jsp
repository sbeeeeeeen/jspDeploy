<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- db connection 얻는 방법 3가지 
		1. jdbc
		2. application connection pool
		3. W(eb) A(pplication) S(erver) jndi connection pool
		
		각 방법별로 connection을 생성하는 시간 profiling
	-->
	
<%
	//db 설정에 대한 값 설정
	String driverClassName = "oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String username = "pc16";
	String password = "java";
	int poolSize = 10;
	
	BasicDataSource bds = new BasicDataSource();
	bds.setUrl(url);
	bds.setUsername(username);
	bds.setPassword(password);
	bds.setInitialSize(poolSize);
	
	Connection conn = null;
	try{
		long startTime = System.currentTimeMillis();
		//connection을 50번 얻어오고 해제한다.
		for(int i=0; i<50; i++){
			conn = bds.getConnection();
			out.write("Schema : " + conn.getSchema() + "<br>");
			conn.close();
		}
		long endTime = System.currentTimeMillis();
		out.write("during : " + (endTime-startTime)+"ms");
		bds.close();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(conn!=null)try{conn.close();}catch(Exception e){}
	}
	
%>
	
</body>
</html>