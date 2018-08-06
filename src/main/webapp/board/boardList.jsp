<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	td{
		border:1px solid blue;
	}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<BoardVo> boardList = (List<BoardVo>)application.getAttribute("boardList"); %>
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>사용자 아이디</th>
				<th>별명</th>
				<th>등록일(yyyy-MM-dd)</th>
			</tr>
		</thead>
		<tbody>
			<%
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0; i<boardList.size(); i++){
				out.write("<tr>");
				out.write("<td>"+boardList.get(i).getTitle()+"</td>");
				out.write("<td>"+boardList.get(i).getUserId()+"</td>");
				out.write("<td>"+boardList.get(i).getAlias()+"</td>");
				out.write("<td>"+sdf.format(boardList.get(i).getRegDt())+"</td>");
				out.write("</tr>");
			}
			%>
		</tbody>
	</table>
</body>
</html>