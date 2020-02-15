package com.softserve.firstdemo.service.validation;

import com.softserve.firstdemo.dao.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private UserDao userDao = new UserDao();

    public void validateEmail(String email) throws IllegalArgumentException {
        String emailString = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailString);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            throw new IllegalArgumentException("Email is not valid. Please, check the syntax of your e-mail.");
        }
        existsEmail(email);
    }

    private void existsEmail(String email) throws IllegalArgumentException {
        if (userDao.readByEmail(email) != null) {
            throw new IllegalArgumentException("User with e-mail: `" + email + "` already exist. Please, try another e-mail.");
        }
    }
}
