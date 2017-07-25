package ua.goit.java.servlets.controller;

import ua.goit.java.servlets.model.dao.ToDoDAO;
import ua.goit.java.servlets.model.dao.impl.ToDoDAOImpl;
import ua.goit.java.servlets.model.entity.ToDo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Роман on 21.07.2017.
 */
public class DoCreateToDoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ToDoDAO toDoDAO = ToDoDAOImpl.getInstance();

        String id = (String) request.getParameter("id");
        String task = (String) request.getParameter("task");

        ToDo toDo = new ToDo(id, task);

        String errorString = null;

        if (id == null || id.isEmpty()) {
            errorString = "TO DO id is invalid!";
        }

        if (errorString == null) {
            toDoDAO.addNewTask(toDo);
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("todo", toDo);
        request.setAttribute("todoList", toDoDAO.getAllTasks());

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/createToDoView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/todoList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
