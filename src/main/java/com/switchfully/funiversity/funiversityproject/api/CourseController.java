package com.switchfully.funiversity.funiversityproject.api;

import com.switchfully.funiversity.funiversityproject.api.dto.CourseDto;
import com.switchfully.funiversity.funiversityproject.api.dto.CreateCourseDto;
import com.switchfully.funiversity.funiversityproject.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public List<CourseDto> getAll() {
        logger.info("All courses queried");
        return service.getAllCourses();
    }

    @PostMapping(consumes = "application/json", produces = "application/json", params = "professorId")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto create(@RequestBody CreateCourseDto courseDto, @RequestParam String professorId) {
        logger.info("Creating new course");
        return service.createNewCourse(courseDto, professorId);
    }

    @GetMapping(produces = "application/json", params = "studyPoints")
    public List<CourseDto> getAllFilteredByStudyPoints(@RequestParam int studyPoints) {
        logger.info("Querying all courses with " + studyPoints + " study points.");
        return service.getAllCourses().stream()
                .filter(courseDto -> courseDto.getAmountOfStudyPoints() == studyPoints)
                .collect(Collectors.toList());
    }

    @PatchMapping(path = "/{courseId}", produces = "application/json")
    public CourseDto changeProfessor(@PathVariable String courseId, @RequestParam String professorId) {
        logger.info("Changing professor of course with id:" + courseId + " to professor with id:" + professorId);
        return service.changeProfessor(courseId, professorId);
    }
}
