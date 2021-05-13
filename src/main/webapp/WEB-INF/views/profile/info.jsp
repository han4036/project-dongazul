<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아줄 : 내 프로필</title>

<!--fontawesome ---->
<script src="https://kit.fontawesome.com/dc299fac74.js" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.3.2/jquery-migrate.min.js"></script>

<link rel="stylesheet" href="/resources/css/info.css">

</head>

<script type="text/javascript">
		$(document).ready(function(){
			$("#signOut").on("click", function(){
				location.href="/login/signOut";
			})
			
		$("#memberUpdateBtn").on("click", function(){
			location.href="/member/checkPw";
		})
		
		var msg = '${msg}';
        if (msg.length > 0) {
            alert(msg);
        }		
	})
	</script>
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
                    ${profile.nickname}, &nbsp;<span>${profile.age}</span>
                </h2>
                
                <h3>좋아요</h3>
            </div>

        </div>
        <div class="setting">
            <div class="set">
                <!-- a를 원래 버튼으로 기능 넣어줘야함 -->
                <a href="#" class="fas fa-cog fasrow"></a>
                <p>설정</p>

            </div>
            <div class="set">
                <a href="/profile/update?email=${member.email}" class="fas fa-id-card fasrow profile-up"></a>
                <p>프로필 수정</p>
            </div>
            <div class="set">
                <a href="/profile/create" class="fas fa-camera fasrow"></a>
                <p>미디어 추가</p>
            </div>
        </div>

        <form action="/matching/swipe" method="get">
            <input type="submit" value="←">
        </form>
        
        <form action="/member/dropOut" method="get">
			<input type="submit" value="회원탈퇴">
	 </form>
	 <button id="memberUpdateBtn" type="button">회원정보수정</button>
     <button id="signOut" type="button">로그아웃</button>
    </div>  

</body>
</html>