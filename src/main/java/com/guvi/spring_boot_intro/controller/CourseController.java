package com.guvi.spring_boot_intro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.guvi.spring_boot_intro.model.Course;
import com.guvi.spring_boot_intro.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course request) {
        return courseService.createCourse(
                request.getTitle(),
                request.getCode()
        );
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
