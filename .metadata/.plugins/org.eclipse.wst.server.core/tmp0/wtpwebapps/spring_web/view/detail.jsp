<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글세부보기</h3>
	<ul>
		<li>${board.seq }</li>
		<li>${board.title }</li>
		<li>${board.writer }</li>		
		<li><a href="board_download?filename=${board.fname }">${board.fname }</a></li>
		<li>${board.contents }</li>
	</ul><br>	
	
	<a href="updateFormAction.do?seq=${board.seq }">글수정</a>
	<a href="delete.jsp?seq=${board.seq }">글삭제</a>
	
</body>
</html>







