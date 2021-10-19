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
        setName(name);
        setAmountOfStudyPoints(amountOfStudyPoints);
        setProfessor(professor);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name for course can't be null or blank.");
        }
        this.name = name;
    }

    public int getAmountOfStudyPoints() {
        return amountOfStudyPoints;
    }

    public void setAmountOfStudyPoints(int amountOfStudyPoints) {
        if (amountOfStudyPoints < 3 || amountOfStudyPoints > 12) {
            throw new IllegalArgumentException("Amount of study points can't be lower than three or higher than 12.");
        }
        this.amountOfStudyPoints = amountOfStudyPoints;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor of course can't be null");
        }
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
