# Project Structure

This folder is organized as a complete Java Spring Boot OOP project.

## Main Project Files

| Path | Purpose |
|---|---|
| `pom.xml` | Maven build file. Defines Spring Boot, JSP, JPA, H2, and MySQL dependencies. |
| `README.md` | Main project instructions and feature summary. |
| `docs/class-diagram.md` | Mermaid class diagram for the OOP model. |
| `docs/final-report-template.md` | Final report content for submission. |

## Backend

Backend code is available in:

```text
src/main/java/com/example/hometutor
```

Backend packages:

| Package | Purpose |
|---|---|
| `config` | Web configuration and sample data initializer. |
| `controller` | Page controllers, API controller, dashboard controller, and error handler. |
| `model` | OOP entity classes such as User, Tutor, Subject, Booking, Payment, and Review. |
| `repository` | Spring Data JPA database repositories. |
| `service` | CRUD logic, search logic, and object creation methods. |

Main backend start file:

```text
src/main/java/com/example/hometutor/HomeTutorApplication.java
```

## Frontend

JSP frontend pages are available in:

```text
src/main/webapp/WEB-INF/views
```

Available pages:

| Page | Purpose |
|---|---|
| `index.jsp` | Dashboard. |
| `users.jsp`, `user-form.jsp` | User management. |
| `tutors.jsp`, `tutor-form.jsp` | Tutor management. |
| `subjects.jsp`, `subject-form.jsp` | Subject management. |
| `bookings.jsp`, `booking-form.jsp` | Booking management. |
| `payments.jsp`, `payment-form.jsp` | Payment management. |
| `reviews.jsp`, `review-form.jsp` | Review management. |
| `error.jsp` | Friendly error page. |

CSS is available in:

```text
src/main/resources/static/css/style.css
```

## Database

Database configuration is available in:

```text
src/main/resources/application.properties
```

The project uses embedded H2 by default:

```text
jdbc:h2:file:./database/home_tutor_db
```

H2 login:

```text
User Name: sliit
Password: sliitdb
```

When the app runs, H2 database files will be created in:

```text
database/
```

Sample data is inserted from:

```text
src/main/java/com/example/hometutor/config/DataInitializer.java
```

Tables used by the project:

```text
app_users
tutors
subjects
bookings
payments
reviews
```

## API Endpoints

Simple JSON endpoints are available:

```text
GET /api/summary
GET /api/tutors
GET /api/bookings
```

## Archive

The older Node.js version is preserved in:

```text
_archive/previous-node-version-20260513-181946
```

It is not part of the current Spring Boot submission project.
