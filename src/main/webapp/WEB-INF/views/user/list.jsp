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
        <th><h4>ID</h4></th>
        <th><h4>User first name</h4></th>
        <th><h4>User last name</h4></th>
        <th><h4>Email</h4></th>
        <th><h4>Is Active</h4></th>
        <th><h4>ACTIONS</h4></th>
    </tr>
    <c:forEach var="user" items="${userlist}">
        <c:if test="${user.id > 0}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.active}"/></td>
            <c:if test="${user.active == true}">
                <td><a href="/user/ban/<c:out value="${user.id}"/>"><button class="btn-warning">Ban</button></a></td>
            </c:if>
            <c:if test="${user.active == false}">
                <td><a href="/user/unban/<c:out value="${user.id}"/>"><button class="btn-inverse">UnBan</button></a></td>
            </c:if>
                <td><a href="users/<c:out value="${user.id}"/>/transactions"><button class="btn">Transactions</button></a></td>

        </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>