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
</head>
<body>
<a href="/">Home</a>
<a href="/explore">Explore</a>
<div id="projectId">

    <br>${project.name}
    <br>${project.description}
    <br>${project.startDate}
    <br>${project.duration} months
</div>
</body>
</html>
