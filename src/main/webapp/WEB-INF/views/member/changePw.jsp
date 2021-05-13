<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html>
	<head>
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>동아줄 : 회원정보수정</title>

		<link rel="stylesheet" href="/resources/css/changePw.css">
	</head>
	<script type="text/javascript">
		$(document).ready(function(){

			$(".cancle").on("click", function(){
				
				location.href = "/profile/info?email=${member.email}";			    
			})
		
			$("#submit").on("click", function(){
				if($("#passwd").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#phonenumber").focus();
					return false;
				}
				if($("#phonenumber").val()==""){
					alert("전화번호를 입력해주세요.");
					$("#phonenumber").focus();
					return false;
				}
				
				if (!chkPwd($.trim($('#passwd').val()))) {

					alert('비밀번호를 확인하세요. (영문,숫자를 혼합하여 6~15자 이내)');
					$('#passwd').val('');
					$('#passwd').focus();
					return false;
				}
			});
			
			$('#passwd').keyup(function () {
				$('#chkNotice').html('');
			});

			$('#passwdChk').keyup(function () {

				if ($('#passwd').val() != $('#passwdChk').val()) {
					$('#chkNotice').html('비밀번호 일치하지 않음');
					$('#chkNotice').css('color', 'red');
					$('#submit').attr('disabled', true);
				} else {
					$('#chkNotice').html('비밀번호 일치함');
					$('#chkNotice').css('color', 'blue');
					$('#submit').attr('disabled', false);
				}

			});
		})
		function chkPwd(str) {

			var reg_pwd = /^.*(?=.{6,15})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

			if (!reg_pwd.test(str)) {
				return false;
			}
			return true;
		}
		
		
		
	</script>
	<body>
		<div class="wrap">
			<div class="box">		
				<!-- ↑↑↑↑ 배경 추가 태그 ↑↑↑↑ -->

				<h1>회원정보수정</h1>

				<section id="container">
					<form action="/member/changePw" method="post">
	
					<input class="form-control" type="hidden" id="email" name="email" value="${member.email}" />
					
							<div class="form-group has-feedback">
							<label class="control-label" for="passwd">새로운 비밀번호</label>
							<input class="form-control" type="password" id="passwd" name="passwd" 
							placeholder="영문, 숫자혼합 6~15자"/>
							</div>
							<div class="form-group has-feedback">
							<label class="control-label" for="pw">비밀번호 확인</label>
							<input class="form-control" type="password" id="passwdChk" name="passwdChk" />
							<span id="chkNotice"></span>
							</div>
							
						<div class="form-group has-feedback">
							<label class="control-label" for="phonenumber">Phone-Number</label>
							<input class="form-control" type="text" id="phonenumber" name="phonenumber" value="${member.phonenumber}"/>
						</div>

						<div class="form-group has-feedback buttons">
							<button class="btn btn-success" type="submit" id="submit">회원정보수정</button>
						</div>
						<div class="form-group has-feedback buttons">
							<button class="cancle btn btn-danger" type="button">취소</button>
						</div>
						
					</form>
				</section>

			</div>
		</div>
		
	</body>
	
</html>
 

 