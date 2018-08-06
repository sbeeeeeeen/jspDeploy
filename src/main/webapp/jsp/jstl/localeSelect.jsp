<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="/common/jquery.jsp" %>
<script>
	$(function(){
		$("select[name=locale]").val("${param.locale}").prop("selected", true);
		$("select[name=locale]").change(function(){
			this.form.submit();
		});
	});
</script>
<body>
<form id="frm" action="/localeSelect" method="get">
	<select class="selectBox" name="locale">
		<option value="ko">한국어</option>
		<option value="en">English</option>
		<option value="ja">日本語</option>
	</select>
	<button type="submit">전송</button>
</form>
	
	<br><br>
	
	<fmt:setLocale value="${param.locale}"/>
	<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/>
	<fmt:message bundle="${msg }" key="hello"/><br>
	<fmt:message bundle="${msg }" key="visitor">
		<fmt:param value="${userId }"/>
	</fmt:message>
	<hr>
	

</body>
</html>