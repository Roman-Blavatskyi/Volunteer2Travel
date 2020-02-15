package com.softserve.firstdemo.service.validation;

import com.softserve.firstdemo.dao.CityDao;
import com.softserve.firstdemo.entity.City;
import com.softserve.firstdemo.entity.Project;

public class CityValidator {

    private CityDao cityDao = new CityDao();

    public void validateCity(Project project, String cityName) {
        City city1 = cityDao.readCityByName(cityName);
        if (city1 != null) {
            project.setCity(city1);
        } else {
            city1 = new City();
            city1.setName(cityName);
            cityDao.create(city1);
            city1 = cityDao.readCityByName(cityName);
            project.setCity(city1);
        }
    }
}
