package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.CityDao;
import com.softserve.firstdemo.entity.City;
import com.softserve.firstdemo.service.validation.StringValidator;

import java.util.List;

public class CityService {

    private CityDao cityDao = new CityDao();
    private StringValidator stringValidator = new StringValidator();

    public void addCity(String name) {
        City city = new City();
        stringValidator.validateString(name);
        city.setName(name);
        cityDao.create(city);
    }

    public List<City> findAllCities() {
        return cityDao.readAll();
    }

    public City findById(int id) {
        return cityDao.readById(id);
    }

    public City findByName(String name) {
        return cityDao.readByName(name);
    }

    public void editCity(int id, String name) {
        City city = cityDao.readById(id);
        stringValidator.validateString(name);
        city.setName(name);
        cityDao.update(city);
    }

    public void deleteCity(int id) {
        if (id != 0) {
            cityDao.delete(id);
        }
    }
}
