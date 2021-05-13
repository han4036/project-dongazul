<%@page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>동아줄 : 로그인</title>
    <link rel="stylesheet" href="/resources/css/login.css">
</head>


<body>
    <div class="wrap">
        <div class="login">
            <h2 id="title">Dongazul</h2>
            <div id="outter">
                <div class="between1"></div>
                <form action="/login/signInPost" method="POST">
                    <c:if test="${number == null}">
                        <div class="login_id">
                            <label for="email">E-mail</label>
                            <input type="text" id="email" name="email" placeholder="Email"><br>
                        </div>
                        <div class="login_pw">
                            <label for="passwd">Password</label>
                            <input type="password" id="passwd" name="passwd" placeholder="Password"><br>
                        </div>
                        <div class="login_etc">
                            <label for="rememberme">rememberMe</label>
                            <input type="checkbox" name="rememberme"><br>
                        </div>

                        <div class="between2"></div>

                        <div class="submit">
                            <input type="submit" value="Sign-In">
                        </div>
                    </c:if>

                </form>
                <div class="submit">
                    <form action="/member/signUp" method="GET">
                        <input type="submit" value="Sign-Up" />
                    </form>
                </div>
                <div class="submit">
                    <form action="/login/findId" method="get">
                        <input type="submit" value="forgot email?">
                    </form>
                </div>
                <div class="submit">
                    <form action="/login/findPw" method="get">
                        <input type="submit" value="forgot password?">
                    </form>
                </div>
            </div>
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