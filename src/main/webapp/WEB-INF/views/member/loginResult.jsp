<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${requestScope.result == false }">
	<script>
		alert('로그인 실패 - ID 또는 PW를 재확인 해주세요');
	</script>
</c:if>

<script>
	location.replace("/");
</script>

</body>
</html>