package com.switchfully.funiversity.funiversityproject.service;

import com.switchfully.funiversity.funiversityproject.api.dto.*;
import com.switchfully.funiversity.funiversityproject.domain.Professor;
import com.switchfully.funiversity.funiversityproject.domain.exceptions.ProfessorNotFoundException;
import com.switchfully.funiversity.funiversityproject.domain.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.switchfully.funiversity.funiversityproject.api.dto.DtoMapper.toDto;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    @Autowired
    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<ProfessorDto> getAllProfessors() {
        return repository.getAllProfessors().stream()
                .map(DtoMapper::toDto)
                .sorted(Comparator.comparing(ProfessorDto::getLastname).thenComparing(ProfessorDto::getFirstname))
                .collect(Collectors.toList());
    }

    public ProfessorDto getProfessorById(String id) {
        Professor professor = returnProfessorIfExistsElseThrowException(id);
        return toDto(professor);
    }

    public ProfessorDto createProfessor(CreateProfessorDto ProfessorDto) {
        Professor professor = new Professor(ProfessorDto.getFirstname(), ProfessorDto.getLastname());
        repository.save(professor);
        return toDto(professor);
    }

    public void removeProfessor(String id) {
        Professor professor = returnProfessorIfExistsElseThrowException(id);
        repository.remove(professor.getId());
    }

    public ProfessorDto updateProfessor(String id, UpdateProfessorDto professorDto) {
        Professor professorToUpdate = returnProfessorIfExistsElseThrowException(id);
        professorToUpdate.setFirstname(professorDto.getFirstname());
        professorToUpdate.setLastname(professorDto.getLastname());
        repository.save(professorToUpdate);
        return toDto(professorToUpdate);
    }

    public List<CourseDto> getCoursesByProfessorId(String id) {
        Professor professor = returnProfessorIfExistsElseThrowException(id);
        return professor.getCourses().stream()
                .map(DtoMapper::toDto)
                .sorted(Comparator.comparing(CourseDto::getName))
                .collect(Collectors.toList());
    }

    protected Professor returnProfessorIfExistsElseThrowException(String id) {
        Professor professor = repository.getProfessorById(id);
        if (professor == null) {
            throw new ProfessorNotFoundException("No professor found with id:" + id);
        }
        return professor;
    }
}
