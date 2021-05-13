<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="resources/css/01.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.3.2/jquery-migrate.min.js"></script>
<link rel="stylesheet" href="/resources/css/swipe.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">


<!--fontawesome ---->
<script src="https://kit.fontawesome.com/dc299fac74.js" crossorigin="anonymous"></script>

</head>

	
<body>
	
		<nav class="navbar">
        <a class="fas fa-fire" href="/"></a> 
		<a class="fas fa-comments" href="/chat/windows"></a>
        <a class="fas fa-user" href="/profile/info?email=${member.email}"></a>
    </nav>
    <div class="wrapper">
	<div class="container">
	<ul class="slider">
		<c:forEach items="${LIST}" var="li">
		
			<td class="item"><a href="/profile/infoThem?email=${li.email}"><img src="${li.imageRoot}"></a></td>
		
	</c:forEach>
	</ul>
	</div>
	<div class="btn">
		<a class="prev" style="text-decoration: none;">&#10094;</a>
		<a class="next" style="text-decoration: none;">&#10095;</a>
	</div>
</div>
<script src="/resources/js/slide.js"></script>
    
</body>
</html>