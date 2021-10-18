package com.switchfully.funiversity.funiversityproject.api.dto;

public class CourseDto {
    private String id;
    private String name;
    private int amountOfStudyPoints;
    private ProfessorDto professorDto;

    public String getId() {
        return id;
    }

    public CourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAmountOfStudyPoints() {
        return amountOfStudyPoints;
    }

    public CourseDto setAmountOfStudyPoints(int amountOfStudyPoints) {
        this.amountOfStudyPoints = amountOfStudyPoints;
        return this;
    }

    public ProfessorDto getProfessorDto() {
        return professorDto;
    }

    public CourseDto setProfessorDto(ProfessorDto professorDto) {
        this.professorDto = professorDto;
        return this;
    }
}
