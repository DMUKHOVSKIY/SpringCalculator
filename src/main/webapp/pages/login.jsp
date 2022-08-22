<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<s:form action="/user/login" method="post" modelAttribute="userModel">
    <div class="form-floating mb-3">
        <s:input type="text" path="username" class="form-control" id="floatingInputGroup1" placeholder="Username"/>
        <s:errors path="username"/>
        <label for="floatingInputGroup1">Username</label>
    </div>
    <div class="form-floating mb-3">
        <s:input type="password" path="password" class="form-control" id="floatingInputGroup2" placeholder="Password"/>
        <s:errors path="password"/>
        <label for="floatingInputGroup1">Password</label>
    </div>
    <button type="submit" class="btn btn-primary w-100">Submit</button>
</s:form>
<form>
    <p>${message}</p>
</form>
</body>
</html>
