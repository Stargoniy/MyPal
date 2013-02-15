<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
</head>
<body>
<h2>Administrator functions</h2>

<a href="/logout">log-out</a>

<ul class="nav nav-list">
    <li class="nav-header">Users and transactions</li>
    <li><a href="/users" >Show all users</a></li>
    <li><a href="/admin/transaction/list" >Show all transactions</a></li>
</ul>

</body>
</html>