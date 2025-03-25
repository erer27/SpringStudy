<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${bCheck==true }">
	<c:redirect url="detail.do?no=${no }"/>
</c:if>
<c:if test="${bCheck==true }">
	<script>
		alert("비밀번호가 틀립니다");
		history.back()
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>