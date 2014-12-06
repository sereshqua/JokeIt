package com.jokeit.web.controller;

import com.jokeit.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (securityService.isLogged()) {
            return "redirect:/jokes";
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(String username, String password) {
        if (securityService.doLogin(username, password)) {
            return "redirect:/jokes";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        securityService.doLogout();
        return "redirect:/jokes";
    }
}