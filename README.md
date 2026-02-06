# 🎓 Guvi SDE Spring - Student Course Enrollment System

A Spring Boot + MongoDB backend application that manages:

- 👤 Students
- 📘 Courses
- 📝 Enrollments

This project demonstrates clean layered architecture using:

- Spring Boot
- Spring Data MongoDB
- REST APIs
- Proper domain modeling
- Repository pattern

---

## 🚀 Tech Stack

- Java 25 (LTS)
- Spring Boot
- Spring Web
- Spring Data MongoDB
- MongoDB
- Maven

---

## 🏗️ Project Architecture

```

Controller
↓
Service
↓
Repository
↓
MongoDB

````

Each domain follows clean separation of concerns.

---

## 📂 Collections Used

| Collection   | Description |
|-------------|-------------|
| students    | Stores student details |
| courses     | Stores course details |
| enrollments | Connects students to courses |

---

## 👤 Student Model

```json
{
  "_id": "65b7f3b2a9c7e24e0f4e1a91",
  "name": "Soumyajit",
  "email": "soumyajit@example.com",
  "active": true
}
````

---

## 📘 Course Model

```json
{
  "_id": "65b9a0c2a9c7e24e0f4e20a1",
  "title": "Spring Boot Foundations",
  "code": "SB101",
  "active": true
}
```

---

## 📝 Enrollment Model

```json
{
  "_id": "65b9a13aa9c7e24e0f4e20b2",
  "studentId": "65b7f3b2a9c7e24e0f4e1a91",
  "courseId": "65b9a0c2a9c7e24e0f4e20a1",
  "enrolledAt": "2026-02-01T10:15:00Z",
  "status": "ACTIVE"
}
```

---

# 🌐 API Endpoints

Base URL:

```
http://localhost:9000
```

---

## 👤 Student APIs

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | /students      | Create student    |
| GET    | /students      | List students     |
| GET    | /students/{id} | Get student by ID |
| PUT    | /students/{id} | Update student    |
| DELETE | /students/{id} | Delete student    |

Supports search, pagination and sorting:

```
GET /students?q=example&sortBy=email&sortDir=desc&page=0&size=5
```

---

## 📘 Course APIs

| Method | Endpoint      | Description      |
| ------ | ------------- | ---------------- |
| POST   | /courses      | Create course    |
| GET    | /courses      | List courses     |
| GET    | /courses/{id} | Get course by ID |
| DELETE | /courses/{id} | Delete course    |

---

## 📝 Enrollment APIs

| Method | Endpoint                                  | Description                |
| ------ | ----------------------------------------- | -------------------------- |
| POST   | /enrollments?studentId={id}&courseId={id} | Enroll student             |
| GET    | /enrollments/student/{studentId}          | Get enrollments by student |
| GET    | /enrollments/course/{courseId}            | Get enrollments by course  |

---

# 🧪 How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone <your-repo-url>
```

### 2️⃣ Configure MongoDB

Make sure MongoDB is running locally.

Update `application.properties`:

```
spring.data.mongodb.uri=mongodb://localhost:27017/guvi_sde
server.port=9000
```

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

Server starts at:

```
http://localhost:9000
```

---

# 🧠 Design Decisions

* Enrollment stores only `studentId` and `courseId` to keep documents independent.
* Unique index on course `code`.
* Layered architecture (Controller → Service → Repository).
* Uses `Instant` for enrollment timestamp.
* MongoDB `_id` mapped using `@Id`.

---

# 📌 Future Improvements

* Prevent duplicate enrollments (compound index)
* Convert enrollment status to Enum
* Add DTO layer
* Add global exception handling
* Add pagination for courses and enrollments
* Add authentication (JWT)

---

# 🎯 Learning Outcomes

This project demonstrates:

* Proper NoSQL document modeling
* Reference-based relationships in MongoDB
* Clean Spring Boot architecture
* REST API design principles
* Service-level validation

---

# 👨‍💻 Author

## Soumyajit Nandi
