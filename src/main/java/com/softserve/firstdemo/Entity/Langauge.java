package com.softserve.firstdemo.Entity;

import java.util.Objects;

public class Langauge {
    private int id;
    private String name;

    public Langauge() {
    }

    public Langauge(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Langauge langauge = (Langauge) o;
        return id == langauge.id &&
                name.equals(langauge.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Langauge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
