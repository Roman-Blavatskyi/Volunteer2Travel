<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 17.02.2020
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/user-profile-edit.css" type="text/css"
          media="all">
</head>
<body>

<div id="header">
    <button class="buttons"><a href="/user/profile">Back to Profile</a></button>
</div>

<form id="updateForm" action="/user/profile/personal-info/edit" method="post">

    <input name="id" type="number" placeholder="Id" value="${sessionScope.user.id}">
    <br>
    <input name="name" type="text" placeholder="User name" value="${sessionScope.user.name}">
    <br>
    <input name="surname" type="text" placeholder="Surname"
           value="${sessionScope.user.surname}">
    <br>
    <input name="phone" type="text" placeholder="Phone"
           value="${sessionScope.user.phone}">
    <br>
    <input name="country" type="text" placeholder="Country"
           value="${sessionScope.user.country.name}">
    <br>
    <input name="urlImage" type="text" placeholder="Image url"
           value="${sessionScope.user.urlImage}">
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
