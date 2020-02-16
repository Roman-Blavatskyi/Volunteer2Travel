package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.CountryDao;
import com.softserve.firstdemo.entity.Country;
import com.softserve.firstdemo.service.validation.StringValidator;

import java.util.List;

public class CountryService {

    private CountryDao countryDao = new CountryDao();
    private StringValidator stringValidator = new StringValidator();

    public void addCountry(String name) {
        Country country = new Country();
        stringValidator.validateString(name);
        country.setName(name);
        countryDao.create(country);
    }

    public List<Country> findAllCountries() {
        return countryDao.readAll();
    }

    public Country findById(int id) {
        return countryDao.readById(id);
    }

    public Country findByName(String name) {
        return countryDao.readByName(name);
    }

    public void editCountry(int id, String name) {
        Country country = countryDao.readById(id);
        stringValidator.validateString(name);
        country.setName(name);
        countryDao.update(country);
    }

    public void deleteCountry(int id) {
        if (id != 0) {
            countryDao.delete(id);
        }
    }
}
