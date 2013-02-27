package com.mypal.service;

import com.mypal.dao.UserDao;
import com.mypal.domain.User;
import com.mypal.form.RegistrationForm;
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
