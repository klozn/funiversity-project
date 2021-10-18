package com.switchfully.funiversity.funiversityproject.domain.repositories;

import com.switchfully.funiversity.funiversityproject.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseRepository {

    private final Map<String, Course> courses = new HashMap<>();

    public Course getCourseById(String id) {
        return courses.get(id);
    }

    public Collection<Course> getAllCourses() {
        return courses.values();
    }

    public void save(Course course) {
        courses.put(course.getId(), course);
    }

    public void remove(String id) {
        courses.remove(id);
    }
}
