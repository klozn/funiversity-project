package com.switchfully.funiversity.funiversityproject.api.dto;

import com.switchfully.funiversity.funiversityproject.domain.Course;
import com.switchfully.funiversity.funiversityproject.domain.Professor;

public class DtoMapper {
    public static CourseDto toDto(Course course) {
        return new CourseDto().setId(course.getId())
                .setName(course.getName())
                .setAmountOfStudyPoints(course.getAmountOfStudyPoints())
                .setProfessorDto(toDto(course.getProfessor()));
    }

    public static ProfessorDto toDto(Professor professor) {
        return new ProfessorDto().setId(professor.getId())
                .setFirstname(professor.getFirstname())
                .setLastname(professor.getLastname());
    }
}
