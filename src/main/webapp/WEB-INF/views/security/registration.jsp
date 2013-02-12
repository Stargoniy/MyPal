<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/registration" commandName="registrationForm">
    <form:label path="firstName">First name:</form:label>
    <form:errors path="firstName" />
    <form:input path="firstName" /><br/>

    <form:label path="lastName" for="lastName" >Last name:</form:label>
    <form:errors path="lastName" />
    <form:input path="lastName" /><br/>

    <form:label path="email" for="email" >Email:</form:label>
    <form:errors path="email" />
    <form:input path="email" /><br/>

    <form:label path="password" for="password" >Password:</form:label>
    <form:errors path="password" />
    <form:password path="password" /><br/>

    <form:label path="confirm" for="confirm" >Confirm password:</form:label>
    <form:errors path="confirm" />
    <form:password path="confirm" /><br/>

    <input type="submit" value="Register" />
</form:form>
</body>
</html>