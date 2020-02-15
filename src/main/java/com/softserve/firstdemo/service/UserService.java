package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.CountryDao;
import com.softserve.firstdemo.dao.UserDao;
import com.softserve.firstdemo.entity.Country;
import com.softserve.firstdemo.entity.User;

import java.util.List;

public class UserService {
    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";
    private static UserDao userDao = new UserDao();
    private CountryDao countryDao = new CountryDao();

    public void addUser(String name, String surname, String country, String phone,
                        String email, String password, String repeatPassword) {

        User user = new User();
        user.setName(name);
        user.setSurname(surname);

        Country country1 = countryDao.readCountryByName(country);
        if (country1 != null) {
            user.setCountry(country1);
        } else {
            country1 = new Country();
            country1.setName(country);
            countryDao.create(country1);
            country1 = countryDao.readCountryByName(country);
            user.setCountry(country1);
        }
        user.setPhone(phone);
        user.setEmail(email);
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
        user.setName(name);
        user.setSurname(surname);

        Country country1 = countryDao.readCountryByName(country);
        if (country1 != null) {
            user.setCountry(country1);
        } else {
            country1 = new Country();
            country1.setName(country);
            countryDao.create(country1);
            country1 = countryDao.readCountryByName(country);
            user.setCountry(country1);
        }

        user.setPhone(phone);
        user.setEmail(email);
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
