<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<s:form action="/user/registration" method="post" modelAttribute="newUser">
    <div class="form-floating mb-3">
        <s:input type="text" path="name" class="form-control" id="floatingInputGroup1" placeholder="name"/>
        <s:errors path="name"/>
        <label for="floatingInputGroup1">Name</label>
    </div>
    <div class="form-floating mb-3">
        <s:input type="text" path="username" class="form-control" id="floatingInputGroup2" placeholder="Username"/>
        <s:errors path="username"/>
        <label for="floatingInputGroup2">Username</label>
    </div>
    <div class="form-floating">
        <s:input type="password" path="password" class="form-control" id="floatingPassword" placeholder="Password"/>
        <s:errors path="password"/>
        <label for="floatingPassword">Password</label>
    </div>
    <button type="submit" class="btn btn-primary w-100">Submit</button>
</s:form>
</body>
</html>
