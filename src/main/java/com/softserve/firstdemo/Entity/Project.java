package com.softserve.firstdemo.Entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Project {
    private int id;
    private String name;
    private String description;
    private LocalDate startDate;
    private int duration;
    private Prerequisite prerequisite;
    private Location location;

    private List<User> users;

    public Project() {
    }

    public Project(int id, String name, String description,
                   LocalDate startDate, int duration,
                   Prerequisite prerequisite, Location location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.duration = duration;
        this.prerequisite = prerequisite;
        this.location = location;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Prerequisite getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                duration == project.duration &&
                name.equals(project.name) &&
                description.equals(project.description) &&
                startDate.equals(project.startDate) &&
                prerequisite.equals(project.prerequisite) &&
                location.equals(project.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startDate, duration, prerequisite, location);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", prerequisite=" + prerequisite +
                ", location=" + location +
                '}';
    }
}
