package com.softserve.firstdemo.service.validation;

import com.softserve.firstdemo.dao.CountryDao;
import com.softserve.firstdemo.entity.Country;
import com.softserve.firstdemo.entity.User;

public class CountryValidatorForUser {

    private CountryDao countryDao = new CountryDao();

    public void validateCountry(User user, String countryName) {
        Country country1 = countryDao.readCountryByName(countryName);
        if (country1 != null) {
            user.setCountry(country1);
        } else {
            country1 = new Country();
            country1.setName(countryName);
            countryDao.create(country1);
            country1 = countryDao.readCountryByName(countryName);
            user.setCountry(country1);
        }
    }
}
