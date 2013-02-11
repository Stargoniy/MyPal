package com.in6k.mypal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @RequestMapping("/register")
    public String register() {
        return null;
    }

    @RequestMapping("/login")
    public String login() {
        return null;
    }

    @RequestMapping("/logout")
    public String logout() {
        return null;
    }
}
