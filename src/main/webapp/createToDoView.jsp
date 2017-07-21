<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Create new task</title>
</head>
<body>
<h3>Create new task</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="doCreateToDo">
    <table border="0">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="${todo.id}" /></td>
        </tr>
        <tr>
            <td>Task</td>
            <td><input type="text" name="task" value="${todo.task}" /></td>
       </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />&nbsp;
                <a href="todoList">Cancel</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
