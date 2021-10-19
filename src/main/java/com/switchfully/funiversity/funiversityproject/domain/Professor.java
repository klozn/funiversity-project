package com.switchfully.funiversity.funiversityproject.domain;

import java.util.*;

public class Professor {

    private final String id;
    private String firstname;
    private String lastname;
    private Set<Course> courses;

    public Professor(String firstname, String lastname) {
        id = UUID.randomUUID().toString();
        setFirstname(firstname);
        setLastname(lastname);
        setCourses(new HashSet<>());
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (firstname == null || firstname.isBlank()) {
            throw new IllegalArgumentException("Firstname for professor can't be null or blank.");
        }
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if (lastname == null || lastname.isBlank()) {
            throw new IllegalArgumentException("Lastname for professor can't be null or blank.");
        }
        this.lastname = lastname;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
