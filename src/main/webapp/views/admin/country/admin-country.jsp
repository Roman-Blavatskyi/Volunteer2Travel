<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 13.02.2020
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/admin/country/admin-country.css" type="text/css" media="all">
</head>
<body>
<div id="header">
    <button class="buttons"><a href="/admin-page">Back To Admin Panel</a></button>
</div>
<a href="/admin-page/create-country">
    <div id="addProject">Create Country</div>
</a>

<div id="cities">
    <c:forEach var="country" items="${requestScope.admin_countries}">
        <div id="countryId">
            <div id="description" class="elements">
                <p>${country.name}</p>
            </div>

            <form class="elements" method="get" action="/admin-page/update-country">
                <input type="number" hidden name="id" value="${country.id}"/>
                <input type="submit" value="Edit"/>
            </form>

            <form class="elements" method="post" action="/admin-page/delete-country">
                <input type="number" hidden name="id" value="${country.id}"/>
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
