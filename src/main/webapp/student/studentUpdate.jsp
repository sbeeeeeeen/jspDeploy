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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>	
$(function(){
	$("#findAddr").click(function(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            $("#zipcdLabel").text(data.zonecode);
	            $("#zipcdInput").val(data.zonecode);
	            
	            $("#addr1Label").text(data.address);
	            $("#addr1Input").val(data.address);
	            
	            $("#addr2").val('');
	        }
	    }).open();
	});
	
	$("#updateBtn").on("click", function(){
		//학생 이름, 상세주소
		if($("#name").val().length < 2){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		
		if($("#addr2").val().length < 5){
			alert("상세주소를 입력하세요");
			$("#addr2").focus();
			return false;
		}
		
		console.log($("#frm").serialize());
// 		$("#frm").submit();
	});
});
</script>
</head>
<body>
	<%@include file="../common/top.jsp"%>
<!-- 	<form id="frm" action="/studentDetail" method="get"> -->
<!-- 		<input type="hidden" name="id"> -->
<!-- 	</form> -->
	<div class="container-fluid">
		<div class="row">
			<%@include file="/common/left.jsp"%>
			<div class="container-fluid">
				<div class="row">
					<%@include file="/common/left.jsp"%>
					<div
						class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
						<form class="form-horizontal" role="form" id="frm" action="/studentUpdate" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">학생
									프로필</label>
								<div class="col-sm-10">
									<img src="/pic?id=${student.id }" />
									<input type="file" name="pic">
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">학생
									아이디</label>
								<div class="col-sm-10">
									<label class="control-label">${student.id }</label>
									<input type="hidden" class="form-control" id="id" name="id"
									placeholder="${student.id }" >
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">학생 이름</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="name" name="name"
									placeholder="학생 이름" value="${student.name }">
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
									<input type="hidden" name="addr1" id="addr1Input" value="${student.addr1 }">
									<label class="control-label" id="addr1Label">${student.addr1 }</label>
									<button type="button" id="findAddr" class="btn btn-default">주소찾기</button>
								</div>
							</div>
							<div class="form-group">
								<label for="addr2" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="addr2" name="addr2"
									placeholder="상세주소" value="${student.addr2 }">
								</div>
							</div>
							<div class="form-group">
								<label for="addr2" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									<input type="hidden" name="zipcd" id="zipcdInput" value="${student.zipcd }">
									<label class="control-label" id="zipcdLabel">${student.zipcd}</label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" id="updateBtn" class="btn btn-default">수정</button>
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
