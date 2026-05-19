## Member 1: Introduction, Technologies, and Architecture

Good morning sir/madam. Our project is a **Home Tutor Search and Booking System**. This system was developed to help manage private tutoring services through one centralized platform.

The main users of the system are administrators, students, and tutors. Through this system, administrators can manage users, tutors, subjects, bookings, payments, and reviews.

We developed this project using **Java, Spring Boot, JSP, Spring Data JPA, and H2 database**. Spring Boot was used for backend development, JSP was used for the user interface, and Spring Data JPA was used to connect with the database.

Our system follows the **MVC layered architecture**. JSP pages are used as the view layer, controllers handle requests, services contain business logic, repositories handle database operations, and model classes represent the database entities.

The main flow of the system is:

```text
JSP Pages -> Controllers -> Services -> Repositories -> Database
```

We also added an **admin login portal**, so only authorized admin users can access the management pages.

## Member 2: User Management

Now I will explain the **User Management module**.

This module is used to manage the users of the system. We have two main types of users: **StudentUser** and **AdminUser**. Both of these classes inherit from the abstract `User` class.

The `User` class contains common details such as ID, name, email, phone number, and password. The subclasses contain details specific to each user type.

This module demonstrates important OOP concepts such as **inheritance, abstraction, and encapsulation**. Encapsulation is used because the fields are private and accessed through getters and setters.

The admin can create, view, update, search, and delete user records through the JSP interface.

## Member 3: Tutor Management

Next, I will explain the **Tutor Management module**.

This module manages tutor profiles. A tutor has details such as name, subject, hourly rate, availability, and tutor type.

We have two types of tutors: **OnlineTutor** and **HomeVisitTutor**. These classes inherit from the abstract `Tutor` class.

The `OnlineTutor` class stores the online platform, such as Zoom or Google Meet. The `HomeVisitTutor` class stores the travel fee.

This module demonstrates **polymorphism** using the `calculateSessionFee()` method. For online tutors, the fee is calculated based on the normal hourly rate. For home visit tutors, the travel fee is also added.

So, the same method behaves differently depending on the tutor type.

## Member 4: Subject Management

Now I will explain the **Subject Management module**.

This module stores the subjects available in the system. We divided subjects into two types: **AcademicSubject** and **SkillSubject**.

Academic subjects can include school-related subjects such as Mathematics, Science, or English. Skill subjects can include areas such as music, art, or programming.

Both subject types inherit from the abstract `Subject` class. This helps us avoid code duplication and organize subjects clearly.

The admin can add new subjects, update subject details, search subjects, view all subjects, and delete subjects.

## Member 5: Booking Management

Next, I will explain the **Booking Management module**.

This module is used to manage tutor session bookings. A booking includes the selected student, tutor, subject, date, time, location, session type, and booking status.

To make the booking process easier, we added dropdown selections for users, tutors, subjects, and locations. This reduces typing mistakes and improves usability.

For example, instead of manually typing a tutor name, the admin can select the tutor from a dropdown list.

The booking module also follows CRUD operations. The admin can create, view, update, search, and delete bookings.

## Member 6: Payment, Review, and Conclusion

Now I will explain the **Payment and Review modules**.

The Payment module is used to record payment details for bookings. We support two payment types: **CardPayment** and **CashPayment**.

`CardPayment` stores details such as card holder name, masked card number, and authorization code. `CashPayment` stores collected by and receipt number.

This module demonstrates inheritance and polymorphism because both payment types inherit from the abstract `Payment` class and implement payment-specific behavior.

The Review module stores tutor feedback and ratings. We have two review types: **PublicReview** and **VerifiedReview**. Public reviews use a nickname, while verified reviews are connected to a booking ID.

Overall, our project successfully demonstrates Java OOP concepts such as **encapsulation, inheritance, polymorphism, abstraction, interfaces, and information hiding**.

We also implemented CRUD operations, database handling, an admin login portal, and a user-friendly JSP interface.

In conclusion, the Home Tutor Search and Booking System shows how Java OOP concepts can be used to build a practical real-world web application.

Thank you.

## Short Viva Closing Answer

If the examiner asks, "What is the main purpose of your project?", you can say:

```text
Our main purpose is to provide a centralized platform to manage home tutoring services. The system allows administrators to manage students, tutors, subjects, bookings, payments, and reviews efficiently using a Java Spring Boot web application.
```
