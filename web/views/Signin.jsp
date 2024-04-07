<!DOCTYPE html>
<html>
    <head>
        <title>Sign In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../style/style.css" type="text/css" rel="stylesheet">
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
    </body>
</html>
