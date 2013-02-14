<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title></title>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>

    <c:if test="${validateCardInfo != null }">
        <c:forEach var="transaction" items="${validateCardInfo}">
            <tr>
                <td>${transaction}</td>

            </tr>
        </c:forEach>
    </c:if>

    <legend>
        <span><c:out value="${sess.email}" /></span>
        <span style="float: right"><a href="/logout">Log out</a></span>
    </legend>

    <ul class="nav nav-tabs">
        <li><a href="/transaction/create/creditfromcard">Pay</a></li>
        <li class="active"><a href="/transaction/create/debitedtothecard">Cash-out</a></li>
        <li><a href="/transaction/create">Send money</a></li>
        <li><a href="/transaction/history">History</a></li>
        <li style="float: right">Balance: <c:out value="${balance}" />$</li>
    </ul>

    <form class="form-horizontal" method="post" action="/transaction/create/debitedtothecard">
        <div class="control-group">
            <label class="control-label" for="card_number">Card number</label>
            <div class="controls">
                <input type="text" id="card_number" name = "card_number" placeholder="Card number">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="sumid">Sum</label>
            <div class="controls">
                <input type="text" id="sumid" name="sum" placeholder="Sum">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn">Send money</button>
            </div>
        </div>
    </form>
</body>
</html>