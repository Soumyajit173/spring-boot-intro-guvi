package com.guvi.spring_boot_intro.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.guvi.spring_boot_intro.model.Enrollment;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {

    List<Enrollment> findByStudentId(String studentId);

    List<Enrollment> findByCourseId(String courseId);

}
