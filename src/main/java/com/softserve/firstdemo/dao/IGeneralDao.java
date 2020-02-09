package com.softserve.firstdemo.dao;

import java.util.List;

public interface IGeneralDao<T, N> {

    void create(T t);

    List<T> readAll();

    T readById(N n);

    void update(T t, N n);

    void delete(N n);
}
