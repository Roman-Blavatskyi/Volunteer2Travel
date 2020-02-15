package com.softserve.firstdemo.service.validation;

public class IntegerValidator {

    public void validateInteger(String intNumber) {
        try {
            Integer.parseInt(intNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number is not valid. Please, try again.");
        }
    }

}
