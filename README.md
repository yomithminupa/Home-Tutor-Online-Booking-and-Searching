## Home Tutor Search and Booking System

SE1020 Object Oriented Programming project built with Java, Spring Boot, JSP pages, and SQL database storage.

## Main Features

- User management with create, read/search, update, and delete.
- Tutor management with create, read/search, update, and delete.
- Subject management with create, read/search, update, and delete.
- Booking management with create, read/search, update, and delete/cancel.
- Payment management with create, read/search, update, and delete.
- Review management with create, read/search, update, and delete.
- SQL database storage using Spring Data JPA.
- Embedded H2 database runs by default, with MySQL settings included in `application.properties`.

## OOP Concepts Used

- Encapsulation: model fields are private and accessed using getters/setters.
- Inheritance: `StudentUser`, `ParentUser`, and `AdminUser` inherit from `User`; tutor, subject, payment, and review types also use inheritance.
- Polymorphism: subclasses override methods such as `displayProfile()`, `calculateSessionFee()`, `getPaymentMethod()`, and `displayReview()`.
- Abstraction: common CRUD behavior is handled by `AbstractCrudService` and Spring Data repositories.
- Information hiding: controllers call service methods without directly handling database logic.

## How To Run In IntelliJ IDEA

1. Open this folder as a Maven project.
2. Make sure the project SDK is Java 17 or newer.
3. Wait for Maven dependencies to load.
4. Run `HomeTutorApplication.java`.
5. Open `http://localhost:8080`.
6. Optional database console: open `http://localhost:8080/h2-console`.

## H2 Database Login

```text
JDBC URL: jdbc:h2:file:./database/home_tutor_db
User Name: sliit
Password: sliitdb
```

## MySQL Setup Option

Create a MySQL database:

```sql
CREATE DATABASE home_tutor_db;
```

Then edit `src/main/resources/application.properties` and replace the H2 datasource settings with:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/home_tutor_db
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=your_mysql_password
```

## Sample Data

Sample records are inserted automatically by `DataInitializer.java` when the database is empty.

## Backend Files Included

The backend is implemented under `src/main/java/com/example/hometutor`:

- `model`: OOP entity classes with inheritance and polymorphic methods.
- `repository`: Spring Data JPA repositories.
- `service`: CRUD business logic and search methods.
- `controller`: JSP page controllers, API controller, dashboard controller, and global error handler.
- `config`: web configuration and sample data initializer.

## Useful Backend API Endpoints

These JSON endpoints are included for quick backend testing:

```text
GET /api/summary
GET /api/tutors
GET /api/bookings
```
