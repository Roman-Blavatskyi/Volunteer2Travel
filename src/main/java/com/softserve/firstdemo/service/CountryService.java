package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.CountryDao;
import com.softserve.firstdemo.entity.Country;

import java.util.List;

public class CountryService {

    private CountryDao countryDao = new CountryDao();

    public void addCountry(String name) {
        Country country = new Country(name);
        countryDao.create(country);
    }

    public List<Country> findAllCities() {
        return countryDao.readAll();
    }

    public Country findById(int id) {
        Country country = countryDao.readById(id);
        return country;
    }

    public Country findByName(String name) {
        Country country = countryDao.readCountryByName(name);
        return country;
    }

    public void editCountry(int id, String name) {
        Country country = countryDao.readById(id);
        country.setName(name);
        countryDao.update(country);
    }

    public void deleteCountry(int id) {
        countryDao.delete(id);
    }
}
