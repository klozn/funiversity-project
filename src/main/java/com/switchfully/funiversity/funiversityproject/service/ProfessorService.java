package com.switchfully.funiversity.funiversityproject.service;

import com.switchfully.funiversity.funiversityproject.api.dto.CreateProfessorDto;
import com.switchfully.funiversity.funiversityproject.api.dto.ProfessorDto;
import com.switchfully.funiversity.funiversityproject.domain.Professor;
import com.switchfully.funiversity.funiversityproject.domain.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    @Autowired
    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<ProfessorDto> getAllProfessors() {
        var professors = new ArrayList<>(repository.getAllProfessors());
        return professors.stream()
                .map(this::toDto)
                .sorted(Comparator.comparing(ProfessorDto::getName))
                .collect(Collectors.toList());
    }

    public ProfessorDto getProfessorById(String id) {
        return toDto(repository.getProfessorById(id));
    }

    public ProfessorDto save(CreateProfessorDto createProfessorDto) {
        Professor professor = new Professor(createProfessorDto.getName(), createProfessorDto.getTitles());
        repository.save(professor);
        return toDto(professor);
    }

    private ProfessorDto toDto(Professor professor) {
        return new ProfessorDto().setId(professor.getId())
                .setName(professor.getName())
                .setTitles(professor.getTitles())
                .setCourses(professor.getCourses());
    }

}
