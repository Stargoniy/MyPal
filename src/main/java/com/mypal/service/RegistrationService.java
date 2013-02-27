package com.mypal.service;

import com.mypal.dao.UserDao;
import com.mypal.domain.User;
import com.mypal.form.RegistrationForm;
import com.mypal.util.SecurityUtil;

public class RegistrationService {

    private User user;

    public RegistrationService(RegistrationForm registrationForm) {
        user = new User();
        user.setFirstName(registrationForm.getFirstName());
        user.setLastName(registrationForm.getLastName());
        user.setEmail(registrationForm.getEmail());
        user.setPassword(SecurityUtil.passwordEncoder(registrationForm.getPassword()));
        user.setActive(true);
    }

    public boolean hasErrors() {
        return null != UserDao.getByEmail(user.getEmail());
    }

    public void register() {
        UserDao.save(user);
    }
}
