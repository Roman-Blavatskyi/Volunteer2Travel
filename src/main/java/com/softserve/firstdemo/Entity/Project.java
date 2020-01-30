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

    private List<Location> locations;
    private List<Prerequisite> prerequisites;
    private List<User> users;

    public Project() {
    }

    public Project(int id, String name, String description,
                   LocalDate startDate, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.duration = duration;
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

    public List<Prerequisite> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Prerequisite> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
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
                prerequisites.equals(project.prerequisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startDate,
                duration, prerequisites);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", prerequisites=" + prerequisites +
                '}';
    }
}
