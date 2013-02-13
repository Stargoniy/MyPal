<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
      xmlns:fb="https://www.facebook.com/2008/fbml">
<head>
    <title>OG Tutorial App</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"  type="text/javascript"></script>
    <script src="//connect.facebook.net/en_US/all.js"></script>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css" />
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
                        $("#new_user_form").submit();
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
        <form method="post" action="/facebook/user/add" id="new_user_form">
            <input type="hidden" id="first_name" name="first_name" value="">
            <input type="hidden" id="last_name" name="last_name" value="">
            <input type="hidden"id="email" name="email" value="">
        </form>
        <button id="fb_login" class="btn">Login with Facebook</button>
    </body>       `
</html>