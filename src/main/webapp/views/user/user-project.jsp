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
    <script src="https://kit.fontawesome.com/1f2726afb8.js" crossorigin="anonymous"></script>
</head>
<body>
<div id="projectId">

    <%--    <img src="${requestScope.admin_projects.urlImage}">--%>
    <div id="headerPhoto">
        <img src="${requestScope.project.urlImage}">
        <button class="buttons"><a href="/logout">Log out</a></button>
        <button class="buttons"><a href="/user/explore">Explore</a></button>
        <button id="applyButton"><a id="a" href="/user/explore/project/apply">Apply Now</a></button>
        <div id="location">
            <span id="projectName">${requestScope.project.name}</span>
            <br>
            <span class="loc"><i class="fas fa-map-marker-alt"></i></span>
            <span class="loc">${requestScope.project.country.name}</span>
        </div>
    </div>

    <div class="prerequisites">
        <h1>Backgrounds</h1>
    </div>

    <div class="prerequisites">
        <h1>Skills</h1>
    </div>

    <div class="prerequisites">
        <h1>Languages</h1>
    </div>

</div>
</body>
</html>
