package com.guvi.spring_boot_intro.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.guvi.spring_boot_intro.model.Course;

public interface CourseRepository extends MongoRepository<Course, String> {

    Optional<Course> findByCode(String code);

}
