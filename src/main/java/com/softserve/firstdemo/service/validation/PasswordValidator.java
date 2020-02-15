package com.softserve.firstdemo.service.validation;

public class PasswordValidator {

    public void validatePassword(String password, String passwordRepeat) throws IllegalArgumentException {
        validatePasswordLength(password);
        if (!password.equals(passwordRepeat)) {
            throw new IllegalArgumentException("Repeat password is not equal to password. Please, try again.");
        }
    }

    public void validatePasswordLength(String password) throws IllegalArgumentException {
        if (password.length() < 5) {
            throw new IllegalArgumentException("Length of password must be at least 5 symbols. Please, try again.");
        }
    }
}
