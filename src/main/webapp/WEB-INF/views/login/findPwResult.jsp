<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>findPwResult.jsp</title>
<link rel="stylesheet" href="/resources/css/findPwResult.css">
</head>
<body>
	
	<div class="wrap">
		<div class="box">
			
			<h1>비밀번호 찾기 결과</h1>
			<div class="result">
			비밀번호 : ${fn:substring(FINDPW, 0, 4)}
			
			<c:forEach begin="1" end="${fn:length(FINDPW)-4}">
							*
					</c:forEach>
					</div>
			<hr>
			<form action="/" method="get">
				<input type="submit" value="홈으로 돌아가기" class="back">
			</form>

		</div>
	</div>

</body>
</html>
