package com.softserve.firstdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Background {
    private int id;
    private String name;

    private List<Project> projects = new ArrayList<>();

    public Background() {
    }

    public Background(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Background(String name) {
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Background that = (Background) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Background{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
