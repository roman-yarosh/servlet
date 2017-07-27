package ua.goit.java.servlets.controller;

import ua.goit.java.servlets.model.dao.ToDoDAO;
import ua.goit.java.servlets.model.dao.impl.ToDoDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Роман on 21.07.2017.
 */
public class SetDone extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ToDoDAO toDoDAO = ToDoDAOImpl.getInstance();
        String errorString = null;

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            errorString = "TO DO id is invalid!";
        }

        if (errorString == null && !toDoDAO.isDoneById(id)) {
            toDoDAO.setTaskDone(id);
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("todoList", toDoDAO.getAllTasks());

        response.sendRedirect(request.getContextPath() + "/todoList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
