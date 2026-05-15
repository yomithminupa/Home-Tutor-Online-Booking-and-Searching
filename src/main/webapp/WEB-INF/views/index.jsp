<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    int userCount = request.getAttribute("userCount") == null ? 0 : (Integer) request.getAttribute("userCount");
    int tutorCount = request.getAttribute("tutorCount") == null ? 0 : (Integer) request.getAttribute("tutorCount");
    int subjectCount = request.getAttribute("subjectCount") == null ? 0 : (Integer) request.getAttribute("subjectCount");
    int bookingCount = request.getAttribute("bookingCount") == null ? 0 : (Integer) request.getAttribute("bookingCount");
    int paymentCount = request.getAttribute("paymentCount") == null ? 0 : (Integer) request.getAttribute("paymentCount");
    int reviewCount = request.getAttribute("reviewCount") == null ? 0 : (Integer) request.getAttribute("reviewCount");
%>
<%@ include file="fragments/header.jsp" %>

<section class="hero-panel">
    <div>
        <span class="hero-chip">✨ SLIIT OOP Project</span>
        <h2>Home Tutor Dashboard</h2>
        <p>Find tutors, schedule lessons, handle payments, and collect feedback from one clean workspace.</p>
    </div>
    <div class="hero-actions">
        <a class="btn" href="/bookings/new">📅 New Booking</a>
        <a class="btn secondary" href="/payments/new">💳 New Payment</a>
    </div>
</section>

<section class="dashboard-grid">
    <article class="stat-card users-card">
        <div class="stat-icon">👥</div>
        <div class="muted">Registered Users</div>
        <div class="stat"><%= userCount %></div>
        <a class="btn light" href="/users">Open</a>
    </article>
    <article class="stat-card tutors-card">
        <div class="stat-icon">👩‍🏫</div>
        <div class="muted">Available Tutors</div>
        <div class="stat"><%= tutorCount %></div>
        <a class="btn light" href="/tutors">Open</a>
    </article>
    <article class="stat-card subjects-card">
        <div class="stat-icon">📚</div>
        <div class="muted">Subjects</div>
        <div class="stat"><%= subjectCount %></div>
        <a class="btn light" href="/subjects">Open</a>
    </article>
    <article class="stat-card bookings-card">
        <div class="stat-icon">📅</div>
        <div class="muted">Bookings</div>
        <div class="stat"><%= bookingCount %></div>
        <a class="btn light" href="/bookings">Open</a>
    </article>
    <article class="stat-card payments-card">
        <div class="stat-icon">💳</div>
        <div class="muted">Payments</div>
        <div class="stat"><%= paymentCount %></div>
        <a class="btn light" href="/payments">Open</a>
    </article>
    <article class="stat-card reviews-card">
        <div class="stat-icon">⭐</div>
        <div class="muted">Reviews</div>
        <div class="stat"><%= reviewCount %></div>
        <a class="btn light" href="/reviews">Open</a>
    </article>
</section>

<%@ include file="fragments/footer.jsp" %>
