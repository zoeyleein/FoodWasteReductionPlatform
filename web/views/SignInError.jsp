<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 2024-04-03
  Time: 8:52 p.m.
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Food Waste Reduction Platform</h1>
<p>Please enter your credentials</p>
<FORM action="${pageContext.request.contextPath}/LoginServlet" method="POST">
    User:
    <input type="TEXT" name="name" required><br>
    Password:
    <input type="password" name="password" required><br>
    <input type="submit" name="action" value="Sign in">
</FORM>
<p class="error">The information entered was not correct.</p>
<p>If you are not register yet, please do it here</p>
<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
    <input type="submit" name="action" value="Sign up">
</form>
</body>
</html>