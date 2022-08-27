<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser.name}</b></p>
<div class="d-grid gap-2 col-6 mx-auto">
    <a href="/account/info" class="btn btn-primary" role="button">Information about User</a>
    <a href="/calculator/history" class="btn btn-primary" role="button">History</a>
    <a href="/account/changeName" class="btn btn-primary" role="button">Change Name</a>
    <a href="/account/changePassword" class="btn btn-primary" role="button">Change Password</a>
    <a href="/account/changeAddress" class="btn btn-primary" role="button">Change Address</a>
    <a href="/account/OperationsWithTelephone" class="btn btn-primary" role="button">Operations with Telephone</a>
    <a href="/account/deleteUser" class="btn btn-primary" role="button">Delete User</a>
    <a href="/account/deleteOperation" class="btn btn-primary" role="button">Delete Operations Of User</a>
</div>
</body>
</html>
