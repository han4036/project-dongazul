 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>findIdResult.jsp</title>
<link rel="stylesheet" href="/resources/css/findIdResult.css">
</head>
<body>

	<div class="wrap">
		<div class="box">
			<h1>이메일</h1>
			
			<div class="result">
			<c:set var="name" value="${FIND}" />
			
			<c:set var ="id" value="${fn:substringBefore(FIND, '@')}" />
			<c:set var ="address" value="${fn:substringAfter(FIND, '@') }" />
			<c:set var="totalLength" value="${fn:length(id) }" />
			
			<c:set var="first"      value="${fn:substring(id, 0, 2) }" />
			<c:set var="last"      value="${fn:substring(id, 5, totalLength) }" />
			
			<c:if test="${!empty name}"> 
			
			${first}***${last}@${address} 
			
			</c:if>
			</div>
			<hr>
			<form action="/" method="get">
				<input type="submit" value="홈으로 돌아가기" class="back">
			</form>
		</div>
	</div>
</body>
</html>