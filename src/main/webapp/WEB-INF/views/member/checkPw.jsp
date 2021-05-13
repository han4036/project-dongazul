<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html>
	<head>
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>동아줄 : 비밀번호확인</title>

		<link rel="stylesheet" href="/resources/css/changePw.css">
	</head>
	<script type="text/javascript">
		$(document).ready(function(){

			$(".cancle").on("click", function(){
				
				location.href = "/profile/info";			    
			})
		})
		
		
		function fn_checkPw() {
			if ($("#passwd").val() == '' || $("#passwd").val() == 'undefined') return;
			$.ajax({
				url: "/member/checkPw",
				type: "POST",
				datatype: "json",
				data: {
					"passwd" : $("#passwd").val()
					},
				success: function(data) {
								
					if(data == 1) {
						alert('비밀번호가 일치합니다.')
						self.location = '/member/changePw'	
					} else {
						$('#submit').attr('disabled', true);
						alert('비밀번호가 틀렸습니다.')
					}
												
				}
			});
		}
	
	</script>
	<body>
		<div class="wrap">
			<div class="box">		
				<!-- ↑↑↑↑ 배경 추가 태그 ↑↑↑↑ -->

				<h1>비밀번호확인</h1>

				<section id="container">
					
						<div class="form-group has-feedback">
							<label class="control-label" for="passwd">비밀번호</label>
							<input class="form-control" type="password" id="passwd" name="passwd" />
							<button class="checkPw" type="button" id="checkPw" 
							onclick="fn_checkPw();">비밀번호확인</button>
							</div>
						
					
				</section>

			</div>
		</div>
		
	</body>
	
</html>
 