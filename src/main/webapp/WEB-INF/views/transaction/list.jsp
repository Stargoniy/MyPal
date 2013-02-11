<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
</head>
<body>
<div>
    <form method="post" action="/transactions" class="form-inline">
        <fieldset>
            <ul class="nav nav-tabs">
                <li class="active"><a href="/transactions" data-toggle="tab">Transactions</a></li>
            </ul>
            <label>Debet account:</label>
            <select name="debet_id">
                <c:forEach var="account" items="${accounts}">
                    <option value="<c:out value="${account.id}"/>"><c:out value="${account.name}"/> (<c:out
                            value="${account.user.name}"/>)
                    </option>
                </c:forEach>
            </select>
            <label>Credit account:</label>
            <select name="credit_id">
                <c:forEach var="account" items="${accounts}">
                    <option value="<c:out value="${account.id}"/>"><c:out value="${account.name}"/> (<c:out
                            value="${account.user.name}"/>)
                    </option>
                </c:forEach>
            </select>
            <input name="sum" type="text" class="input-medium" placeholder="Sum">
            <button type="submit" class="btn btn-primary">Create</button>
        </fieldset>
    </form>
</div>

<table class="table table-striped table-bordered">
    <tr>
        <th>ID</th>
        <th>Debet account</th>
        <th>Credit account</th>
        <th>Sum</th>
    </tr>
    <c:forEach var="transaction" items="${transactions}">
        <tr>
            <td><c:out value="${transaction.id}"/></td>
            <td><c:out value="${transaction.debetAccount.name}"/> (<c:out
                    value="${transaction.debetAccount.user.name}"/>)
            </td>
            <td><c:out value="${transaction.creditAccount.name}"/> (<c:out
                    value="${transaction.creditAccount.user.name}"/>)
            </td>
            <td><c:out value="${transaction.sum}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>