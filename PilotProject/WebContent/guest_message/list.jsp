<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guest_message.service.MessageListView"%>
<%@ page import="guest_message.model.Guest_message"%>
<%@ page import="guest_message.service.GetMessageListService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>방명록 메시지 목록</title>
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<br><br><div style="border-width:2px; border-style:solid; border-color:gray; width:30%; margin:0 auto; padding:30px; text-align:center">
<form action="write.do" method="post">
<p>
	이름<br><input type="text" name="guest_name" value="${param.guest_name }"> 
	<c:if test="${errors.guest_name }">이름을 입력해주세요.</c:if>
</p>
<p>	
	암호<br><input type="password" name="password"> 
	<c:if test="${errors.password }">암호를 입력해주세요.</c:if>
</p>
<p>	
	메시지 <br><textarea name="message" cols="22" rows="4"></textarea>
	<c:if test="${errors.message }">메세지를 입력해주세요.</c:if> 
</p>	
 <br><button class="btn btn-default" type="submit" >메시지 남기기</button>
	
</form>
<hr>
<c:if test="${viewData.isEmpty()}">
등록된 메시지가 없습니다.
 </c:if> 

<c:if test="${!viewData.isEmpty()}">
<table border="2">
	<c:forEach var="message" items="${viewData.messageList}">
		<tr>
			<td>
			메시지 번호 : ${message.message_id} <br/>
			손님 이름 : ${message.guest_name} <br/>
			메시지 : ${message.message} <br/>
			<button type="button" class="btn btn-link btn-sm" onclick="location.href='delete.do?messageId=${message.message_id}'">삭제하기</button>


			</td>
		</tr>
	</c:forEach>
</table>


<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">
	<a href="list.do?page=${pageNum}">[${pageNum}]</a> 
</c:forEach>

</c:if><br>
<button type="button" class="btn btn-outline-secondary"
			onclick="location.href='index.jsp'">초기화면</button>
</body>
</html>