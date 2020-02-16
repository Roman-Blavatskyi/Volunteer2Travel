<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 16.02.2020
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/admin/city/update-city.css" type="text/css" media="all">
</head>
<body>

<div id="header">
    <button class="buttons"><a href="/admin-page/city">Back to cities</a></button>
</div>

<form id="updateForm" action="/admin-page/update-city" method="post">

    <input name="id" type="number" placeholder="Id" value="${requestScope.city.id}">
    <br>
    <input name="name" type="text" placeholder="City name" value="${requestScope.city.name}">
    <br>
    <button type="submit">Edit</button>
</form>

<script type="text/javascript">
    var Msg = '<%=(String)request.getAttribute("msg")%>';
    if (Msg != "null") {
        alert(Msg);
    }
</script>
</body>
</html>
