<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="../../../css/bootstrap.css" />
    </head>
    <body>

        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Debet account</th>
                <th>Credit account</th>
                <th>Sum</th>
            </tr>
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td>${transaction.id}"</td>
                    <%--<td><c:out value="${transaction.debit}"/> (<c:out
                            value="${transaction.credit}"/>)
                    </td>
                    <td><c:out value="${transaction.credit}"/> (<c:out
                            value="${transaction.debit}"/>)
                    </td>
                    <td><c:out value="${transaction.sum}"/></td>--%>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>