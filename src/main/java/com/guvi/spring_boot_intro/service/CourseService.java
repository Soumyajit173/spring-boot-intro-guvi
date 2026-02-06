package com.guvi.spring_boot_intro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guvi.spring_boot_intro.model.Course;
import com.guvi.spring_boot_intro.repo.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(String title, String code) {
        Course course = new Course(null, title, code, true);
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
