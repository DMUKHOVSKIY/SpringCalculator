<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Number</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser.name}</b></p>
<form action="/account/changeNumber" method="post">
    <input type="text" name="oldNumber" class="form-control" placeholder="Enter the Old Number" required/>
    <br>
    <input type="text" name="newNumber" class="form-control" placeholder="Enter the New Number" required/>
    <br>
    <button>Submit</button>
</form>
<p>${changeNumber}</p>
</body>
</html>
