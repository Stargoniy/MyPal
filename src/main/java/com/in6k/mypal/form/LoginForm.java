package com.in6k.mypal.form;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    public boolean isPasswordMatch() {
        user = UserDao.getByEmail(email);
        boolean isMatch = (user != null && user.getPassword().equals(SecurityUtil.passwordEncoder(password))) ? true : false;
        return isMatch;
    }
}
