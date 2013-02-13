<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
    </head>
    <body>
        <legend>
            <div><c:out value="${sess.email}" /></div>
            <div>Balance: <c:out value="${balance}" />$</div>
        </legend>

        <ul class="nav nav-tabs">
            <li><a href="/registration">Home</a></li>
            <li class="active"><a href="/transaction/create">Create transaction</a></li>
            <li><a href="/transaction/list">Transactions</a></li>
            <li><a href="/logout">Log out</a></li>
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
