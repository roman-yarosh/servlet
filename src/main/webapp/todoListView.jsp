<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>TO DO List</title>
</head>
<body>

<h3>TO DO List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>ID</th>
        <th>Task</th>
        <th>Task date</th>
        <th>Done</th>
        <th>Set task done</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${todoList}" var="todo" >
        <tr>
            <td>${todo.id}</td>
            <td>${todo.task}</td>
            <td>${todo.taskDate}</td>
            <td>${todo.taskDone}</td>
            <td>
                <c:if test="${todo.taskDone == false}">
                    <a href="setDone?id=${todo.id}">Set task done</a>
                </c:if>
            </td>
            <td>
                <c:if test="${todo.taskDone == true}">
                    <a href="deleteToDo?id=${todo.id}">Delete task</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="createToDo">Create new task</a>

</body>
</html>