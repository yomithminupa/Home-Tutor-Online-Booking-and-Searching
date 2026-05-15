# Final Report: Home Tutor Search and Booking System

## 1. Introduction

The Home Tutor Search and Booking System is a Java web application that allows users to manage students/parents, tutors, subjects, tutor bookings, payments, and reviews. The system uses Spring Boot and JSP for the web interface. SQL database storage is handled through Spring Data JPA.

## 2. Objectives

- Apply OOP concepts such as encapsulation, inheritance, polymorphism, abstraction, and information hiding.
- Implement CRUD operations for project modules.
- Use database storage for managing project data.
- Create a user-friendly web interface.
- Maintain GitHub commit history for individual contributions.

## 3. Main Modules

| Module | Database Table | Main Classes |
|---|---|---|
| User Management | `app_users` | `User`, `StudentUser`, `ParentUser`, `AdminUser`, `UserService` |
| Tutor Management | `tutors` | `Tutor`, `OnlineTutor`, `HomeVisitTutor`, `TutorService` |
| Subject Management | `subjects` | `Subject`, `AcademicSubject`, `SkillSubject`, `SubjectService` |
| Booking Management | `bookings` | `Booking`, `BookingService` |
| Payment Management | `payments` | `Payment`, `CardPayment`, `CashPayment`, `PaymentService` |
| Review Management | `reviews` | `Review`, `PublicReview`, `VerifiedReview`, `ReviewService` |

## 4. CRUD Operations

Each module supports create, read/search, update, and delete operations. Controllers receive form inputs from JSP pages and call service classes. Service classes use Spring Data JPA repositories to save, read, update, and delete records in the database.

## 5. OOP Concepts

### Encapsulation

Model classes keep fields private and provide getters and setters. Example: `User`, `Tutor`, `Booking`, `Payment`, and `Review`.

### Inheritance

`StudentUser`, `ParentUser`, and `AdminUser` inherit from `User`. `OnlineTutor` and `HomeVisitTutor` inherit from `Tutor`. `CardPayment` and `CashPayment` inherit from `Payment`.

### Polymorphism

Methods such as `displayProfile()`, `calculateSessionFee()`, `getPaymentMethod()`, and `displayReview()` behave differently depending on the object type.

### Abstraction

`User`, `Tutor`, `Subject`, `Payment`, and `Review` are abstract classes. `AbstractCrudService` contains common CRUD behavior used by service classes.

### Information Hiding

Controllers do not directly access the database. Database access is hidden inside repository and service classes.

## 6. Database Handling

Data is stored in database tables. The project uses an embedded H2 SQL database by default, and MySQL settings are also included in `application.properties`.

Example tables:

```text
app_users
tutors
subjects
bookings
payments
reviews
```

The model classes use JPA annotations such as `@Entity`, `@Table`, and `@Id`. Repository interfaces extend `JpaRepository` to perform CRUD operations.

## 7. User Interfaces

- Dashboard
- User management pages
- Tutor management pages
- Subject management pages
- Booking management pages
- Payment management pages
- Review management pages

## 8. GitHub Commit History

Paste screenshots or a table of commit history here.

| Member | Commit Message | Feature |
|---|---|---|
| Member 1 | Added user model and CRUD service | User Management |
| Member 2 | Added tutor management pages | Tutor Management |
| Member 3 | Added booking CRUD operations | Booking Management |
| Member 4 | Added payment model and CRUD pages | Payment Management |

## 9. Conclusion

The project demonstrates Java OOP principles, CRUD operations, database handling, and web UI design through a complete home tutor search and booking workflow.
