<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 삭제 확인</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<br><br><div style="border-width:2px; border-style:solid; border-color:gray; width:30%; margin:0 auto; padding:20px; text-align:center">
	<form action="delete.do" method="post">
	<input type="hidden" name="messageId" value="${param.messageId}">
	메시지를 삭제하시려면 암호를 입력하세요 : <br>
	암호 : <input type="password" name="password"> <br>
	<input type="submit" value="메시지 삭제하기">
	</form>
</body>
</html>