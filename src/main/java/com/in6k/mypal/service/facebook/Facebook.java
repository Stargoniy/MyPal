package com.in6k.mypal.service.facebook;

public class Facebook {
    // get these from your FB Dev App
    private static final String api_key = "431373703610083";
    private static final String secret = "ee25dcd8e612b1d2d7e3d1e24a9dd2f6";
    private static final String client_id = "100003956230861";

        // set this to your servlet URL for the authentication servlet/filter
     private static final String redirect_uri = "http://localhost:8080/facebook/registration";
        /// set this to the list of extended permissions you want

    public static String getAPIKey() {
        return api_key;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getLoginRedirectURL() {
        return "https://graph.facebook.com/oauth/authorize?client_id=" +
                client_id + "&display=page&redirect_uri=" +
                redirect_uri+"&scope=user_birthday,read_stream";
    }

    public static String getAuthURL(String authCode) {
        return "https://graph.facebook.com/oauth/access_token?client_id=" +
                client_id+"&redirect_uri=" +
                redirect_uri+"&client_secret="+secret+"&code="+authCode;
    }
}
