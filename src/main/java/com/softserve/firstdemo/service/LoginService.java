package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.LoginDao;

public class LoginService {
    private LoginDao loginDao = new LoginDao();

    public boolean checkUserCredentials(String email, String password) {
        return loginDao.checkUserCredentials(email, password);
    }
}
