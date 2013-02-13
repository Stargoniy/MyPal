<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"  type="text/javascript"></script>
    <script src="//connect.facebook.net/en_US/all.js"></script>

    <title>Registration</title>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }
        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
        .error {
            color: red;
        }
    </style>

    <script>
        function check_user_fb_login() {
            FB.login(function(response) {
                if (response.authResponse) {
                    console.log('Welcome!  Fetching your information.... ');
                    FB.api('/me', function(response) {
                        console.log('Good to see you, ' + response.first_name + " " + response.last_name + "" + " " + response.email +'.');
                        $("#first_name").val(response.first_name);
                        $("#last_name").val(response.last_name);
                        $("#email").val(response.email);
                    });
                } else {
                    console.log('User cancelled login or did not fully authorize.');
                }
            }, {scope: 'email'});
        }

        $(document).ready(function() {
            FB.init({
                appId      : 431373703610083,
                status     : true,
                cookie     : true,
                xfbml      : true
            });

            $("#fb_login").click(function(){
                check_user_fb_login();
            });
        });
    </script>

</head>
<body>

<div class="container">
    <form:form method="post" action="/registration" commandName="registrationForm" class="form-signin" >
        <h2>Registration</h2>

        <form:errors path="firstName" class="error" />
        <form:input id="first_name" path="firstName" placeholder="First name" class="input-block-level" /><br/>

        <form:errors path="lastName" class="error" />
        <form:input id="last_name" path="lastName" placeholder="Last name" class="input-block-level" /><br/>

        <form:errors path="email" class="error" />
        <span class="error">${email_error}</span>
        <form:input id="email" path="email" placeholder="Email address" class="input-block-level" /><br/>

        <form:errors path="password" class="error" />
        <form:password path="password" placeholder="Password" class="input-block-level" /><br/>

        <form:errors path="confirm" class="error" />
        <form:password path="confirm" placeholder="Confirm password" class="input-block-level" /><br/>

        <input class="btn btn-large btn-primary" type="submit" value="Register" />
        <img id="fb_login" src="/img/facebook/facebook-icon-small.jpg" width="50" height="25"/>
    </form:form>
</div>

</body>
</html>