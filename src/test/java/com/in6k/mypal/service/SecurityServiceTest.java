package com.in6k.mypal.service;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.form.RegistrationForm;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SecurityServiceTest {
    @Test
    public void shouldRegisterUser() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setFirstName("John");
        registrationForm.setLastName("Smith");
        registrationForm.setEmail("john@example.com");
        registrationForm.setPassword("secret");
        registrationForm.setPassword("secret");

        RegistrationService registrationService = new RegistrationService(registrationForm);
        registrationService.register();

        User user = UserDao.getByEmail("john@example.com");
        assertTrue(null != user);
    }
}
