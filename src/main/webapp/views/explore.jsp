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
        <a href="/project">
            <div id="projectId">
                <br>${project.name}
                <br>${project.description}
                <br>${project.startDate}
                <br>${project.duration} months
            </div>
        </a>
    </c:forEach>

</div>
</body>
</html>
