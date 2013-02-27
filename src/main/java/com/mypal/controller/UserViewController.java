package com.mypal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/home")
public class UserViewController {
    @RequestMapping(value = "")
    public String creationForm(ModelMap model, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//
//        User userSession = (User) session.getAttribute("LoggedUser");
//        if (userSession == null) {
//            return "redirect:/login";
//        }
//        model.addAttribute("sess", userSession);

        return "home";
    }
}
