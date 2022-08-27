<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TelOperations</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser.name}</b></p>
<div class="d-grid gap-2 col-6 mx-auto">
    <a href="/account/addNewNumber" class="btn btn-primary" role="button">Add new Number</a>
    <a href="/account/changeNumber" class="btn btn-primary" role="button">Change Number</a>
    <a href="/account/deleteNumber" class="btn btn-primary" role="button">Delete Number</a>
</div>
</body>
</html>
