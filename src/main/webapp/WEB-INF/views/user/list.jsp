<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>

    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>
<a href="/admin/page">Back to admin pannel</a>
<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>User first name</th>
        <th>User last name</th>
        <th>Email</th>
        <th>Is Active</th>
        <th>ACTIONS</th>
    </tr>
    <c:forEach var="user" items="${userlist}">
        <c:if test="${user.id > 0}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.active}"/></td>
            <td style="width: 200px">
            <c:if test="${user.active == true}">
                <a href="/user/ban/<c:out value="${user.id}"/>" class="btn-warning">Ban</a>
            </c:if>
            <c:if test="${user.active == false}">
                <a href="/user/unban/<c:out value="${user.id}"/>" class="btn-inverse">UnBan</a>
            </c:if>
                <a href="users/<c:out value="${user.id}"/>/transactions" class="btn">Transactions</a>
             </td>
        </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>