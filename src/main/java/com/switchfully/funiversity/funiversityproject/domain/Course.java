package com.switchfully.funiversity.funiversityproject.domain;

import java.util.UUID;

public class Course {
    private final String id;
    private String name;
    private String description;

    public Course(String name, String description) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
    }
}
