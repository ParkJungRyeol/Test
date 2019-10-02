<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 삭제 창</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
 <c:if test="${invalidPassword != true}">
 	메시지를 삭제하였습니다.
 </c:if>
 <c:if test="${invalidPassword == true}">
 	입력한 암호가 올바르지 않습니다. 암호를 확인해주세요.
 </c:if>
 <br/>
 <a href = "list.do">[목록 보기]</a>
</body>
</html>