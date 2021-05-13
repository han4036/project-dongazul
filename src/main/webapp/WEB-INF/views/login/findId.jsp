 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findId.jsp</title>
<link rel="stylesheet" href="/resources/css/findId.css">
<script type="text/javascript">

		var msg = '${msg}';
        if (msg.length > 0) {
            alert(msg);
        }		
	
	</script>
</head>

<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="/resources/js/findId.js"></script>

<body>
	<div class="wrap">
		<div class="box">
			<h1>이메일 찾기</h1>
			
			<form action="/login/findIdResult" method="post">
				Tel: <input type="input" id="phonenumber" placeholder="-자 없이 입력" name="phonenumber" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
				<input type="submit" class="findEmail" value="이메일찾기">
			</form>

			<input type="submit" class="back" value="돌아가기" onclick="back()"></button>

		</div>
	</div>
	
	   <script type="text/javascript">

	$(document).ready(function () {
    var msg = '${msg}';
    if (msg.length > 0) {
        alert(msg);
    }
    
    })
    
</script>
</body>
</html>