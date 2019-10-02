<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>가입 완료</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<br><br><div
		style="border-width: 2px; border-style: solid; border-color: gray; width: 30%; margin: 0 auto; padding: 20px; text-align: center">

		<span
			style="font-weight: bold; font-size: 1.5em; line-height: 1.0em; color: gray; font-family: arial;"><br>
		<br>${param.name}님, 회원 가입에 성공했습니다. </span> <br>
		<br><button type="button" class="btn btn-outline-secondary"
			onclick="location.href='index.jsp'">초기화면</button>

	</div>
</body>
</html>