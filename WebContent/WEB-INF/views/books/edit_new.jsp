<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>書籍マスタ-新規登録</title>
</head>
<body>
<div>書籍情報<br /></div>
<div>${message}</div>
<div>
<form action="/book-master/books/create" method="post">
<table border="1">
  <tr>
    <th>項目</th><th>情報</th>
  </tr>
  <tr>
    <td>ID</td>
    <td><input type="text" name="id" value="${book.id}"></td>
  </tr>
  <tr>
    <td>書籍コード</td>
    <td><input type="text" name="bookCode" value="${book.bookCode}"></td>
  </tr>
  <tr>
    <td>名称</td>
    <td><input type="text" name="name" value="${book.name}"></td>
  </tr>
  <tr>
    <td>名称２</td>
    <td><input type="text" name="name2" value="${book.name2}"></td>
  </tr>
  <tr>
    <td>名称かな</td>
    <td><input type="text" name="kanaName" value="${book.kanaName}"></td>
  </tr>
  <tr>
    <td>著者名</td>
    <td><input type="text" name="authorName" value="${book.authorName}"></td>
  </tr>
  <tr>
    <td>発行所</td>
    <td><input type="text" name="publisher" value="${book.publisher}"></td>
  </tr>
  <tr>
    <td>版型</td>
    <td><input type="text" name="paperSize" value="${book.paperSize}"></td>
  </tr>
  <tr>
    <td>シリーズ</td>
    <td><input type="text" name="series" value="${book.series}"></td>
  </tr>
  <tr>
    <td>巻数本フラグ</td>
    <td><input type="text" name="isPartFlg" value="${book.isPartFlg}"></td>
  </tr>
  <tr>
    <td>巻数</td>
    <td><input type="text" name="number" value="${book.number}"></td>
  </tr>
  <tr>
    <td>総巻数</td>
    <td><input type="text" name="totalVolume" value="${book.totalVolume}"></td>
  </tr>
  <tr>
    <td>発行年</td>
    <td><input type="text" name="publishYear" value="${book.publishYear}"></td>
  </tr>
  <tr>
    <td>版表示</td>
    <td><input type="text" name="editionDisp" value="${book.editionDisp}"></td>
  </tr>
  <tr>
    <td>版情報</td>
    <td><input type="text" name="editionInfo" value="${book.editionInfo}"></td>
  </tr>
  <tr>
    <td>ISBN</td>
    <td><input type="text" name="isbn" value="${book.isbn}"></td>
  </tr>
  <tr>
    <td>ページ数</td>
    <td><input type="text" name="pages" value="${book.pages}"></td>
  </tr>
  <tr>
    <td>縦(mm)</td>
    <td><input type="text" name="height" value="${book.height}"></td>
  </tr>
  <tr>
    <td>横(mm)</td>
    <td><input type="text" name="width" value="${book.width}"></td>
  </tr>
  <tr>
    <td>幅(mm)</td>
    <td><input type="text" name="depth" value="${book.depth}"></td>
  </tr>
  <tr>
    <td>重量(g)</td>
    <td><input type="text" name="weight" value="${book.weight}"></td>
  </tr>
</table>
  <input type="submit" value="登録">
</form>
</div>
<div>
<a href="/book-master/books/select">一覧へ</a>
</div>
</body>
</html>