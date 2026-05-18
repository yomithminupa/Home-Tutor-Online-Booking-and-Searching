<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.hometutor.model.Payment, com.example.hometutor.model.CardPayment, com.example.hometutor.model.CashPayment" %>
<%
    Payment payment = (Payment) request.getAttribute("payment");
    boolean editMode = payment != null;
    String action = editMode ? "/payments/edit/" + payment.getId() : "/payments";
<%-- Pull payment type and any subclass fields out early so the form
     below doesn't get cluttered with logic. Defaults to empty string
     so nothing blows up if the field doesn't apply. --%>
    String paymentType = payment instanceof CashPayment ? "CASH" : "CARD";
    String cardHolderName = payment instanceof CardPayment ? ((CardPayment) payment).getCardHolderName() : "";
    String maskedCardNumber = payment instanceof CardPayment ? ((CardPayment) payment).getMaskedCardNumber() : "";
    String authorizationCode = payment instanceof CardPayment ? ((CardPayment) payment).getAuthorizationCode() : "";
    String collectedBy = payment instanceof CashPayment ? ((CashPayment) payment).getCollectedBy() : "";
    String receiptNumber = payment instanceof CashPayment ? ((CashPayment) payment).getReceiptNumber() : "";
%>
<%@ include file="fragments/header.jsp" %>

<section class="page-head">
    <div>
        <%-- Toggle form title and POST action URL between create and edit mode --%>
        <h2><%= editMode ? "Update Payment" : "Add Payment" %></h2>
        <p class="muted">Use card or cash payment details for a booking.</p>
    </div>
</section>

<form class="form-card" method="post" action="<%= action %>">
    <%-- Payment ID is only shown in create mode; in edit mode the ID is fixed and not editable --%>
    <% if (!editMode) { %>
    <label>Payment ID
        <input type="text" name="id" required placeholder="P001">
    </label>
    <% } %>

    <label>Booking ID
        <input type="text" name="bookingId" required value="<%= editMode ? payment.getBookingId() : "" %>" placeholder="B001">
    </label>

    <label>User ID
        <input type="text" name="userId" required value="<%= editMode ? payment.getUserId() : "" %>" placeholder="U001">
    </label>

    <label>Amount
        <input type="number" step="0.01" name="amount" required value="<%= editMode ? payment.getAmount() : "" %>" placeholder="1500">
    </label>

    <label>Payment Date
        <input type="date" name="paymentDate" required value="<%= editMode ? payment.getPaymentDate() : "" %>">
    </label>

    <label>Status
        <select name="status">
            <%-- Conditionally pre-select the correct status option based on the existing payment record --%>
            <option value="PENDING" <%= editMode && "PENDING".equals(payment.getStatus()) ? "selected" : "" %>>Pending</option>
            <option value="PAID" <%= editMode && "PAID".equals(payment.getStatus()) ? "selected" : "" %>>Paid</option>
            <option value="FAILED" <%= editMode && "FAILED".equals(payment.getStatus()) ? "selected" : "" %>>Failed</option>
            <option value="REFUNDED" <%= editMode && "REFUNDED".equals(payment.getStatus()) ? "selected" : "" %>>Refunded</option>
        </select>
    </label>

    <label>Payment Type
        <select name="paymentType">
            <option value="CARD" <%= "CARD".equals(paymentType) ? "selected" : "" %>>Card Payment</option>
            <option value="CASH" <%= "CASH".equals(paymentType) ? "selected" : "" %>>Cash Payment</option>
        </select>
    </label>
        <%-- card and  cash fields are always shown on the form together.
       Making sure only the relevant ones are filled in is handled on the backend. --%>
    <label>Card Holder Name
        <input type="text" name="cardHolderName" value="<%= cardHolderName %>" placeholder="Only for card payments">
    </label>

    <label>Masked Card Number
        <input type="text" name="maskedCardNumber" value="<%= maskedCardNumber %>" placeholder="**** **** **** 1234">
    </label>

    <label>Authorization Code
        <input type="text" name="authorizationCode" value="<%= authorizationCode %>" placeholder="AUTH123">
    </label>

    <label>Collected By
        <input type="text" name="collectedBy" value="<%= collectedBy %>" placeholder="Only for cash payments">
    </label>

    <label>Receipt Number
        <input type="text" name="receiptNumber" value="<%= receiptNumber %>" placeholder="REC001">
    </label>

    <div class="actions">
        <button class="btn" type="submit"><%= editMode ? "Update" : "Create" %></button>
        <a class="btn light" href="/payments">Cancel</a>
    </div>
</form>

<%@ include file="fragments/footer.jsp" %>
