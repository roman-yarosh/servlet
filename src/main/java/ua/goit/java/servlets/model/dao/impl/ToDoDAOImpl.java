package ua.goit.java.servlets.model.dao.impl;

import ua.goit.java.servlets.model.dao.ToDoDAO;
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
    public void setTaskDone(String id) {
        if (id != null && id.length() > 0){
            for (int i = 0; i < toDoList.size(); i++) {
                if (id.equals(toDoList.get(i).getId())) {
                    ToDo toDo = toDoList.get(i);
                    toDo.setTaskDone(true);
                    toDoList.set(i,toDo);
                    break;
                }
            }
        }
    }

    @Override
    public void deleteTask(String id) {
        if (id != null && id.length() > 0){
            for (int i = 0; i < toDoList.size(); i++) {
                if (id.equals(toDoList.get(i).getId())) {
                    toDoList.remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public List<ToDo> getAllTasks() {
        return toDoList;
    }

    @Override
    public boolean isDoneById(String id) {
        ToDo toDo;
        if (id != null && id.length() > 0){
            for (int i = 0; i < toDoList.size(); i++) {
                toDo = toDoList.get(i);
                if (id.equals(toDo.getId())) {
                    return toDo.isTaskDone();
                }
            }
        }
        return false;
    }
}
