<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 13.02.13
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form  method="post" action="/transaction/create/debitedtothecard">
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
                <label for="sumid">Sum</label>
                <input type="text" id="sumid" name="sum" >
            </li>
        </ul>

        <button type="submit">Create</button>
    </form>
</body>
</html>