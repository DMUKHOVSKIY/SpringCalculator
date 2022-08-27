<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<s:form action="/user/reg" method="post" modelAttribute="newUser">
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
    <div class="form-floating mb-3">
        <s:input type="password" path="password" class="form-control" id="floatingPassword" placeholder="Password"/>
        <s:errors path="password"/>
        <label for="floatingPassword">Password</label>
    </div>
    <div class="form-floating mb-3">
        <s:input type="text" path="city" class="form-control" id="floatingInputGroup3" placeholder="City"/>
        <s:errors path="city"/>
        <label for="floatingInputGroup3">City</label>
    </div>
    <div class="form-floating mb-3">
        <s:input type="text" path="street" class="form-control" id="floatingInputGroup4" placeholder="Street"/>
        <s:errors path="street"/>
        <label for="floatingInputGroup4">Street</label>
    </div>
    <div class="form-floating mb-3">
        <s:input type="text" path="numberA1" class="form-control" id="floatingInputGroup5" placeholder="NumberA1"/>
        <s:errors path="numberA1"/>
        <label for="floatingInputGroup5">NumberA1</label>
    </div>
    <div class="form-floating mb-3">
        <s:input type="text" path="numberMTC" class="form-control" id="floatingInputGroup6" placeholder="NumberMTC"/>
        <s:errors path="numberMTC"/>
        <label for="floatingInputGroup6">NumberMTC</label>
    </div>
    <div class="form-floating mb-3">
        <s:input type="text" path="numberLife" class="form-control" id="floatingInputGroup7" placeholder="NumberLife"/>
        <s:errors path="numberLife"/>
        <label for="floatingInputGroup7">NumberLife</label>
    </div>
    <button type="submit" class="btn btn-primary w-100">Submit</button>
</s:form>
<form>
    <c:if test="${isExist}">User with this username is already exist</c:if>
</form>
</body>
</html>
