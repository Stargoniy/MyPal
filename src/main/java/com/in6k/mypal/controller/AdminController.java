package com.in6k.mypal.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String adminLogged(ModelMap model) {
        return "/security/login";
    }

    @RequestMapping("/page")
    public String showAdminPage(HttpServletRequest request) {
        HttpSession session = request.getSession();

        boolean isAdminLogged = session.getAttribute("Admin") != null;

        if (isAdminLogged) {
            return "/admin/page";
        }

        return "/security/login";
    }
}