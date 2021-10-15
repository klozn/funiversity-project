package com.switchfully.funiversity.funiversityproject.service;

import com.switchfully.funiversity.funiversityproject.FuniversityApplication;
import com.switchfully.funiversity.funiversityproject.api.dto.ProfessorDto;
import com.switchfully.funiversity.funiversityproject.domain.Professor;
import com.switchfully.funiversity.funiversityproject.domain.repositories.ProfessorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
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
        Professor testProfessor = new Professor("testName", "doc", "prof");
        when(repository.getProfessorById(testId)).thenReturn(testProfessor);
        //when
        ProfessorDto professorDto = service.getProfessorById(testId);
        //then
        assertThat(testProfessor.getId()).isEqualTo(professorDto.getId());
        assertThat(testProfessor.getName()).isEqualTo(professorDto.getName());
        assertThat(testProfessor.getTitles()).containsExactlyElementsOf(professorDto.getTitles());
        assertThat(testProfessor.getCourses()).containsExactlyElementsOf(professorDto.getCourses());
    }
}