<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<%
  String no = request.getParameter("articleno");
  String title = request.getParameter("articletitle");
  String content = request.getParameter("articlecontent");
%> 

<head>
   <meta charset="UTF-8">
   <title>글보기</title>
   <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   
</head>
<body>
<div style="border-width: 2px; border-style: solid; border-color: gray; width: 40%; margin: 0 auto; padding: 20px; text-align: center">
  <form name="frmEdit" method="post"  action="../articleedit.do" >
 
 <table  border=0  align="center">
  <tr>
    <h1>게시글 편집</h1>
   <td width=150 align="right">
      번호 
   </td>
   <td >
    <input type="text"  value="<%=no %>"  disabled />
      <input type="hidden" name="article_no" value="<%=no %>"/>
</td>
  </tr>
 
  <tr>
   <td width=150 align="right">
    제목
   </td>
   <td >
    <input type="text" value="<%=title %>"  name="title"  id="i_title"  />

</td>
  </tr>
  
  <tr>
   <td width=150 align="right">
    내용
   </td>
   <td >
    <textarea rows="20" cols="60"  name="content"  id="i_content"   /><%=content %></textarea>
</td>
  </tr>

 </table>
 <br><button class="btn btn-default" type="submit"  align="right" >글 수정</button>
 </form>
</body>
</html>