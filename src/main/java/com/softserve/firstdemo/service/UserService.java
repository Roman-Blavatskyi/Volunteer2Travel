package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.CountryDao;
import com.softserve.firstdemo.dao.UserDao;
import com.softserve.firstdemo.entity.User;
import com.softserve.firstdemo.service.validation.*;

import java.util.List;

public class UserService {
    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";
    private static UserDao userDao = new UserDao();
    private CountryDao countryDao = new CountryDao();
    private StringValidator stringValidator = new StringValidator();
    private EmailValidator emailValidator = new EmailValidator();
    private PasswordValidator passwordValidator = new PasswordValidator();
    private PhoneValidator phoneValidator = new PhoneValidator();
    private CountryValidatorForUser countryValidator = new CountryValidatorForUser();

    public void addUser(String name, String surname, String country, String phone,
                        String email, String password, String repeatPassword) {

        User user = new User();
        stringValidator.validateString(name);
        user.setName(name);
        stringValidator.validateString(surname);
        user.setSurname(surname);
        stringValidator.validateString(country);
        countryValidator.validateCountry(user, country);
        phoneValidator.validatePhoneNumber(phone);
        user.setPhone(phone);
        emailValidator.validateEmail(email);
        user.setEmail(email);
        passwordValidator.validatePassword(password, repeatPassword);
        user.setPassword(password);

        userDao.create(user);
    }

    public User findById(int id) {
        return userDao.readById(id);
    }

    public User findUserByEmail(String email) {
        return userDao.readByEmail(email);
    }

    public List<User> findAllUsers() {
        return userDao.readAll();
    }

    public void editUser(int id, String name, String surname, String country, String phone,
                         String email, String password) {

        User user = userDao.readById(id);
        stringValidator.validateString(name);
        user.setName(name);
        stringValidator.validateString(surname);
        user.setSurname(surname);
        stringValidator.validateString(country);
        countryValidator.validateCountry(user, country);
        phoneValidator.validatePhoneNumber(phone);
        user.setPhone(phone);
        emailValidator.validateEmail(email);
        user.setEmail(email);
        passwordValidator.validatePasswordLength(password);
        user.setPassword(password);

        userDao.update(user);
    }

    public void deleteUser(int id) {
        if (id != 0) {
            userDao.delete(id);
        }
    }

    public boolean isAdmin(String userRole) {
        return userRole.equals(ROLE_ADMIN);
    }

    public boolean isUser(String userRole) {
        return userRole.equals(ROLE_USER);
    }
}
