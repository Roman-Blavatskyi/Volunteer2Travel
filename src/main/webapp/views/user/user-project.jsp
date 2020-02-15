<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 15.02.2020
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/project.css" type="text/css"/>
</head>
<body>
<div id="projectId">

    <%--    <img src="${requestScope.admin_projects.urlImage}">--%>
    <div id="headerPhoto">
        <button class="buttons"><a href="/logout">Log out</a></button>
        <button class="buttons"><a href="/user/explore">Explore</a></button>
    </div>
    <div id="description">
        <c:out value="${requestScope.admin_project.name}"/>
    </div>

</div>
</body>
</html>
