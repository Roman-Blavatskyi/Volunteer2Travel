package com.softserve.firstdemo.Entity;

import java.util.List;
import java.util.Objects;

public class Prerequisite {
    private int id;
    private List<Background> backgrounds;
    private List<Langauge> langauges;
    private List<Skill> skills;
    private List<Project> projects;

    public Prerequisite() {
    }

    public Prerequisite(int id, List<Background> backgrounds,
                        List<Langauge> langauges, List<Skill> skills) {
        this.id = id;
        this.backgrounds = backgrounds;
        this.langauges = langauges;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Background> getBackgrounds() {
        return backgrounds;
    }

    public void setBackgrounds(List<Background> backgrounds) {
        this.backgrounds = backgrounds;
    }

    public List<Langauge> getLangauges() {
        return langauges;
    }

    public void setLangauges(List<Langauge> langauges) {
        this.langauges = langauges;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
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
        Prerequisite that = (Prerequisite) o;
        return id == that.id &&
                backgrounds.equals(that.backgrounds) &&
                langauges.equals(that.langauges) &&
                skills.equals(that.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, backgrounds, langauges, skills);
    }

    @Override
    public String toString() {
        return "Prerequisite{" +
                "id=" + id +
                ", backgrounds=" + backgrounds +
                ", langauges=" + langauges +
                ", skills=" + skills +
                '}';
    }
}
