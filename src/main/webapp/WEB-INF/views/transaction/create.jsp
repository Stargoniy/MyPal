<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
    </head>
    <body>
        <legend>
            <span><c:out value="${sess.email}" /></span>
            <span style="float: right">Balance: <c:out value="${balance}" />$</span>
        </legend>

        <ul class="nav nav-tabs">
            <li><a href="/transaction/create">Pay</a></li>
            <li><a href="/transaction/create">Cash-out</a></li>
            <li class="active"><a href="/transaction/create">Send money</a></li>
            <li><a href="/transaction/create/list">History</a></li>
            <li style="float: right"><a href="/logout">Log out</a></li>
        </ul>

        <form method="post" action="/transaction/create">
            Debit email:<br>
            <input name="debit" type="text" class="input-large" placeholder="Email"><br>
             Sum: <br>
            <input name="sum" type="text" class="input-large" placeholder="Sum"><br>
             <button type="submit" class="btn btn-primary">Create</button>

        </form>
    </body>
</html>
