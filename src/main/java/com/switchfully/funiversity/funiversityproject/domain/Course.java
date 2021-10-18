package com.switchfully.funiversity.funiversityproject.domain;

import java.util.Objects;
import java.util.UUID;

public class Course {
    private final String id;
    private String name;
    private int amountOfStudyPoints;
    private Professor professor;

    public Course(String name, int amountOfStudyPoints, Professor professor) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.amountOfStudyPoints = amountOfStudyPoints;
        this.professor = professor;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfStudyPoints() {
        return amountOfStudyPoints;
    }

    public void setAmountOfStudyPoints(int amountOfStudyPoints) {
        this.amountOfStudyPoints = amountOfStudyPoints;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (this.professor != null) {
            this.professor.removeCourse(this);
        }
        this.professor = professor;
        professor.addCourse(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
