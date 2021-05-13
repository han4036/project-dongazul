<%@page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">
	<title>동아줄 : 채팅방 생성</title>
	
</head>

<body>

	<h1>WEB-INF/views/chat/do.jsp</h1>
	
	<hr>

	<form action="/chat/rooms" method="POST">
	<input type="hidden" name="email" value="${member.email}">
	<input type="text" name='roomname'>
	<button type="submit" value='submit'>등록</button>
	
	</form>

</body>

</html>