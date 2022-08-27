<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser.name}</b></p>
<form action="/account/addNumber" method="post">
    <input type="text" name="newNumber" class="form-control" placeholder="New Number" required/>
    <br>
    <button>Submit</button>
</form>

</body>
</html>
