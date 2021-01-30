<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
window.onload = function(){
	
}
function enterText(){
	var type = event.type;
	console.log("type ::: " ,type);
	switch(type){
		case 'Enter' : 
			//loginForm.submit();		
			break;	
	}
	
}
</script>
<title>로그인</title>
<style>
   form{
       text-align: center;
       margin:0 auto;
   }
   .border{
       margin:0 auto;
       width:400px;
       height:500px;
       border:1px solid #000;
       border-radius: 10%;
   }
   img{
       margin-top:20px;
       margin-bottom:80px;
   }
   input{
       width:300px;
   }
</style>
</head>
<body>
    <form id="loginForm" action ="/login/loginCheck" method="POST">
        <div class="border">
            <h1>로그인</h1>
                        
            <input type="text"     name="userId" id="USER_ID" placeholder="아이디를 입력해주세요."   onchange="enterText()"><br>
            <input type="password" name="userPw" id="PWD" 	  placeholder="비밀번호를 입력해주세요." onchange="enterText()"><br><br>
            <input type="submit"   id="btn_login" value="로그인">   
            <!-- 이게 왜 무조건 있어야 하지??? 와 진짜 개식겁함 ㅠㅜ-->         
            <input type="hidden"   name="${_csrf.parameterName}" value="${_csrf.token}" />
        	
        	<h4><c:out value="${msg}" /></h4>
        	<a href="/login/join">회원가입</a>
        </div> 
    </form>
    
    
</body>
</html>