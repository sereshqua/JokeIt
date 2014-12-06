package com.jokeit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SecurityService {
    @Value("${security.username}")
    private String username;

    @Value("${security.password}")
    private String password;

    @Autowired
    private HttpSession session;

    public boolean doLogin(String username, String password) {
        if (this.username.equals(username) &&
                this.password.equals(password)) {

            session.setAttribute("admin", username);
            return true;
        }
        return false;
    }


    public void doLogout() {
        session.invalidate();
    }

    public boolean isLogged() {
        System.out.println(session.getAttribute("admin"));
        return session.getAttribute("admin") != null;
    }
}
