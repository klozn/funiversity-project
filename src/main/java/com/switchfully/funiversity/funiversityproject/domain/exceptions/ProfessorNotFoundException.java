package com.switchfully.funiversity.funiversityproject.domain.exceptions;

public class ProfessorNotFoundException extends RuntimeException {
    public ProfessorNotFoundException() {
    }

    public ProfessorNotFoundException(String message) {
        super(message);
    }

    public ProfessorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfessorNotFoundException(Throwable cause) {
        super(cause);
    }
}
