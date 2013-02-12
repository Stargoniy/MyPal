package com.in6k.mypal.services;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.form.RegistrationForm;
import com.in6k.mypal.util.SecurityUtil;

public class RegistrationService {

    private User user;

    public RegistrationService(RegistrationForm registrationForm) {
        user = new User();
        user.setFirstName(registrationForm.getFirstName());
        user.setLastName(registrationForm.getLastName());
        user.setEmail(registrationForm.getEmail());
        user.setPassword(SecurityUtil.passwordDecoder(registrationForm.getPassword()));
    }

    public boolean hasErrors() {
        return null != UserDao.getByEmail(user.getEmail());
    }

    public void register() {
        UserDao.save(user);
    }
}