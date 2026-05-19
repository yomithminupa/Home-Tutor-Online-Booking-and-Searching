<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String title = (String) request.getAttribute("title");
    String message = (String) request.getAttribute("message");

<%-- Fall back to generic error text if the controller didn't
     send a title or message through with the request. --%>
if (title == null || title.isBlank()) {
title = "Error";
}
if (message == null || message.isBlank()) {
message = "Please go back and try again.";
}
%>
<%@ include file="fragments/header.jsp" %>

<section class="page-head">
    <div>
        <h2><%= title %></h2>
        <p class="muted"><%= message %></p>
    </div>
    <a class="btn light" href="/">Dashboard</a>
</section>

<section class="card">
    <h3>What to check</h3>
    <p class="muted">Use unique IDs, complete all required fields, and make sure numeric fields contain valid numbers.</p>
    <div class="actions">
        <button class="btn" type="button" onclick="history.back()">Go Back</button>
        <a class="btn light" href="/">Open Dashboard</a>
    </div>
</section>

<%@ include file="fragments/footer.jsp" %>