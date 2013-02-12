<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
    </head>
    <body>
        <form method="post" action="/transaction/create">
            <p>${user.email}</p>

            Debit email:<br>
            <input name="debit" type="text" class="input-medium" placeholder="Email"><br>
            Sum: <br>
            <input name="sum" type="text" class="input-medium" placeholder="Sum"><br>
            <button type="submit" class="btn btn-primary">Create</button>
            <input type="hidden" name="credit" value="${user.id}" />
        </form>
    </body>
</html>
