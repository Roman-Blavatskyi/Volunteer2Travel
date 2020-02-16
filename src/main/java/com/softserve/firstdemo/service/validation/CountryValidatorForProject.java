package com.softserve.firstdemo.service.validation;

import com.softserve.firstdemo.dao.CountryDao;
import com.softserve.firstdemo.entity.Country;
import com.softserve.firstdemo.entity.Project;

public class CountryValidatorForProject {

    private CountryDao countryDao = new CountryDao();

    public void validateCountry(Project project, String countryName) {
        Country country1 = countryDao.readByName(countryName);
        if (country1 != null) {
            project.setCountry(country1);
        } else {
            country1 = new Country();
            country1.setName(countryName);
            countryDao.create(country1);
            country1 = countryDao.readByName(countryName);
            project.setCountry(country1);
        }
    }
}
