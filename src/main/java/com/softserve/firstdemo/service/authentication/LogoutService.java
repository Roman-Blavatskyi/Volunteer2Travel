package com.softserve.firstdemo.service.authentication;

import javax.servlet.http.HttpSession;

public class LogoutService {

    public void logout(HttpSession session) {
        session.invalidate();
    }
}
