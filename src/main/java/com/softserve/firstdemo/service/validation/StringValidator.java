package com.softserve.firstdemo.service.validation;

public class StringValidator {

    public void validateString(String string) {
        if (string == null || string.equals("")) {
            throw new IllegalArgumentException("One of the entered fields is empty or not correct. Please, try again.");
        }

        if (!string.matches("^[a-zA-Z_ ]*$")) {
            throw new IllegalArgumentException("One of the entered fields is not correct. Please, try again.");
        }
    }
}
