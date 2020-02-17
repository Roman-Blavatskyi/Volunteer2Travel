<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 13.02.2020
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/user.css" type="text/css"
          media="all">
</head>
<body>

<div id="header">
    <button class="buttons"><a href="/logout">Log out</a></button>
    <button class="buttons"><a href="/user/explore">Explore</a></button>
</div>

<h1><a href="/user/profile/personal-info">Personal Info</a></h1>
<h1><a href="/user/profile/projects">Projects</a></h1>

<script type="text/javascript">
    var Msg = '<%=(String)request.getAttribute("msg")%>';
    if (Msg != "null") {
        alert(Msg);
    }
</script>
</body>
</html>
