<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="./../../bootstrap/css/bootstrap.css" />
</head>
<body>
<div>
    <form method="post" action="/transactions" class="form-inline">
        <fieldset>
            <ul class="nav nav-tabs">
                <li class="active"><a href="/transactions" data-toggle="tab">Transactions</a></li>
            </ul>
            <label>ivanov@gmail.com</label>

            <label>Debet email:</label>
            <input name="email" type="text" class="input-medium" placeholder="Email">
            <input name="sum" type="text" class="input-medium" placeholder="Sum">
            <button type="submit" class="btn btn-primary">Create</button>
        </fieldset>
    </form>
</div>
</body>
</html>