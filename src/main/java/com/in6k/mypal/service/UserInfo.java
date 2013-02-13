package com.in6k.mypal.service;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.util.SecurityUtil;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserInfo {

    public boolean isLogged(String email, String password, ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        User user = UserDao.getByEmail(email);
        boolean isPasswordEquals = user.getPassword().equals(SecurityUtil.passwordEncoder(password));

        if (user != null && isPasswordEquals) {
            session.setAttribute("LoggedUser", user);
        }
        else {
            model.addAttribute("error", "Wrong password for this user");

        }
        return false;
    }

    public static void logOut(HttpServletRequest request) {
         HttpSession session = request.getSession();
         session.setAttribute("LoggedUser", null);
    }

    public static void isLogged(HttpServletRequest request, ModelMap model) {
        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute("LoggedUser");

        if (userSession != null) {
            model.addAttribute("sess", userSession);
            model.addAttribute("balance", UserDao.getBalance(userSession));
        }
    }

}
