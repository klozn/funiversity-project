package com.switchfully.funiversity.funiversityproject.domain.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerAdvisor {

    Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(ProfessorNotFoundException.class)
    public void handleProfessorNotFoundException(ProfessorNotFoundException exception,
                                                 HttpServletResponse response) throws IOException {
        logger.warn("Professor not found. Message = " + exception.getMessage());
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public void handleCourseNotFoundException(CourseNotFoundException exception,
                                                 HttpServletResponse response) throws IOException {
        logger.warn("Course not found. Message = " + exception.getMessage());
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException exception,
                                               HttpServletResponse response) throws IOException {
        logger.warn("Illegal argument. Message = " + exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
