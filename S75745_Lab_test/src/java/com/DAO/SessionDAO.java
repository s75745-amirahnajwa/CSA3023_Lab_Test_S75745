package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Model.SessionBean;

public class SessionDAO {

    Connection connection = null;
    private String jdbcURL = "jdbc:mysql://localhost:3306/drivesmart_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_SESSION_SQL =
            "INSERT INTO Training_Sessions " +
            "(student_name, branch_location, lesson_type, status) " +
            "VALUES (?, ?, ?, ?);";

    private static final String SELECT_ALL_SESSIONS =
            "SELECT * FROM Training_Sessions " +
            "ORDER BY branch_location ASC";

    public SessionDAO() {
    }

    // Connection Method
    protected Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    jdbcURL,
                    jdbcUsername,
                    jdbcPassword);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    // Insert Method
    public void bookSession(SessionBean session)
            throws SQLException {

        System.out.println(INSERT_SESSION_SQL);

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_SESSION_SQL)) {

            preparedStatement.setString(1, session.getStudentName());
            preparedStatement.setString(2, session.getBranchLocation());
            preparedStatement.setString(3, session.getLessonType());
            preparedStatement.setString(4, session.getStatus());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Retrieve Method
    public List<SessionBean> getAllSessions() {

        List<SessionBean> sessions = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             SELECT_ALL_SESSIONS)) {

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int session_id =
                        rs.getInt("session_id");

                String student_name =
                        rs.getString("student_name");

                String branch_location =
                        rs.getString("branch_location");

                String lesson_type =
                        rs.getString("lesson_type");

                String status =
                        rs.getString("status");

                sessions.add(
                        new SessionBean(
                                session_id,
                                student_name,
                                branch_location,
                                lesson_type,
                                status));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        return sessions;
    }

    private void printSQLException(SQLException ex) {

        for (Throwable e : ex) {

            if (e instanceof SQLException) {

                e.printStackTrace(System.err);

                System.err.println(
                        "SQLState: "
                        + ((SQLException) e).getSQLState());

                System.err.println(
                        "Error Code: "
                        + ((SQLException) e).getErrorCode());

                System.err.println(
                        "Message: "
                        + e.getMessage());

                Throwable t = ex.getCause();

                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}