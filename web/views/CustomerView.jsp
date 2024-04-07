<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 2024-04-03
  Time: 2:07 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustomerView</title><%-- this will be what the user sees when they log in --%>
    <link href="../style/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<script>

    function redirectToPurchaseView() {

        window.location.href = "CustomerPurhchaseView.jsp"

    }
</script>
<button onclick="redirectToPurchaseView()">Buy</button>
</body>
</html>
