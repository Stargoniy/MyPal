package com.in6k.mypal.controller;

import com.in6k.mypal.service.facebook.Facebook;
import com.in6k.mypal.service.facebook.FacebookService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@Controller
public class SingInFbController {
    @RequestMapping(value = "/facebook/registration", method = RequestMethod.GET)
    public void registration(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        String code = request.getParameter("code");

        if(code == null) {
            response.sendRedirect(Facebook.getLoginRedirectURL());
        }
        else{
            String authURL = Facebook.getAuthURL(code);
            URL url = new URL(authURL);

            String result = FacebookService.readUrl(url);
            String accessToken = null;
            String[] pairs = result.split("&");
            for (String pair : pairs) {
                String[] kv = pair.split("=");
                if (kv.length != 2) {
                    throw new RuntimeException("Unexpected auth response");
                } else {
                    if (kv[0].equals("access_token")) {
                        accessToken = kv[1];
                    }
                }
            }

            JSONObject jsonObject = FacebookService.getFacebookUserData(accessToken);

            System.out.println(jsonObject.getString("id"));
            System.out.println(jsonObject.getString("first_name"));
            System.out.println(jsonObject.getString("last_name"));
            System.out.println(jsonObject.getString("email"));

        }
    }
}
