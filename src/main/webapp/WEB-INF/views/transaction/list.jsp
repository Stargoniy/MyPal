<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
    </head>
    <body>

        <ul class="nav nav-tabs">
            <li><a href="/registration">Home</a></li>
            <li><a href="/transaction/create">Create transaction</a></li>
            <li class="active"><a href="">Transactions</a></li>
            <li><a href="/logout">Log out</a></li>
        </ul>

        <table class="table table-striped">

            <tr>
                <th>ID</th>
                <th>Debit account</th>
                <th>Credit account</th>
                <th>Sum</th>
            </tr>

            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td>${transaction.id}</td>
                    <td>${transaction.credit.email}</td>
                    <td>${transaction.debit.email}</td>
                    <td>${transaction.sum}</td>
                </tr>
            </c:forEach>

        </table>

    </body>
</html>
