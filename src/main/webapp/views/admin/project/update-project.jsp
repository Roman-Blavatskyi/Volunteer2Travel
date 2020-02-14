<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 13.02.2020
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/admin/update-project.css" type="text/css" media="all">
</head>
<body>
<form id="updateForm" action="/admin-page/update-project" method="post">

    <input name="id" type="number" placeholder="Id" value="${requestScope.project.id}">
    <br>
    <input name="name" type="text" placeholder="Project name" value="${requestScope.project.name}">
    <br>
    <input name="description" type="text" placeholder="Description"
           value="${requestScope.project.description}">
    <br>
    <input name="startDate" type="date" placeholder="Start date"
           value="${requestScope.project.startDate}">
    <br>
    <input name="duration" type="number" placeholder="Duration" value="${requestScope.project.duration}">
    <br>
    <input name="urlImage" type="text" placeholder="Image url"
           value="${requestScope.project.urlImage}">
    <br>
    <input name="country" type="text" placeholder="Country"
           value="${requestScope.project.country.name}">
    <br>
    <input name="city" type="text" placeholder="City" value="${requestScope.project.city.name}">
    <br>
    <button type="submit">Edit</button>
</form>
</body>
</html>
