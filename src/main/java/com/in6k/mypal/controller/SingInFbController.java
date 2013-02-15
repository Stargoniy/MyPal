package com.in6k.mypal.controller;

import com.in6k.mypal.service.facebook.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SingInFbController {
    @RequestMapping(value = "/facebook/registration", method = RequestMethod.GET)
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(Facebook.getLoginRedirectURL());
    }
}
