<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아줄 : 상대 프로필</title>

<!--fontawesome ---->
<script src="https://kit.fontawesome.com/dc299fac74.js" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.3.2/jquery-migrate.min.js"></script>

<link rel="stylesheet" href="/resources/css/infoThem.css">

</head>

<body>

    <div id="wrapper"> 


        <div class="profile-main">
            <div class="photo-name">
                <div class="photo-pro">
                	<c:if test="${ profile != null }">
                    <img src="${ profile.imageRoot }" alt="img1" class="img1">
                    </c:if>
                </div>
                <h2 class="values">
                    ${profile.nickname} &nbsp;<span>${profile.age}</span>
                </h2>
               <h3> ${profile.introduce} </h3>
 
            </div>

        </div>

        <form action="/matching/swipe" method="get">
            <input type="submit" value="←">
        </form>
        
    </div>  

</body>
</html>