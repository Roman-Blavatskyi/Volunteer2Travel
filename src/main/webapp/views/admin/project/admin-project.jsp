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
<div id="header">
    <button class="buttons"><a href="/admin-page">Panel</a></button>
</div>
<a href="/admin-page/create-project"><div id = "addProject">Create project</div></a>

<div id="projects">
    <c:forEach var="project" items="${requestScope.admin_projects}">
        <div id="projectId">

            <img class="elements" src="${project.urlImage}" height="200px" width="300px">
            <div id="description" class="elements">
                <p>${project.name}</p>
                <p>${project.startDate} ~ ${project.duration} weeks</p>
                <br>
                <p>${project.country.name}, ${project.city.name}</p>
            </div>

            <form class="elements" method="get" action="/admin-page/update-project">
                <input type="number" hidden name="id" value="${project.id}"/>
                <input type="submit" value="Edit"/>
            </form>

            <form class="elements" method="post" action="/admin-page/delete-project">
                <input type="number" hidden name="id" value="${project.id}"/>
                <input type="submit" name="delete" value="Delete"/>
            </form>
        </div>
    </c:forEach>
</div>

<script type="text/javascript">
    var Msg = '<%=(String)request.getAttribute("msg")%>';
    if (Msg != "null") {
        alert(Msg);
    }
</script>

</body>
</html>
