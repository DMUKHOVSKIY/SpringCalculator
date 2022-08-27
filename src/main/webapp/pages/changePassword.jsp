<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<p><b>Name: ${currentUser.name}</b></p>
<s:form action="/account/changePassword" method="post" modelAttribute="passwordModel">
    <s:input type="text" path="oldPassword" class="form-control" id="floatingInputGroup" placeholder="Old Password"/>
    <s:errors path="oldPassword"/>
    <br>
    <s:input type="text" path="newPassword" class="form-control" id="floatingInputGroup" placeholder="New Password"/>
    <s:errors path="newPassword"/>
    <br>
    <button>Submit</button>
</s:form>
<p>${messagePassword}</p>
</body>
</html>
