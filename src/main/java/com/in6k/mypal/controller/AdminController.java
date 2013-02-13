package com.in6k.mypal.controller;

import com.in6k.mypal.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/users")
    public String showRegistredUsers(ModelMap model) {

        model.addAttribute("userlist", UserDao.list());

        return "/user/list";
    }

    @RequestMapping("/user/ban")
    public  void BanUser(int id) {

    }
}