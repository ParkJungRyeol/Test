<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<title>글쓰기창</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">


</head>
<body>
	<br>
	<br>
	<div
		style="border-width: 2px; border-style: solid; border-color: gray; width: 50%; margin: 0 auto; padding: 20px; text-align: center">

		<span
			style="font-weight: bold; font-size: 2.0em; line-height: 1.0em; color: gray;">
			게시글 등록 </span>
		<form action="../articleadd.do" method="post">
			<p>
				<br>제목<br>
				<input type="text" size="62" maxlength="500" name="title">
				<c:if test="${errors.password }">제목을 입력해주세요.</c:if>
			</p>
			<p>
				내용<br>
				<textarea name="content" rows="10" cols="65" maxlength="4000"></textarea>
				<c:if test="${errors.message }">내용을 입력해주세요.</c:if>
			</p>
			<br>
			<button class="btn btn-default" type="submit">글쓰기</button>
		</form>
		</tr>
		</table>
		</form>
</body>
</html>