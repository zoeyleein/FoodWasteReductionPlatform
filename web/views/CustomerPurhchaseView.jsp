<%--
  Created by IntelliJ IDEA.
  User: mayankarora
  Date: 2024-04-07
  Time: 2:11 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Purchase View</title>
</head>
<body>

<ul class="menu">
    <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
</ul>

<label for="location">Select a location:</label>
<select id="location">
    <option value="Nepean">Nepean</option>
    <option value="Kanata">Kanata</option>
    <option value="Barrhaven">Barrhaven</option>
    <option value="Downtown">Downtown</option>
</select>
</body>
</html>

