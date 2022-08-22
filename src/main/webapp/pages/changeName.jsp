<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser}</b></p>
<form action="/user/changeName" method="post">
    <input type="text" name="name" placeholder="Name">
    <br>
    <button>Submit</button>
</form>
</body>
</html>
