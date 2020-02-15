package com.softserve.firstdemo.service.validation;


import com.softserve.firstdemo.dao.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    private UserDao userDao = new UserDao();

    public void validatePhoneNumber(String phoneNumber) {
        String phoneFormat = "^\\+?3?8?(0\\d{9})$";
        Pattern phonePattern = Pattern.compile(phoneFormat);
        Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
        if (!phoneMatcher.matches()) {
            throw new IllegalArgumentException("Phone is not valid. Valid format of the phone number: +380xxxxxxxxx.");
        }
        existsPhoneNumber(phoneNumber);
    }

    private void existsPhoneNumber(String phoneNumber) {
        if (userDao.readByPhoneNumber(phoneNumber) != null) {
            throw new IllegalArgumentException("User with number: `" + phoneNumber + "` already exist. Please, try another phone number.");
        }
    }

}
