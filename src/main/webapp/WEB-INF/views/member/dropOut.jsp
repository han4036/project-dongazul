
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
	<head>
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원탈퇴</title>

		<link rel="stylesheet" href="/resources/css/dropOut.css">
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancle").on("click", function(){
				
				location.href = "/matching/swipe";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#passwd").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#passwd").focus();
					return false;
				} else if($("#passwd").val()!="${msg == false}") {
					var result = confirm("계속 진행할 경우 회원정보는 영구 삭제됩니다. \n\n진행하시겠습니까?")
					if(result) return true;
					else return false;
				}
			});
			
		})

	</script>
	<body>
		<div class="wrap">
			<div class="box">

				<h1>회원탈퇴</h1>

		<section id="container">
			<form action="/member/dropOut" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="email">E-mail</label>
					<input class="form-control" type="text" id="email" name="email" value="${member.email}" readonly="readonly"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="passwd">Password</label>
					<input class="form-control" type="password" id="passwd" name="passwd" />
				</div>
				
				<div class="form-group has-feedback buttons">
					<button class="btn btn-success" type="submit" id="submit">회원탈퇴</button>
					<button class="cancle btn btn-danger" type="button">취소</button>
				</div>
			</form>
			<div>
				<c:if test="${msg == false}">
					<h4>비밀번호가 틀립니다.</h4>
				</c:if>
			</div>
		</section>

			</div>
		</div>

	</body>
	
</html>
