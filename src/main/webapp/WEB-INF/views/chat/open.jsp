<%@page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">
	<title>채팅방 생성 </title>
	<script>
		function submitAddForm(form) {
			form.title.value = form.title.value.trim();

			if(form.title.value.length == 0) {
				alert('채팅방 이름을 입력하세요');
				form.title.focus();
				return false;
			}
		}
	</script>
	<style>
		.con{
			width: 1000px;
			margin: 0 auto;
		}
	</style>
</head>

<body>
	<h1 class="con">채팅방 생성</h1>
	<div class="con">

		<form 
			name="addForm" 
			onsubmit="submitAddForm(this); 
			return false;"
			 action="./doAdd" method="POST">
		
		<div>
			<span>채팅방 이름</span>
			<div>
				<input autocomplete="off" type="text" name="title"
				 required="required", autofocus="autofocus", maxlength="30" placeholder="이메일">
			
			</div>
		</div>
		 <div>
			 <input type="submit" value="생성">
		 </div>
		</form>
	</div>
	<hr>

</body>

</html>