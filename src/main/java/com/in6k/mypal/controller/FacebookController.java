package com.in6k.mypal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/facebook")
public class FacebookController {
    @RequestMapping(value = "/login")
    public String showPage() {
        return "facebook_login_page/facebookLoginTest";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request) {
        System.out.println(request.getParameter("first_name"));
        System.out.println(request.getParameter("last_name"));
        System.out.println(request.getParameter("email"));
        return "facebook_login_page/facebookLoginTest";
    }
}
