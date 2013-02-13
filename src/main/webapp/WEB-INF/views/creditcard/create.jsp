<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add credit card</title>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
    <c:if test="${validateCardInfo != null }">
        <c:forEach var="transaction" items="${validateCardInfo}">
            <tr>
                <td>${transaction}</td>

            </tr>
        </c:forEach>

    </c:if>
    <form  method="post" action="/transaction/create/creditfromcard">
        <h2>Payment details</h2>
        <input type="radio" name="cardType" value="mastercard">Mastercard<br>
        <input type="radio" name="cardType" value="visa">Visa
        <ul>
            <li>
                <label for="id_user">AccountID</label>
                <input type="text" id="id_user" name="id_Account" value="2">
            </li>

            <li>
                <label for="card_number">Card number</label>
                <input type="text" id="card_number" name="card_number">
            </li>

            <li>
                <label for="expiry_date">Expiry date <small>mm/yy</small></label>
                <input type="text" maxlength="5" id="expiry_date" name="expiry_date">
            </li>

            <li>
                <label for="cvv">CVV</label>
                <input type="text" maxlength="3" id="cvv" name="cvv">
            </li>

            <li>
                <label for="name_on_card">Name on card</label>
                <input type="text" id="name_on_card" name="name_on_card">
            </li>

            <li>
                <label for="sumid">Sum</label>
                <input type="text" id="sumid" name="sum" >
            </li>
        </ul>

        <button type="submit">Create</button>
    </form>
</body>
</html>