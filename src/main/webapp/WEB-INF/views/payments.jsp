<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.example.hometutor.model.Payment" %>
<%
    List<Payment> payments = (List<Payment>) request.getAttribute("payments");
    if (payments == null) {
        payments = Collections.emptyList();
    }
    String keyword = (String) request.getAttribute("keyword");
    if (keyword == null) {
        keyword = "";
    }
%>
<%@ include file="fragments/header.jsp" %>

<section class="page-head">
    <div>
        <h2>Payment Management</h2>
        <p class="muted">Record, search, update, and delete booking payments.</p>
    </div>
    <a class="btn" href="/payments/new">Add Payment</a>
</section>

<form class="search" method="get" action="/payments">
    <input type="text" name="keyword" value="<%= keyword %>" placeholder="Search by payment ID, booking ID, user ID, status, or method">
    <button class="btn" type="submit">Search</button>
    <a class="btn light" href="/payments">Clear</a>
</form>

<div class="table-wrap">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Booking</th>
            <th>User</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Status</th>
            <th>Method</th>
            <th>Receipt</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Payment payment : payments) { %>
            <tr>
                <td><%= payment.getId() %></td>
                <td><%= payment.getBookingId() %></td>
                <td><%= payment.getUserId() %></td>
                <td>Rs. <%= payment.getAmount() %></td>
                <td><%= payment.getPaymentDate() %></td>
                <td><span class="pill"><%= payment.getStatus() %></span></td>
                <td><%= payment.getPaymentMethod() %></td>
                <td><%= payment.getReceiptSummary() %></td>
                <td class="actions">
                    <a class="btn light" href="/payments/edit/<%= payment.getId() %>">Edit</a>
                    <a class="btn danger" href="/payments/delete/<%= payment.getId() %>" onclick="return confirm('Delete this payment?')">Delete</a>
                </td>
            </tr>
        <% } %>
        <% if (payments.isEmpty()) { %>
            <tr><td colspan="9">No payments found.</td></tr>
        <% } %>
        </tbody>
    </table>
</div>

<%@ include file="fragments/footer.jsp" %>
