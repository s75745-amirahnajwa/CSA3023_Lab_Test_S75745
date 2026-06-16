<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Driving Session</title>
</head>
<body>

<h2>Book Session</h2>

<form action="BookSessionServlet" method="post">

    <!-- Student Name -->
    <label>Student Name:</label><br>
    <input type="text" name="student_name" required>
    <br><br>

    <!-- Branch Location Dropdown -->
    <label>Branch Location:</label><br>
    <select name="branch_location" required>
        <option value="">-- Select Branch --</option>
        <option value="Kuala Lumpur">Kuala Lumpur</option>
        <option value="Penang">Penang</option>
        <option value="Johor">Johor</option>
    </select>
    <br><br>

    <!-- Lesson Type Dropdown -->
    <label>Lesson Type:</label><br>
    <select name="lesson_type" required>
        <option value="">-- Select Lesson Type --</option>
        <option value="Manual Car">Manual Car</option>
        <option value="Automatic Car">Automatic Car</option>
        <option value="Motorcycle">Motorcycle</option>
    </select>
    <br><br>

    <button type="submit">Book Session</button>

</form>

</body>
</html>