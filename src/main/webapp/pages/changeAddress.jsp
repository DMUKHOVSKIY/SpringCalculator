<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser.name}</b></p>
<form action="/account/changeAddress" method="post">
    <input type="text" name="newCity" class="form-control" placeholder="New City" required/>
    <br>
    <input type="text" name="newStreet" class="form-control" placeholder="New Street" required/>
    <br>
    <button>Submit</button>
</form>
</body>
</html>
