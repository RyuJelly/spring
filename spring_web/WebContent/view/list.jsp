<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="board_insert">글쓰기</a>
	<table border="1">
		<tr>
			<td>글번호</td>			
			<td>글제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
		
		<c:forEach var="board" items="${list }">
		<tr>
			<td>${board.seq }</td>			
			<td><a href="board_detail${board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>
				<fmt:parseDate var="dt" value="${board.regdate }" pattern="yyyy-MM-dd HH:mm:ss" />
				<fmt:formatDate value="${dt }" pattern="yyyy/MM/dd"/>
			</td>
			<td>${board.hitcount }</td>
		</tr>			
		</c:forEach>
	</table>
	<br>
	
	
</body>
</html>















