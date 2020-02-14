<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 13.02.2020
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/admin/admin-project.css" type="text/css" media="all">
</head>
<body>
<div id="projects">
    <c:forEach var="project" items="${requestScope.admin_projects}">
        <div id="projectId">
            <br>${project.name}
            <br>${project.description}
            <br>${project.startDate}
            <br>${project.duration} months
            <br>${project.country.name}
            <br>${project.city.name}

            <form method="get" action="/admin-page/update-project">
                <input type="number" hidden name="id" value="${project.id}"/>
                <input type="submit" value="Edit"/>
            </form>

            <form method="post" action="/admin-page/delete-project">
                <input type="number" hidden name="id" value="${project.id}"/>
                <input type="submit" name="delete" value="Delete"/>
            </form>
        </div>
    </c:forEach>
</div>

</body>
</html>
