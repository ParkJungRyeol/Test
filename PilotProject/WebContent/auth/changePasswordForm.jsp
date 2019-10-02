<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<br><br><div style="border-width: 2px; border-style: solid; border-color: gray; width: 30%; margin: 0 auto; padding: 20px; text-align: center">
	<form action="changePwd.do" method="post">
		<c:if test="${errors.notcompare}">현재 암호랑 새 암호랑 같습니다.</c:if>
		<p>
		현재암호: <input type="password" name="curPwd"/>
		<c:if test="${errors.curPwd}">현재 암호를 입력하세요.</c:if>
		<c:if test="${errors.notgoodCurPwd}">현재 암호가 일치하지 않습니다.</c:if>
		</p>
		<p>
			새 암호: <input type="password" name="newPwd"/>
			<c:if test="${errors.newPwd}">새 암호를 입력하세요.</c:if>
		</p>

	<br><br><button class="btn btn-default" type="submit" >암호 변경</button>
		
	</form>
</body>
</html>


