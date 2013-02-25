package com.in6k.mypal.form;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.util.SecurityUtil;

public class LoginForm {
    private String email;
    private User user;
    private String password;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUser() {
        user = UserDao.getByEmail(email);
        boolean isMatch = (null != user && user.getPassword().equals(SecurityUtil.passwordEncoder(password))
        && !(user.isSystem())) ? true : false;
        return isMatch;
    }

    public boolean isAdmin() {
        return this.user.getId() == 0;
    }
}
