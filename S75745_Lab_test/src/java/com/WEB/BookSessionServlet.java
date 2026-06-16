package com.WEB;

import com.DAO.SessionDAO;
import com.Model.SessionBean;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BookSessionServlet extends HttpServlet {

    private SessionDAO sessionDAO;

    public void init() {
        sessionDAO = new SessionDAO();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String student_name =
                request.getParameter("student_name");

        String branch_location =
                request.getParameter("branch_location");

        String lesson_type =
                request.getParameter("lesson_type");

        String status = "Booked";

        SessionBean session = new SessionBean(
                student_name,
                branch_location,
                lesson_type,
                status);

        try {

            sessionDAO.bookSession(session);

            response.sendRedirect("ScheduleServlet");

        } catch (SQLException e) {

            throw new ServletException(e);
        }
    }
}