package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.CityDao;
import com.softserve.firstdemo.entity.City;

import java.util.List;

public class CityService {

    private CityDao cityDao = new CityDao();

    public void addCity(String name) {
        City city = new City(name);
        cityDao.create(city);
    }

    public List<City> findAllCities() {
        return cityDao.readAll();
    }

    public City findById(int id) {
        City city = cityDao.readById(id);
        return city;
    }

    public City findByName(String name) {
        City city = cityDao.readCityByName(name);
        return city;
    }

    public void editCity(int id, String name) {
        City city = cityDao.readById(id);
        city.setName(name);
        cityDao.update(city);
    }

    public void deleteCity(int id) {
        cityDao.delete(id);
    }
}
