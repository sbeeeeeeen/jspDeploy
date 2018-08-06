<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.DriverManager"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="lgu" type="java.lang.String" required="true"%>
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
		
		String sql = "select prod_id, prod_name from prod where prod_lgu = '" + jspContext.getAttribute("lgu") + "'";
		rs = stmt.executeQuery(sql);
		
		out.write("<select>");
		while(rs.next()){
			out.write("<option value='"+rs.getString("prod_id")+"'>"+rs.getString("prod_name")+"</option>");
		}
		out.write("</select>");
		
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
