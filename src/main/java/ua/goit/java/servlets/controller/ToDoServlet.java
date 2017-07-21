package ua.goit.java.servlets.controller;

import ua.goit.java.servlets.model.DAO.ToDoDAO;
import ua.goit.java.servlets.model.DAO.ToDoDAOImpl;
import ua.goit.java.servlets.model.entity.ToDo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Роман on 21.07.2017.
 */
public class ToDoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ToDoDAOImpl toDoDAO = ToDoDAOImpl.getInstance();
        List<ToDo> toDoList = toDoDAO.getAllTasks();

        request.setAttribute("todoList", toDoList);

        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/todoListView.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
