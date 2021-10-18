package com.switchfully.funiversity.funiversityproject.service;

import com.switchfully.funiversity.funiversityproject.api.dto.ProfessorDto;
import com.switchfully.funiversity.funiversityproject.domain.Professor;
import com.switchfully.funiversity.funiversityproject.domain.repositories.ProfessorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProfessorServiceTest {

    @Mock
    ProfessorRepository repository;

    @Autowired
    @InjectMocks
    ProfessorService service;

    @Test
    void getProfessorById_returnsProfessorDto() {
        //given
        String testId = "testId";
        Professor testProfessor = new Professor("testFirstname", "testLastname");
        when(repository.getProfessorById(testId)).thenReturn(testProfessor);
        //when
        ProfessorDto professorDto = service.getProfessorById(testId);
        //then
        assertThat(testProfessor.getId()).isEqualTo(professorDto.getId());
        assertThat(testProfessor.getFirstname()).isEqualTo(professorDto.getFirstname());
        assertThat(testProfessor.getLastname()).isEqualTo(professorDto.getLastname());
        assertThat(testProfessor.getCourses()).containsExactlyElementsOf(professorDto.getCourses());
    }
}