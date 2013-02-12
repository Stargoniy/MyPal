<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>

    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>

<table class="table table-bordered">
    <tr>
        <td><h4>ID</h4></td>
        <td><h4>User first name</h4></td>
        <td><h4>User last name</h4></td>
        <td><h4>Email</h4></td>
        <td><h4>Password</h4></td>
        <td><h4>ACTIONS</h4></td>
    </tr>
    <c:forEach var="user" items="${userlist}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><a href=""><button class="btn">Ban</button></a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>