<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../favicon.ico">
<title>Jsp</title>
<script src="../js/jquery-1.12.4.js"></script>
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="../bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="../css/dashboard.css" rel="stylesheet">
<link href="../css/common.css" rel="stylesheet">
<link href="../css/blog.css" rel="stylesheet">
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/common/left.jsp"%>
			<div class="container-fluid">
				<div class="row">
					<%@include file="/common/left.jsp"%>
					<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
						<form class="form-horizontal" role="form" action="/studentUpdate" method="get">
							<input type="hidden" name="id" value="${student.id }">
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">학생
									프로필</label>
								<div class="col-sm-10">
									<img src="/pic?id=${student.id }" />
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">학생
									아이디</label>
								<div class="col-sm-10">
									<label class="control-label" >${student.id }</label>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">학생 이름</label>
								<div class="col-sm-10">
									<label class="control-label">${student.name }</label>
								</div>
							</div>
							<div class="form-group">
								<label for="call_cnt" class="col-sm-2 control-label">호출횟수</label>
								<div class="col-sm-10">
									<label class="control-label">${student.call_cnt }</label>
								</div>
							</div>
							<div class="form-group">
								<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
								<div class="col-sm-10">
									<label class="control-label"> <fmt:formatDate
											value="${student.reg_dt}" pattern="yyyy-MM-dd" />
									</label>
								</div>
							</div>
							<div class="form-group">
								<label for="addr1" class="col-sm-2 control-label">주소</label>
								<div class="col-sm-10">
									<label class="control-label">${student.addr1 }</label>
								</div>
							</div>
							<div class="form-group">
								<label for="addr2" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-10">
									<label class="control-label">${student.addr2 }</label>
								</div>
							</div>
							<div class="form-group">
								<label for="addr2" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									<label class="control-label">${student.zipcd}</label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-default">학생 수정</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
