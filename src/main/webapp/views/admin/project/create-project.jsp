<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 12.02.2020
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/admin/project/create-project.css" type="text/css" media="all">

</head>
<body>

<div id="header">
    <button class="buttons"><a href="/admin-page/project">Back to Projects</a></button>
</div>

<form id="createForm" action="/admin-page/create-project" method="post">

    <input name="name" type="text" placeholder="Project name">

    <input name="description" type="text" placeholder="Description">

    <input name="startDate" type="text" placeholder="Start date">

    <input name="duration" type="text" placeholder="Duration">

    <input name="urlImage" type="text" placeholder="Image url">

    <input name="country" type="text" placeholder="Country">

    <input name="city" type="text" placeholder="City">

    <button type="submit">Create</button>
</form>

<script type="text/javascript">
    var Msg = '<%=(String)request.getAttribute("msg")%>';
    if (Msg != "null") {
        alert(Msg);
    }
</script>

</body>
</html>
