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
    <style>
        #projectId {
            height: 100px;
            margin: 20px;
            background-color: #ffe100;
        }

        #headerPhoto {
            width: 100%;
            height: 200px;
            background-image: url("/static/images/explore_header.jpg");
        }
    </style>
    <link rel="stylesheet" href="/static/css/explore.css" type="text/css"
          media="all">
</head>
<body>
<div id="main">
    <a href="/">Home</a>
    <a href="/login">Sign in</a>
    <a href="/project">Choose the project</a>

    <div id="headerPhoto"></div>

    <c:forEach var="project" items="${requestScope.projects}">
        <div id="projectId">${project.name}
            <br>${project.description}
            <br>${project.startDate}
            <br>${project.duration} months
        </div>
    </c:forEach>

</div>
</body>
</html>
