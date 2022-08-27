<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser.name}</b></p>
<c:if test="${! empty operations}">
    <c:forEach items="${operations}" var="operation">
        <li class="list-group-item">${operation}</li>
    </c:forEach>
</c:if>

<c:if test="${empty operations}">
    There are no operations of this user
</c:if>
</body>
</html>
