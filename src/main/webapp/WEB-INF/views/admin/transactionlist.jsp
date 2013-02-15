<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
</head>
<body>
<a href="/admin/page">Back to admin pannel</a>
<table class="table table-striped">

    <tr>
        <th>ID</th>
        <th>Debit account</th>
        <th>Credit account</th>
        <th>Sum</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach var="transaction" items="${transactions}">
        <tr>
            <td>${transaction.id}</td>
            <td>${transaction.credit.email}</td>
            <td>${transaction.debit.email}</td>
            <td>${transaction.sum}</td>
            <td>${transaction.status}</td>
            <c:if test="${transaction.id > 0}">
                <c:if test="${transaction.status == true}">
                    <td>
                        <a href="/transaction/<c:out value="${transaction.id}"/>/cancel">
                            <button class="btn-inverse">Cancel</button>
                        </a>
                    </td>
                </c:if>
                <c:if test="${transaction.status == false}">
                    <td>
                        <a href="/transaction/<c:out value="${transaction.id}"/>/restore">
                            <button class="btn-warning">Restore</button>
                        </a>
                    </td>
                </c:if>
            </c:if>
        </tr>
    </c:forEach>

</table>

</body>
</html>
