<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
  <title>글목록창</title>
  <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<br><br><div style="border-width:2px; border-style:solid; border-color:gray; width:50%; margin:0 auto; padding:50px; text-align:center">
<table border="2" width ="100%"  >
  <tr height="10" >
   <h1>게시글 목록</h1>
     <td >번호</td>
     <td >제목</td>
     <td >작성자</td>              
     <td >조회수</td>
     </tr>
 
 
 <c:choose>
  <c:when test="${artList == null }" >
    <tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
  </c:when>
  
  <c:when test="${artList != null }" >
    <c:forEach  var="article" items="${artList }" >
     <tr align="center">
	<td width="14%">${article.article_no }</td>
		<td width="57%"><a href="articlecontent.do?articleno=${article.article_no }">${article.title }</a></td>
	<td width="20%">${article.writer_name }</td>
		<td width="32%">${article.read_cnt }</td>
	    </tr>
    </c:forEach>
     </c:when>
    </c:choose>
    
    
</table>
<jsp:include page="/article/paging.jsp">
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>

<br><br>
<button type="button" class="btn btn-default float-right" onclick="location.href ='article/articleAdd.jsp'">글쓰기</button><br>
<button type="button" class="btn btn-outline-secondary"
			onclick="location.href='index.jsp'">초기화면</button>
 
 </div>
</body>
</html>


