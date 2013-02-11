package com.in6k.mypal.controller;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistartion() {
        return "security/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processRegistartion() {
        User user = new User();
        user.setFirstName("Ruslan");
        user.setLastName("Pistriak");
        user.setEmail("pistriak@gmail.com");
        user.setPassword("01e20b61d05bb6b42840997233579e08");

        UserDao.save(user);

        return "redirect:/registration";
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
