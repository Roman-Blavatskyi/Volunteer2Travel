<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 17.02.2020
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/user-info.css" type="text/css"
          media="all">
</head>
<body>

<div id="header">
    <button class="buttons"><a href="/user/profile">Back to Profile</a></button>
</div>

<div id="user">
    <img src="${sessionScope.user.urlImage}" style="width: 200px; height: 200px">
    <p>${sessionScope.user.name}</p>
    <br>
    <p>${sessionScope.user.surname}</p>
    <br>
    <p>${sessionScope.user.email}</p>
    <br>
    <p>${sessionScope.user.phone}</p>
    <br>
    <p>${sessionScope.user.country.name}</p>

    <form class="elements" method="get" action="/user/profile/personal-info/edit">
        <input type="number" hidden name="id" value="${sessionScope.user.id}"/>
        <input type="submit" value="Edit"/>
    </form>
</div>

<script type="text/javascript">
    var Msg = '<%=(String)request.getAttribute("msg")%>';
    if (Msg != "null") {
        alert(Msg);
    }
</script>
</body>
</html>
