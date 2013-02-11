<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Credit Card</title>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
<form>
    <h2>Payment details</h2>

    <ul>
        <li>
            <ul class="cards">
                <li class="visa">Visa</li>
                <li class="visa_electron">Visa Electron</li>
                <li class="mastercard">MasterCard</li>
                <li class="maestro">Maestro</li>
                <li class="discover">Discover</li>
            </ul>
        </li>

        <li>
            <label for="card_number">Card number</label>
            <input type="text" id="card_number" name="card_number">
        </li>

        <li class="vertical">
            <ul>
                <li>
                    <label for="expiry_date">Expiry date <small>mm/yy</small></label>
                    <input type="text" maxlength="5" id="expiry_date" name="expiry_date">
                </li>

                <li>
                    <label for="cvv">CVV</label>
                    <input type="text" maxlength="3" id="cvv" name="cvv">
                </li>
            </ul>
        </li>

        <li>
            <label for="name_on_card">Name on card</label>
            <input type="text" id="name_on_card" name="name_on_card">
        </li>
    </ul>
</form>
</body>
</html>