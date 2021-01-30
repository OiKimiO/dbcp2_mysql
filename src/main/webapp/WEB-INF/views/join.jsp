<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<form action="/login/joinMember" method="post">
		<div>
			아이디 :   <input type="text" name="userId" />
		</div>
		<div>
			비밀번호 : <input type="password" name="userPw" />
		</div>
		<div>
			이름 : <input type="text" name="userName" />
		</div>
		
		<input type="hidden"   name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="회원가입">
	</form>
</body>
</html>