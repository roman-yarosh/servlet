package ua.goit.java.servlets.model.DAO;

import ua.goit.java.servlets.model.entity.ToDo;

import java.util.List;

/**
 * Created by Роман on 21.07.2017.
 */
public interface ToDoDAO {

    void addNewTask(ToDo toDo);

    void setTaskDone(ToDo toDo);

    void deleteTask(ToDo toDo);

    List<ToDo> getAllTasks();
}
