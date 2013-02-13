<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <h3>Signin In</h3>

        <form method="post" action="/login">

            Email<br>
            <input name="email" type="text" class="input-large" placeholder="Email"><br>

            Password <br>
            <input name="password" type="text" class="input-large" placeholder="Password"><br>

            <button type="submit" class="btn btn-primary">Log In</button>

        </form>
    </body>
</html>