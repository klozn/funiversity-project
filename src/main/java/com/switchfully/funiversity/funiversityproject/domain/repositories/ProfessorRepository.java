package com.switchfully.funiversity.funiversityproject.domain.repositories;

import com.switchfully.funiversity.funiversityproject.domain.Professor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProfessorRepository {
    private final Map<String, Professor> professorMap = new HashMap<>();

    public Professor getProfessorById(String id) {
        return professorMap.get(id);
    }

    public void save(Professor professor) {
        professorMap.put(professor.getId(), professor);
    }

    public Collection<Professor> getAllProfessors() {
        return professorMap.values();
    }

    public void remove(String id) {
        professorMap.remove(id);
    }

}
