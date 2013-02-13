<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
    </head>
    <body>


    <c:out value="${sess.email}" />

    <form method="post" action="/transaction/create">

            From:<br>
            <select name="credit">
                <c:if test="${users != null }">

                    <c:forEach var="user" items="${users}">
                        <option value="${user.id}"> ${user.firstName}</option>
                    </c:forEach><br>

                </c:if>
            </select><br>

            Debit email:<br>
            <input name="debit" type="text" class="input-large" placeholder="Email"><br>

            Sum: <br>
            <input name="sum" type="text" class="input-large" placeholder="Sum"><br>

            <button type="submit" class="btn btn-primary">Create</button>

        </form>
    </body>
</html>
