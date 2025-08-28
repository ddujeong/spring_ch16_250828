<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>${boardDto.bnum } 번 글 내용</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding ="0">
		<tr>
			<th>이 름</th>
			<td>${boardDto.bname }</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td>${boardDto.btitle }</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td>${boardDto.bcontent }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardDto.bhit }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${boardDto.bdate }</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="글 목록" onclick="javascript:window.location.href='boardList'">
			</td>
		</tr>
	</table>
</body>
</html>