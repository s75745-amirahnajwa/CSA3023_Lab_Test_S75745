<%@ page import="java.util.List" %>
<%@ page import="com.Model.SessionBean" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Training Schedule</title>
</head>
<body>

<h2>Centralized Training Schedule</h2>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Student Name</th>
        <th>Branch Location</th>
        <th>Lesson Type</th>
        <th>Status</th>
    </tr>

<%
    List<SessionBean> sessionList =
        (List<SessionBean>) request.getAttribute("sessionList");

    if (sessionList != null) {
        for (SessionBean s : sessionList) {
%>

    <tr>
        <td><%= s.getSessionId() %></td>
        <td><%= s.getStudentName() %></td>
        <td><%= s.getBranchLocation() %></td>
        <td><%= s.getLessonType() %></td>
        <td><%= s.getStatus() %></td>
    </tr>

<%
        }
    }
%>

</table>

</body>
</html>