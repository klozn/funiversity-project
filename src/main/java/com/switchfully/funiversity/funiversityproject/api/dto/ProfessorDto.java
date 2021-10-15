package com.switchfully.funiversity.funiversityproject.api.dto;

import com.switchfully.funiversity.funiversityproject.domain.Course;

import java.util.HashSet;
import java.util.Set;

public class ProfessorDto {
    private String id;
    private Set<String> titles = new HashSet<>();
    private String name;
    private Set<Course> courses = new HashSet<>();

    public String getId() {
        return id;
    }

    public ProfessorDto setId(String id) {
        this.id = id;
        return this;
    }

    public Set<String> getTitles() {
        return titles;
    }

    public String getName() {
        return name;
    }

    public ProfessorDto setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public ProfessorDto setTitles(Set<String> titles) {
        this.titles = titles;
        return this;
    }

    public ProfessorDto setCourses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }
}
