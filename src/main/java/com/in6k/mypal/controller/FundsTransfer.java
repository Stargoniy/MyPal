package com.in6k.mypal.controller;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/founds")
public class FundsTransfer {

    @RequestMapping(value = "/transfer/add", method = RequestMethod.GET)
    public String showTransferPage() {
        return "founds_transfer/foundsTransfer";
    }

    @RequestMapping(value = "/transfer/add", method = RequestMethod.POST)
    public String addTransfer(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setFirstName("inactive");
        user.setLastName("inactive");
        user.setPassword("inactive");
        user.setActive(false);

        UserDao.save(user);


        return "founds_transfer/foundsTransfer";
    }
}
