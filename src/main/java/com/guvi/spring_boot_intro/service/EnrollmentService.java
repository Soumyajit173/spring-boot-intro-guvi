package com.guvi.spring_boot_intro.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.guvi.spring_boot_intro.model.Enrollment;
import com.guvi.spring_boot_intro.repo.EnrollmentRepository;
import com.guvi.spring_boot_intro.repo.StudentRepository;
import com.guvi.spring_boot_intro.repo.CourseRepository;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             StudentRepository studentRepository,
                             CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment enroll(String studentId, String courseId) {

        // Validate student exists
        studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Validate course exists
        courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment(
                null,
                studentId,
                courseId,
                Instant.now(),
                "ACTIVE"
        );

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudent(String studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourse(String courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }
}
