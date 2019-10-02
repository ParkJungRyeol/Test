<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<br><br><div
		style="border-width: 2px; border-style: solid; border-color: gray; width: 30%; margin: 0 auto; padding: 20px; text-align: center">
	<form action="login.do" method="post">
		<c:if test="${errors.idOrPwNotMatch}">
			아이디와 암호가 일치하지 않습니다.
		</c:if>
		<p>
			<br> 아이디  <br><input type="text"  name="id" value="${param.id}">
			<c:if test="${errors.id}">ID를 입력하세요.</c:if>
		</p>
		<p>
			비밀번호 <br><input type="password" name="password">
			<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
		</p>
		 <br><button class="btn btn-default" type="submit" >로그인</button>

	</form>
	</div>
</body>
</html>



