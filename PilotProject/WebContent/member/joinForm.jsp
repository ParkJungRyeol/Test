<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>가입</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>

	<br>
	<br>
	<div
		style="border-width: 2px; border-style: solid; border-color: gray; width: 30%; margin: 0 auto; padding: 20px; text-align: center">
		<form action="join.do" method="post">
			<p>
				<br> 아이디 <br><input type="text"  name="id" value="${param.id}">
				<c:if test="${errors.id}">ID를 입력하세요.</c:if>
				<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
			</p>
			<p>
				이름 <br><input type="text" name="name" value="${param.name}">
				<c:if test="${errors.name}">이름을 입력하세요.</c:if>
			</p>
			<p>
				암호 <br><input type="password" name="password">
				<c:if test="${errors.password}">암호를 입력하세요.</c:if>
			</p>
			<p>
				확인 <br><input type="password" name="confirmPassword">
				<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
				<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
			</p>


			<br><button class="btn btn-default" type="submit" value="가입">가입</button>
	</div>

	</form>
</body>
</html>