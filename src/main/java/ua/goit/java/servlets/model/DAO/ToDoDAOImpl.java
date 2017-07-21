package ua.goit.java.servlets.model.DAO;

import ua.goit.java.servlets.model.entity.ToDo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 21.07.2017.
 */
public class ToDoDAOImpl implements ToDoDAO {

    private static ToDoDAOImpl instance;
    private List<ToDo> toDoList = new ArrayList<>();

    private ToDoDAOImpl() {
    }

    public static ToDoDAOImpl getInstance(){
        if (instance == null){
            instance = new ToDoDAOImpl();
        }
        return instance;
    }

    @Override
    public void addNewTask(ToDo toDo) {
        toDoList.add(toDo);
    }

    @Override
    public void setTaskDone(ToDo toDo) {
        int index = toDoList.indexOf(toDo);
        ToDo toDoTemp = toDoList.get(index);
        toDoTemp.setTaskDone(true);
        toDoList.set(index, toDoTemp);
    }

    @Override
    public void deleteTask(ToDo toDo) {
        toDoList.remove(toDo);
    }

    @Override
    public List<ToDo> getAllTasks() {
        return toDoList;
    }
}
