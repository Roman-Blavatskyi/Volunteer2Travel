<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 13.02.2020
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/admin/admin-page.css" type="text/css" media="all">
</head>
<body>
<div id="header">
    <button class="buttons"><a href="/logout">Log out</a></button>
</div>
<h1>Admin Panel</h1>
<div id="entities">
    <a href="/admin-page/project">
        <div class="options">Projects</div>
    </a>
    <a href="/admin-page/country">
        <div class="options">Countries</div>
    </a>
    <a href="/admin-page/city">
        <div class="options">Cities</div>
    </a>
    <a href="/admin-page/skill">
        <div class="options">Skills</div>
    </a>
    <a href="/admin-page/background">
        <div class="options">Backgrounds</div>
    </a>
    <a href="/admin-page/language">
        <div class="options">Languages</div>
    </a>
</div>

<script type="text/javascript">
    var Msg = '<%=(String)request.getAttribute("msg")%>';
    if (Msg != "null") {
        alert(Msg);
    }
</script>

</body>
</html>
