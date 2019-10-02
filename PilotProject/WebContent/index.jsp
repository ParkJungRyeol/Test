<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원제 게시판 예제</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<br><br><div style="border-width:2px; border-style:solid; border-color:gray; width:30%; margin:0 auto; padding:20px; text-align:center">

		<c:if test="${!empty authUser}">

<span
style="
 font-weight: bold;  
font-size: 1.5em;
line-height: 1.0em;  
color: gray;
font-family: arial;
"><br><br>${authUser.name}님 안녕하세요
</span>
 
			
			<br><button type="button" class="btn btn-default btn-sm"
				onclick="location.href='logout.do'">로그아웃하기</button>
			<button type="button" class="btn btn-default btn-sm"
				onclick="location.href='changePwd.do'">암호 변경하기</button><br><br>
				
			
			<h2>
			<br><button type="button" class="btn btn-outline-secondary"
				onclick="location.href='list.do'">방명록</button>
			</h2>
			<h2>
			<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='articlelist.do'">게시판</button><br><br>
			</h2>
		</c:if>

		<c:if test="${empty authUser}">
		4조
			<br><br><button type="button" class="btn btn-outline-secondary"
				onclick="location.href='login.do'">로그인</button><br><br>
			<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='join.do'">회원가입</button><br><br>
			<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='list.do'">방명록</button><br><br>
			<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='articlelist.do'">게시판</button><br><br>
		</c:if>
		
		
		
	</div>
</body>
</html>

