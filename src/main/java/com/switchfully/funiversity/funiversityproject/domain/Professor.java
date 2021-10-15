package com.switchfully.funiversity.funiversityproject.domain;

import java.util.*;

public class Professor {

    private final String id;
    private Set<String> titles = new HashSet<>();
    private String name;
    private final Set<Course> courses = new HashSet<>();

    public Professor(String name, Set<String> titles) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.titles = titles;
    }

    public String getId() {
        return id;
    }

    public Set<String> getTitles() {
        return titles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void addTitle(String title) {
        titles.add(title);
    }

    public void removeTitle(String title) {
        titles.remove(title);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
