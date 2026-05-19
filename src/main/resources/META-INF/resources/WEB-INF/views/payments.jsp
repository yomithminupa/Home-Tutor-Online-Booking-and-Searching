<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.example.hometutor.model.Payment" %>

<%-- Grab the payments list from the request. If nothing came through,
     just use an empty list so the page doesn't crash --%>
<%
    List<Payment> payments = (List<Payment>) request.getAttribute("payments");
    if (payments == null) {
        payments = Collections.emptyList();
    }

<%-- Keep the search box filled with whatever the user typed last.
     Defaults to empty string so the placeholder shows on a fresh load. --%>
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

        <%-- Loop through each payment and build a table row.
             receiptSummary handles the difference between card and cash automatically. --%>
        <% for (Payment payment : payments) { %>
        <tr>
            <td><%= payment.getId() %></td>
            <td><%= payment.getBookingId() %></td>
            <td><%= payment.getUserId() %></td>
            <td>Rs. <%= payment.getAmount() %></td>
            <td><%= payment.getPaymentDate() %></td>

            <%-- Wrap the  status in a pill badge so it's easier to read at a glance. --%>
            <td><span class="pill"><%= payment.getStatus() %></span></td>

            <td><%= payment.getPaymentMethod() %></td>
            <td><%= payment.getReceiptSummary() %></td>
            <td class="actions">
                <a class="btn light" href="/payments/edit/<%= payment.getId() %>">Edit</a>

                <%-- Show  a confirm dialog before deleting so nobody wipes a payment by accident. --%>
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