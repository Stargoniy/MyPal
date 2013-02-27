package com.mypal.service.ValidUser;

import com.mypal.dao.UserDao;
import com.mypal.domain.User;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ValidUserAndRedirecttoLogin {
    private boolean myResult;
    private HttpServletRequest request;
    private ModelMap model;
    private HttpSession session;

    public ValidUserAndRedirecttoLogin(HttpServletRequest request, ModelMap model) {
        this.request = request;
        this.model = model;
    }

    public boolean is() {
        return myResult;
    }

    public HttpSession getSession() {
        return session;
    }

    public ValidUserAndRedirecttoLogin invoke() {
        session = request.getSession();

        if (SessionValidService.ValidUser(session) == null || SessionValidService.ValidUser(session).getActive() == false) {
            User userSession = (User) session.getAttribute("LoggedUser");
            model.addAttribute("sess", userSession);
            model.addAttribute("balance", UserDao.getBalance(userSession));
            myResult = true;
            return this;
        }
        myResult = false;
        return this;
    }
}
