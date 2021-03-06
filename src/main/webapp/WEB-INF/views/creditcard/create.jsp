<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add credit card</title>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
    <%--<c:if test="${validateCardInfo != null }">
        <c:forEach var="transaction" items="${validateCardInfo}">
            <tr>
                <td>${transaction}</td>

            </tr>
        </c:forEach>

    </c:if>--%>

    <legend>
        <span><c:out value = "${sess.email}" /></span>
        <span style="float: right"><a href="/logout">Log out</a></span>
    </legend>

    <ul class="nav nav-tabs">
        <li class="active"><a href="/transaction/create/creditfromcard">Pay</a></li>
        <li><a href="/transaction/create/debitedtothecard">Cash-out</a></li>
        <li><a href="/transaction/create">Send money</a></li>
        <li><a href="/transaction/history">History</a></li>
        <li style="float: right">Balance: <c:out value = "${balance}" />$</li>
    </ul>

    <form class="form-horizontal" method="post" action="/transaction/create/creditfromcard">
        <div class="control-group">
            <label class="control-label" for="card_number">
                <p <c:if test = "${fn:contains(validateCardInfo,'cardNumber')}"> class="text-error"</c:if>>
                    Card number
                </p>
            </label>
            <div class="controls">
                <input type="text" id="card_number" name = "card_number" placeholder="Card number">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="expiry_date">Expiry date YY/MM</label>
            <div class="controls">
                <input type="text" id="expiry_date" name = "expiry_date" placeholder="Year">
                <p></p>
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
            <label class="control-label" for="name_on_card">
                <p <c:if test = "${fn:contains(validateCardInfo,'cardName')}"> class="text-error"</c:if>>
                    Name on card
                </p>
            </label>
            <div class="controls">
                <input type="text" id="name_on_card" name="name_on_card" placeholder="Name on card">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="sumid">
                <p <c:if test = "${fn:contains(validateCardInfo,'sum')}"> class="text-error"</c:if>>
                    Sum
                </p>
            </label>
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