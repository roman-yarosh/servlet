<%@ page import="java.util.Enumeration" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>HTTP Header Request Example</title>
</head>
<body>
<h2>HTTP Header Request Example</h2>
<table width="100%" border="1" align="center">
    <tr bgcolor="#949494">
        <th>Header name</th>
        <th>Header value</th>
    </tr>
    <c:forEach items="${headerValues.keySet()}" var="headerName">
        <tr>
            <td><c:out value="${headerName}"</td>
            <td><c:out value="${param.get(headerName)}"</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>