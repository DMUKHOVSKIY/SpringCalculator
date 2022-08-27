<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser.name}</b></p>
<form action="/account/deleteNumber" method="post">
    <input type="text" name="number" class="form-control" placeholder="Enter the Number" required/>
    <br>
    <button>Submit</button>
</form>
<p>${deleteNumber}</p>
</body>
</html>
