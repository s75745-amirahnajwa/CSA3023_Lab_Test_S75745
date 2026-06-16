package com.WEB;

import com.DAO.SessionDAO;
import com.Model.SessionBean;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ScheduleServlet extends HttpServlet {

    private SessionDAO sessionDAO;

    public void init() {
        sessionDAO = new SessionDAO();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<SessionBean> list =
                sessionDAO.getAllSessions();

        request.setAttribute("sessionList", list);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("schedule.jsp");

        dispatcher.forward(request, response);
    }
}