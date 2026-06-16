<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>DriveSmart Academy - Home</title>

    <style>
        .menu {
            margin-top: 30px;
            text-align: center;
        }

        .menu a {
            display: inline-block;
            margin: 10px;
            padding: 12px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .menu a:hover {
            background-color: #2980b9;
        }
    </style>
</head>

<body>

<!-- HEADER INCLUDE -->
<%@ include file="header.html" %>

<!-- MAIN CONTENT -->
<div class="menu">

    <h2>Welcome to DriveSmart Academy System</h2>

    <a href="book_session.jsp">Book Training Session</a>

    <a href="ScheduleServlet">View Schedule Dashboard</a>

</div>

<!-- FOOTER INCLUDE -->
<%@ include file="footer.jsp" %>

</body>
</html>