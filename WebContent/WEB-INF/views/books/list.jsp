<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>書籍マスタ</title>
</head>
<body>
<p>
<a href="/book-master/books/edit_new">新規登録</a>
<a href="/book-master/books/edit_upload">アップロード</a>
<a href="/book-master/books/sch_download">ダウンロード</a>
</p>
<div id="conditionArea">
<form action="/book-master/books/search" method="post">
<table border="1">
  <tr>
    <th>名称</th>
    <td><input type="text" name="name" value="${conditionForm.name[0]}"></td>
  </tr>
  <tr>
    <th>名称かな</th>
    <td><input type="text" name="kanaName" value="${conditionForm.kanaName[0]}"></td>
  </tr>
  <tr>
    <th>著者名</th>
    <td><input type="text" name="authorName" value="${conditionForm.authorName[0]}"></td>
  </tr>
  <tr>
    <th>発行所</th>
    <td><input type="text" name="publisher" value="${conditionForm.publisher[0]}"></td>
  </tr>
  <tr>
    <th>ISBN</th>
    <td><input type="text" name="isbn" value="${conditionForm.isbn[0]}"></td>
  </tr>
</table>
<input type="submit" value="検索">
</form>
</div>
<br />
<table border="1">
<c:forEach var="book" items="${bookList}" varStatus="status">
  <tr>
    <td><a href="/book-master/books/select/${book.id}">${book.id}</a></td>
    <td>${book.bookCode}</td>
    <td>${book.name}</td>
    <td>${book.name2}</td>
    <td>${book.kanaName}</td>
    <td>${book.authorName}</td>
    <td>${book.publisher}</td>
    <td>${book.paperSize}</td>
    <td>${book.series}</td>
    <td>${book.isPartFlg}</td>
    <td>${book.number}</td>
    <td>${book.totalVolume}</td>
    <td>${book.publishYear}</td>
    <td>${book.editionDisp}</td>
    <td>${book.editionInfo}</td>
    <td>${book.isbn}</td>
    <td>${book.pages}</td>
    <td>${book.height}</td>
    <td>${book.width}</td>
    <td>${book.depth}</td>
    <td>${book.weight}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>