<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="../../../bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <form action="/registration" method="post">
        <label>First name:</label>
        <input type="text" name="firts_name" placeholder="Enter first name" value="" /><br/>
        <label>Last name:</label>
        <input type="text" name="last_name" placeholder="Enter last name" value="" /><br/>
        <label>Email:</label>
        <input type="text" name="email" placeholder="Enter last name" value="" /><br/>
        <label>Password:</label>
        <input type="password" name="password" placeholder="Enter password" value="" /><br/>
        <label>Confirm:</label>
        <input type="confirm" name="confirm" placeholder="Enter confirm" value="" /><br/>
        <input type="submit" value="Register" />
    </form>
</body>
</html>
