<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 06.02.2020
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/project.css" type="text/css"/>
    <script src="https://kit.fontawesome.com/1f2726afb8.js" crossorigin="anonymous"></script>
</head>
<body>
<div id="projectId">

    <%--    <img src="${requestScope.admin_projects.urlImage}">--%>
    <div id="headerPhoto">
        <img src="${requestScope.project.urlImage}">
        <button class="buttons"><a href="/registration">Sign up</a></button>
        <button class="buttons"><a href="/explore">Explore</a></button>
        <button id="applyButton"><a id="a" href="/user/apply">Apply Now</a></button>
        <div id="location">
            <span id="projectName">${requestScope.project.name}</span>
            <br>
            <span class="loc"><i class="fas fa-map-marker-alt"></i></span>
            <span class="loc">${requestScope.project.country.name}</span>
        </div>
    </div>

    <div class="prerequisites">
        <h1>Backgrounds</h1>
        <ul>
            <c:forEach var="background" items="${requestScope.backgrounds}">
                <li>${background.name}</li>
            </c:forEach>
        </ul>
    </div>

    <div class="prerequisites">
        <h1>Skills</h1>
        <ul>
            <c:forEach var="skill" items="${requestScope.skills}">
                <li>${skill.name}</li>
            </c:forEach>
        </ul>
    </div>

    <div class="prerequisites">
        <h1>Languages</h1>
        <ul>
            <c:forEach var="language" items="${requestScope.languages}">
                <li>${language.name}</li>
            </c:forEach>
        </ul>
    </div>

</div>
</body>
</html>
