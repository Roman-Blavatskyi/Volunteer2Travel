package com.softserve.firstdemo.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private int id;
    private String name;
    private String description;
    private Date startDate;
    private int duration;
    private String urlImage;
    private Country country;
    private City city;

    private List<User> users = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();
    private List<Background> backgrounds = new ArrayList<>();
    private List<Language> languages = new ArrayList<>();

    public Project() {
    }

    public Project(int id, String name, String description, Date startDate, int duration, String urlImage, Country country, City city) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.duration = duration;
        this.urlImage = urlImage;
        this.country = country;
        this.city = city;
    }

    public Project(String name, String description, Date startDate, int duration, String urlImage, Country country, City city) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.duration = duration;
        this.urlImage = urlImage;
        this.country = country;
        this.city = city;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Background> getBackgrounds() {
        return backgrounds;
    }

    public void setBackgrounds(List<Background> backgrounds) {
        this.backgrounds = backgrounds;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                duration == project.duration &&
                Objects.equals(name, project.name) &&
                Objects.equals(description, project.description) &&
                Objects.equals(startDate, project.startDate) &&
                Objects.equals(urlImage, project.urlImage) &&
                Objects.equals(country, project.country) &&
                Objects.equals(city, project.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startDate, duration, urlImage, country, city);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", urlImage='" + urlImage + '\'' +
                ", country=" + country +
                ", city=" + city +
                '}';
    }
}
