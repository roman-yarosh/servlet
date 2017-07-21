package ua.goit.java.servlets.model.entity;

import java.util.Date;

/**
 * Created by Роман on 21.07.2017.
 */
public class ToDo {

    private String id;
    private String task;
    private Date taskDate;
    private boolean taskDone;

    public ToDo() {
        this.taskDate = new Date();
        this.taskDone = false;
    }

    public ToDo(String id, String task) {
        this.id = id;
        this.task = task;
        this.taskDate = new Date();
        this.taskDone = false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ToDo{");
        sb.append("id=").append(id);
        sb.append(", task='").append(task).append('\'');
        sb.append(", taskDate=").append(taskDate);
        sb.append(", taskDone=").append(taskDone);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public boolean isTaskDone() {
        return taskDone;
    }

    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }
}
