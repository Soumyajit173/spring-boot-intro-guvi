package com.guvi.spring_boot_intro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.guvi.spring_boot_intro.model.Enrollment;
import com.guvi.spring_boot_intro.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public Enrollment enroll(
            @RequestParam String studentId,
            @RequestParam String courseId) {

        return enrollmentService.enroll(studentId, courseId);
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getByStudent(@PathVariable String studentId) {
        return enrollmentService.getEnrollmentsByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Enrollment> getByCourse(@PathVariable String courseId) {
        return enrollmentService.getEnrollmentsByCourse(courseId);
    }
}
