<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Founds transfer</title>
        <link rel="stylesheet" type="text/css" href="../../../bootstrap/css/bootstrap.min.css" />
    </head>
    <body>
        <h4>New transfer.</h4>
        <form method="post" action="/founds/transfer/add">
            <input type="email" placeholder="example@mail.com">
            <input type="text" placeholder="value"></br>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>
    </body>
</html>