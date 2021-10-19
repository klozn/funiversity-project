package com.switchfully.funiversity.funiversityproject.api;

import com.switchfully.funiversity.funiversityproject.api.dto.CourseDto;
import com.switchfully.funiversity.funiversityproject.api.dto.CreateProfessorDto;
import com.switchfully.funiversity.funiversityproject.api.dto.ProfessorDto;
import com.switchfully.funiversity.funiversityproject.api.dto.UpdateProfessorDto;
import com.switchfully.funiversity.funiversityproject.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService service;
    private final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

    @Autowired
    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public List<ProfessorDto> getAll() {
        logger.info("All professors in database queried.");
        return service.getAllProfessors();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ProfessorDto getById(@PathVariable String id) {
        ProfessorDto professorDto = service.getProfessorById(id);
        logger.info("Professor queried with id:" + id);
        return professorDto;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto create(@RequestBody CreateProfessorDto professorDto) {
        logger.info("New professor created");
        return service.createProfessor(professorDto);
    }

    @DeleteMapping(path = "/{id}", consumes = "application/json")
    public void remove(@PathVariable String id) {
        service.removeProfessor(id);
        logger.info("Removed professor with id:" + id);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ProfessorDto update(@PathVariable String id, @RequestBody UpdateProfessorDto professorDto) {
        ProfessorDto updated = service.updateProfessor(id, professorDto);
        logger.info("Updated professor with id:" + id);
        return updated;
    }

    @GetMapping(path = "/{id}/courses", produces = "application/json")
    public List<CourseDto> getCoursesByProfessorId(@PathVariable String id) {
        logger.info("Querying courses of professor with id:" + id);
        return service.getCoursesByProfessorId(id);
    }

}
