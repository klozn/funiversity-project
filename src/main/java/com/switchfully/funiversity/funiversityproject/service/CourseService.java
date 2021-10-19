package com.switchfully.funiversity.funiversityproject.service;

import com.switchfully.funiversity.funiversityproject.api.dto.CourseDto;
import com.switchfully.funiversity.funiversityproject.api.dto.CreateCourseDto;
import com.switchfully.funiversity.funiversityproject.api.dto.DtoMapper;
import com.switchfully.funiversity.funiversityproject.domain.Course;
import com.switchfully.funiversity.funiversityproject.domain.Professor;
import com.switchfully.funiversity.funiversityproject.domain.exceptions.CourseNotFoundException;
import com.switchfully.funiversity.funiversityproject.domain.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.switchfully.funiversity.funiversityproject.api.dto.DtoMapper.toDto;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ProfessorService professorService;

    @Autowired
    public CourseService(CourseRepository repository, ProfessorService professorService) {
        this.courseRepository = repository;
        this.professorService = professorService;
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.getAllCourses().stream()
                .map(DtoMapper::toDto)
                .sorted(Comparator.comparing(CourseDto::getName))
                .collect(Collectors.toList());
    }

    public CourseDto createNewCourse(CreateCourseDto courseDto, String professorId) {
        Professor professor = professorService.returnProfessorIfExistsElseThrowException(professorId);
        Course course = new Course(courseDto.getName(), courseDto.getAmountOfStudyPoints(), professor);
        courseRepository.save(course);
        return toDto(course);
    }

    public CourseDto changeProfessor(String courseId, String professorId) {
        Professor professor = professorService.returnProfessorIfExistsElseThrowException(professorId);
        Course course = returnCourseIfExistsElseThrowException(courseId);
        course.setProfessor(professor);
        return toDto(course);
    }

    private Course returnCourseIfExistsElseThrowException(String id) {
        Course course = courseRepository.getCourseById(id);
        if (course == null) {
            throw new CourseNotFoundException("No course found with id:" + id);
        }
        return course;
    }
}
