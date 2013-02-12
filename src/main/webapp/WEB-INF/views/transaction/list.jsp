<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
    </head>
    <body>

        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Debit account</th>
                <th>Credit account</th>
                <th>Sum</th>
            </tr>
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td><c:out value="${transaction[0]}"/></td>
                    <td><c:out value="${transaction[1]}"/> (<c:out value="${transaction[2]}"/>)
                    </td>
                    <td><c:out value="${transaction[3]}"/> <%--(<c:out value="${transaction[4]}"/>)--%>
                    </td>
                    <%--<td><c:out value="${transaction[5]}"/></td>--%>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>