package com.softserve.firstdemo.dao;

import java.util.List;

public interface IGeneralDao<T> {

    void create(T t);

    List<T> readAll();

    T readById(int id);

    void update(T t);

    void delete(int id);
}
