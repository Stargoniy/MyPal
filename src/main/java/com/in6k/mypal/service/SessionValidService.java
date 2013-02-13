package com.in6k.mypal.service;

import com.in6k.mypal.domain.User;

import javax.servlet.http.HttpSession;

public class SessionValidService {

    public static User ValidUser(HttpSession session){
        User result = (User) session.getAttribute("LoggedUser");
        return  result;
    }
}
