# 📘 Changelog

All notable changes to this project will be documented in this file.

The format follows Semantic Versioning.

---

## [v1.0.0] - 2026-02-06

### Added
- Student CRUD APIs
- Student search with pagination and sorting
- Course CRUD APIs
- Unique index on course code
- Enrollment APIs (Student ↔ Course)
- Service-level validation for enrollments
- MongoDB integration
- Layered architecture (Controller → Service → Repository)

### Tech
- Java 25 (LTS)
- Spring Boot
- Spring Data MongoDB
