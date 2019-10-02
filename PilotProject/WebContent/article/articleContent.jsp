<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<head>
   <meta charset="UTF-8">
   <title>글보기</title>
   <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div style="border-width: 2px; border-style: solid; border-color: gray; width: 40%; margin: 0 auto; padding: 20px; text-align: center">
  <form name="frmArticle" method="post"  action="${contextPath}"  enctype="multipart/form-data">
  <table  border=0  align="center">
  
  <tr>
  <h1>게시글 내용</h1>
   <td width=150 align="right">
      번호 
   </td>
   <td >
    <input type="text"  name ="articleno" value="${article.article_no }"  disabled />
</td>
  </tr>
  <tr>
    <td width="150" align="right">
      작성자 
   </td>
   <td >
    <input type=text value="${article.writer_name }" name="writer"  disabled />
   </td>
  </tr>
  <tr>
    <td width="150" align="right" >
      제목  
   </td>
   <td>
 <input type=text value="${article.title }"  name="title"  id="i_title" disabled />
   </td>   
  </tr>
  <tr>
    <td width="150" align="right" >
      내용 
   </td>
   <td>
    <br><textarea rows="10" cols="60"  name="content"  id="i_content"  disabled />${article.content }</textarea>
   </td>  
  </tr>
</table>
 <br><button class="btn btn-default" type="button" onclick="location.href='/PilotProject/article/articleEdit.jsp?articleno=${article.article_no }&articletitle=${article.title }&articlecontent=${article.content }'">게시글 수정</button>
<button class="btn btn-default" type="button" onClick="location.href = 'articledelete.do?articleno=${article.article_no }'">게시글 삭제</button>
<button class="btn btn-default" type="button" onClick="location.href = 'articlelist.do'">목록</button>
 </form>
</body>
</html>