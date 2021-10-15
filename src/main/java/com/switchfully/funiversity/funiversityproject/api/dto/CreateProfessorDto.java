package com.switchfully.funiversity.funiversityproject.api.dto;

import java.util.Set;

public class CreateProfessorDto {
    private String name;
    private Set<String> titles;

    public CreateProfessorDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Set<String> getTitles() {
        return titles;
    }

    public CreateProfessorDto addTitle(String title) {
        titles.add(title);
        return this;
    }
}
