<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser}</b></p>
<div class="d-grid gap-2 col-6 mx-auto">
    <a href="/calculator/history" class="btn btn-primary" role="button">History</a>
    <a href="/user/changeName" class="btn btn-primary" role="button">Change Name</a>
    <a href="/user/changePassword" class="btn btn-primary" role="button">Change Password</a>
    <a href="/user/deleteUser" class="btn btn-primary" role="button">Delete User</a>
    <a href="/user/deleteOperation" class="btn btn-primary" role="button">Delete Operations Of User</a>
</div>
</body>
</html>
