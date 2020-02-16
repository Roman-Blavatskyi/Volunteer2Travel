package com.softserve.firstdemo.dao;

import java.util.List;

public interface IGeneralDao<T> {

    void create(T t);

    List<T> readAll();

    T readById(int id);

    T readByName(String name);

    void update(T t);

    void delete(int id);
}
