<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Food Waste Reduction Platform</h1>
        <p>Please enter your credentials</p>
        <FORM ACTION="../LoginServlet" METHOD="POST">
            User:
            <INPUT TYPE="TEXT" NAME="name" ><BR>
            Password:
            <INPUT TYPE="password" NAME="password" ><P>
                <INPUT TYPE="SUBMIT"> <!-- Press this button to submit form -->
        </FORM>
        <p>If you are not logged click <a href="./register/role_selection.jsp "target="_blank">here </a>to register</p>
    </body>
</html>