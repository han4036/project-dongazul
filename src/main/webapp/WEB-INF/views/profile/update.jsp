<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>

    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>동아줄 : 프로필 수정</title>
    
    <link rel="stylesheet" href="/resources/css/update.css">
</head>

<script type="text/javascript">
   $(document).ready(function () {

       $('#introduce').on('keyup', function() {
           $('#text_cnt').html("("+$(this).val().length+" / 500)");
   
           if($(this).val().length > 500) {
               $(this).val($(this).val().substring(0, 500));
               $('#text_cnt').html("(500 / 500)");
           }
       });
       
       $('#myPicture').change(function(){
   		if(this.files && this.files[0]) {
   			var reader = new FileReader;
   			reader.onload = function(data){
   				$('.picture_box img').attr('src', data.target.result).width(110);
   			}
   			reader.readAsDataURL(this.files[0]);
   		}
   });

   })

   </script>

     <body>
        <div class="background">
         <section id="container">
             <form action="/profile/update" method="POST" enctype="multipart/form-data">
             <div class="pictures">
                <div class="picture_box"><img src="" />
                    <svg width="35" height="35" ><path d="M9 17.5 H26, M17.5 9 V26" stroke="#f0f0f0" stroke-width="2.7" stroke-linejoin="round"/></svg>
                </button></div>    
                <input type="file" id="myPicture" name="file">
            </div>
            
            <br>
            <!-- <button type="submit" class="picture_submit">미디어 추가</button> -->
        
                
            <div class="picture_container"></div>
                    
            <input class="form-control" name="email" type="hidden" value="${member.email}">
           
           <div class="form-group has-feedback">
               <label class="control-label" for="nickname">닉네임</label>
               <br>
               <input class="form-control" type="nickname" id="nickname" 
                      name="nickname" value="${__PROFILE__.nickname}"
                      placeholder="상대방에게 보여줄 닉네임을 정해주세요." />
           </div>
           <div class="form-group has-feedback">
          
               <label class="control-label" for="age">나이</label>
               <br>
               <input class="form-control" type="number" min=0 id="age" 
                      name="age" value="${__PROFILE__.age}" placeholder="age" />
                      <span id="chkNotice"></span>
           </div>
           
   			<div class="form-group has-feedback">
   			<label class="control-label" for="gender">성별</label><br>
               <select name="gender" class="form-control" id="gender">
                   <option value="M">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;M</option>
                   <option value="W">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;W</option>
               </select>
           </div>
           
           <div class="form-group has-feedback">
                        <label class="control-label" for="zone">지역</label>
                        <br>
                        <select name="zone" class="form-control" id="zone">
                            <option value="서울">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서울</option>
                            <option value="춘천">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;인천</option>
                            <option value="대전">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;대전</option>
                            <option value="세종">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;세종</option>
                            <option value="원주">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;원주</option>
                            <option value="광주">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;광주</option>
                            <option value="대구">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;대구</option>
                            <option value="울산">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;울산</option>
                            <option value="부산">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;부산</option>
                            <option value="경기도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;경기도</option>
                            <option value="강원도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;강원도</option>
                            <option value="충청북도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;충청북도</option>
                            <option value="충청남도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;충청남도</option>
                            <option value="전라북도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전라북도</option>
                            <option value="전라남도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전라남도</option>
                            <option value="경상북도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;경상북도</option>
                            <option value="경상남도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;경상남도</option>
                            <option value="제주도">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제주도</option>
                        </select>
                    </div>
                 
           
           <div class="login_id">
               <label class="control-label" for="introduce">Hobby</label>
               <br>
               <select name="hobby1" class="form-control">

                   <option value="">없음
                   <option value="운동">운동
                   <option value="요리">요리
                   <option value="독서">독서
                   <option value="코딩">코딩
                   <option value="그림">그림
                   <option value="여행">여행
                   <option value="공예">공예
                   <option value="영화">영화
                   <option value="드라마">드라마
                   <option value="애니">애니
               
               </select>
          
          
               <select name="hobby2" class="form-control">
                   
                   <option value="">없음
                   <option value="운동">운동
                   <option value="요리">요리
                   <option value="독서">독서
                   <option value="코딩">코딩
                   <option value="그림">그림
                   <option value="여행">여행
                   <option value="공예">공예
                   <option value="영화">영화
                   <option value="드라마">드라마
                   <option value="애니">애니
               
               </select>

          
               <select name="hobby3" class="form-control">
                   
                   <option value="">없음
                   <option value="운동">운동
                   <option value="요리">요리
                   <option value="독서">독서
                   <option value="코딩">코딩
                   <option value="그림">그림
                   <option value="여행">여행
                   <option value="공예">공예
                   <option value="영화">영화
                   <option value="드라마">드라마
                   <option value="애니">애니
               
               </select>
           </div>
           
           <div class="form-group has-feedback">
               <label class="control-label" for="introduce">Self-Introduction</label>
               <br>
               <textarea class="form-control" type="content" 
               rows="10" id="introduce" name="introduce" value="${__PROFILE__.introduce}"
               placeholder="자기소개를 작성해주세요."></textarea>
               <div id=text_cnt>(0/500)</div>
           </div>

           <div class="form-group has-feedback">
               <button class="submit" type="submit" id="submit">Profile submit</button>
           </div>
       </form>
       	</section>
       <form action="/profile/info" method="get">
        <div class="form-group has-feedback">
       	<input type="hidden" name="email" value="${member.email}">
		<input type="submit" id="back" value="back">
		</div>
 	</form>
        </div>
       

</body>

</html>
