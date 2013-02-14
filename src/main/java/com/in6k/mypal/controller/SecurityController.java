package com.in6k.mypal.controller;


import com.in6k.mypal.form.LoginForm;
import com.in6k.mypal.form.RegistrationForm;
import com.in6k.mypal.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class SecurityController {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        RegistrationForm registrationForm = new RegistrationForm();

        model.addAttribute("registrationForm", registrationForm);
        return "security/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processRegistrationForm(@Valid RegistrationForm registrationForm,BindingResult result, Model model) {
        RegistrationService registrationService = new RegistrationService(registrationForm);

        if (result.hasErrors() || registrationService.hasErrors()) {
            if (result.hasErrors()) {
                model.addAttribute("registrationForm", registrationForm);
            }
            if (registrationService.hasErrors()) {
                model.addAttribute("email_error", "*User with this email exists");
            }
            return "security/registration";
        }

        registrationService.register();

        return "redirect:/";
    }

     @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "security/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logIn(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        LoginForm loginForm = new LoginForm(email, password);

        if (loginForm.isPasswordMatch()) {
            session.setAttribute("LoggedUser", loginForm.getUser());

            boolean isAdmin = loginForm.getUser().getId() == 0;

            if(isAdmin) {
                session.setAttribute("Admin", loginForm.getUser());
            }
        }
        else {
            model.addAttribute("error", "Wrong password for this user");
            model.addAttribute("email", email);
            return "security/login";
        }
        System.out.println(request.getSession().getAttribute("Admin"));
        return "redirect:/transaction/create";
    }

    @RequestMapping(value = "/logout")
    public String logOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("LoggedUser", null);
        return "redirect:/login";
    }
}
