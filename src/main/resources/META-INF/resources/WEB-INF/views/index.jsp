<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Safely extract dashboard counts from request attributes with 0 as fallback --%>
<%
    int userCount = request.getAttribute("userCount") == null ? 0 : (Integer) request.getAttribute("userCount");
    int tutorCount = request.getAttribute("tutorCount") == null ? 0 : (Integer) request.getAttribute("tutorCount");
    int subjectCount = request.getAttribute("subjectCount") == null ? 0 : (Integer) request.getAttribute("subjectCount");
    int bookingCount = request.getAttribute("bookingCount") == null ? 0 : (Integer) request.getAttribute("bookingCount");
    int paymentCount = request.getAttribute("paymentCount") == null ? 0 : (Integer) request.getAttribute("paymentCount");
    int reviewCount = request.getAttribute("reviewCount") == null ? 0 : (Integer) request.getAttribute("reviewCount");
%>
<%@ include file="fragments/header.jsp" %>
<%-- Page header section with title, subtitle, and quick-action buttons --%>
<section class="page-head">
    <div>
        <h2>Dashboard</h2>
        <p class="muted">Manage tutors, students, subjects, bookings, payments, and tutor reviews.</p>
    </div>
    <div class="actions">
        <a class="btn" href="/bookings/new">New Booking</a>
        <a class="btn secondary" href="/payments/new">New Payment</a>
    </div>
</section>
<%-- Stat cards grid: each card shows a module count and a navigation link --%>
<section class="grid">
    <article class="card">
        <div class="muted">Registered Users</div>
        <div class="stat"><%= userCount %></div>
        <a class="btn light" href="/users">Open Users</a>
    </article>
    <article class="card">
        <div class="muted">Available Tutors</div>
        <div class="stat"><%= tutorCount %></div>
        <a class="btn light" href="/tutors">Open Tutors</a>
    </article>
    <article class="card">
        <div class="muted">Subjects</div>
        <div class="stat"><%= subjectCount %></div>
        <a class="btn light" href="/subjects">Open Subjects</a>
    </article>
    <article class="card">
        <div class="muted">Bookings</div>
        <div class="stat"><%= bookingCount %></div>
        <a class="btn light" href="/bookings">Open Bookings</a>
    </article>
    <article class="card">
        <div class="muted">Payments</div>
        <div class="stat"><%= paymentCount %></div>
        <a class="btn light" href="/payments">Open Payments</a>
    </article>
    <article class="card">
        <div class="muted">Reviews</div>
        <div class="stat"><%= reviewCount %></div>
        <a class="btn light" href="/reviews">Open Reviews</a>
    </article>
</section>

<section class="card" style="margin-top: 18px;">
    <h3>Project Modules</h3>
    <p class="muted">Each module uses controller classes for web requests, service classes for business logic, model classes for OOP, and database tables for storage.</p>
    <div class="grid">
        <div>
            <strong>User Management</strong>
            <p class="muted">Register, search, update, and delete students, parents, and admins.</p>
        </div>
        <div>
            <strong>Lesson Management</strong>
            <p class="muted">Manage academic and skill-based lesson subjects.</p>
        </div>
        <div>
            <strong>Booking System</strong>
            <p class="muted">Create, view, update, and cancel tutoring sessions.</p>
        </div>
        <div>
            <strong>Payment Management</strong>
            <p class="muted">Record card and cash payments for bookings.</p>
        </div>
        <div>
            <strong>Review System</strong>
            <p class="muted">Collect public and verified tutor reviews.</p>
        </div>
        <div>
            <strong>Admin Dashboard</strong>
            <p class="muted">Show system counts and quick links for all modules.</p>
        </div>
    </div>
</section>

<%@ include file="fragments/footer.jsp" %>
