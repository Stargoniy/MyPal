<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add credit card</title>
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

    <ul class="nav nav-tabs">
        <li class="active">
            <a href="http://localhost:8080/transaction/create/creditfromcard">From card</a>
        </li>
        <li><a href="http://localhost:8080/transaction/create/debitedtothecard">To the card</a></li>
    </ul>

    <form class="form-horizontal" method="post" action="/transaction/create/creditfromcard">
        <div class="control-group">
            <label class="control-label" for="card_number">Card number</label>
            <div class="controls">
                <input type="text" id="card_number" name = "card_number" placeholder="Card number">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="expiry_date">Expiry date</label>
            <div class="controls">
                <input type="text" id="expiry_date" name = "expiry_date" placeholder="Year">
                <input type="text" id="expiry_date_month" name = "expiry_date_month" placeholder="Month">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="cvv">CVV</label>
            <div class="controls">
                <input type="text" id="cvv" name = "cvv" placeholder="CVV">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="name_on_card">Name on card</label>
            <div class="controls">
                <input type="text" id="name_on_card" name="name_on_card" placeholder="Name on card">
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
                <button type="submit" class="btn">Get money</button>
            </div>
        </div>
    </form>
</body>
</html>