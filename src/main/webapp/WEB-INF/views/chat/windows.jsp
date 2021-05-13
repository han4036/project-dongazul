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
	<title>window.jsp</title>
	
</head>

<body>
<table class="type09">
                        <thead>
                            <tr>
                                <th scope="cols">roomid</th>
                                <th scope="cols">roomname</th>

                                <th scope="cols">createtime</th>
                                <th scope="cols">email</th>
                               
                            </tr>
                        </thead>
                        <tbody id="list">
                            <c:forEach items="${LISTCHAT}" var="li">
                                <tr>
                                    <td>${li.roomid}</td>
                                    <td><a href="/chat/do">${li.roomname}</a></td>
                                    <td>${li.insert_ts}</td>
                                    <td>${li.email}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>


<form action="/chat/rooms" method="get">
			<input type="submit" value="채팅방 만들기">
	 </form>
</body>

</html>