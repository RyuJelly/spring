<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/product/register" method="post">
		<input type="hidden" name="user_id">1 <%-- <c:out value="${user_id }"/> --%>
		<!-- <input type="hidden" name="category_id">1 -->
		<div>
			<label>PRODUCT_NAME</label>
			<input name="product_name">
		</div>
		<div>
			<label>TITLE</label>
			<input name="title">
		</div>
		<div>
			<label>PRODUCT_INFO</label>
			<textarea rows="10"></textarea>
		</div>
		<div>
			<label>PRICE</label>
			<input name="price">
		</div>
		<button type="submit">작성</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>