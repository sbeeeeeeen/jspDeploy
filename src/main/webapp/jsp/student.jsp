<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
td{
		border:1px solid blue;
	}
</style>
</head>
<body>
<!-- oracle db의 student 테이블을 조회하여 화면에 출력 -->
<table>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="pc16";
		String pass ="java";
		conn = DriverManager.getConnection(url, user, pass);
		
		stmt = conn.createStatement();
		
		String sql = "select * from student";
		rs = stmt.executeQuery(sql);
		
// 		rs.afterLast();
// 		rs.beforeFirst();
		
// 		rs.first();
// 		rs.last();
		
// 		rs.previous();
		
		while(rs.next()){
			out.write("<tr>");
			out.write("<td>" + rs.getInt("std_num") + "</td>");
			out.write("<td>" + rs.getString("std_name")+ "</td>");
			out.write("<td>" + rs.getInt("std_kor")+ "</td>");
			out.write("<td>" + rs.getInt("std_eng")+ "</td>");
			out.write("<td>" + rs.getInt("std_mat")+ "</td>");
			out.write("</tr>");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally{
		if(rs != null) try { rs.close();} catch (SQLException e2) {	}
		if(stmt != null) try { stmt.close();} catch (SQLException e2) {	}
		if(conn != null) try { conn.close();} catch (SQLException e2) {	}
	}
%>
</table>
</body>
</html>