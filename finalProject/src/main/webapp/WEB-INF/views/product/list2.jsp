<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="border: 1px solid;">
		<tr>
			<th>제목</th>
			<th>판매물품</th>
			<th>가격</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="product">
			<tr>
				<td><c:out value="${product.title }" /></td>
				<td><c:out value="${product.product_name }" /></td>
				<td><c:out value="${product.price }" /></td>
				<td><fmt:formatDate pattern="yyyy-mm-dd" value="${product.create_date }"/></td>
			</tr>
		</c:forEach>
	</table>
	<button id="regi">글쓰기</button>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$('#regi').on('click', function(){
			self.location = "/product/register";
		});
	});
</script>
</html>