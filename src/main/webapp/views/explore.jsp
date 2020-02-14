<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 03.02.2020
  Time: 2:42
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
        <button class="buttons"><a href="/login">Sign in</a></button>
        <button class="buttons"><a href="/registration">Sign up</a></button>
    </div>


    <c:forEach var="project" items="${requestScope.projects}">

        <div id="projectId">
            <a href="/project-detailed">
                <img class="elements" src="${project.urlImage}" height="200px" width="300px">
                <div id="description" class="elements">
                    <p>${project.name}</p>
                    <p>${project.startDate} ~ ${project.duration} weeks</p>
                    <br>
                    <p>${project.country.name}, ${project.city.name}</p>
                </div>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>
