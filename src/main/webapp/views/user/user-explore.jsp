<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 15.02.2020
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Volunteer2Travel</title>

    <link rel="stylesheet" href="/static/css/explore.css" type="text/css"
          media="all">
</head>
<body>
<div id="main">
    <div id="headerPhoto">
        <img id="header">
        <button class="buttons"><a href="/logout">Log out</a></button>
        <button class="buttons"><a href="/user/profile">Profile</a></button>
    </div>


    <c:forEach var="project" items="${requestScope.projects}">

        <div id="projectId">
            <img class="elements" src="${project.urlImage}" height="200px" width="300px">
            <div id="description" class="elements">
                <pre>${project.name}</pre>
                <pre>${project.startDate} ~ ${project.duration} weeks</pre>
                <br>
                <pre>${project.country.name}, ${project.city.name}</pre>
            </div>
            <form class="elements" method="get" action="/user/explore/project">
                <input type="number" hidden name="id" value="${project.id}"/>
                <input type="submit" value="Detailed"/>
            </form>
        </div>
    </c:forEach>

</div>
</body>
</html>
