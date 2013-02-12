<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.css" />
</head>
<body>
<div>
    <form method="post" action="/transaction/create" class="form-inline">
        <fieldset>
            <p><label>${user.email}</label></p>

            <p><label>Debit email:</label><input name="debit" type="text" class="input-medium" placeholder="Email"></p>
            <p><label>Sum:</label><input name="sum" type="text" class="input-medium" placeholder="Sum"></p>
            <input type="hidden" name="credit" value="${user.id}" />
            <button type="submit" class="btn btn-primary">Create</button>
        </fieldset>
    </form>
</div>
</body>
</html>