<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 16.05.16
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logic.Registration</title>
</head>
<body>
<form method="post" action="Registration">
    Name:<input type="text" name="name" /><br/>
    Surname:<input type="text" name="surname" /><br/>
    Middlename :<input type="text" name="middlename" /><br/>
    Age:<input type="text" name="age" /><br/>
    Date of birth:<input type="text" name="dateOfBirth" /><br/>
    login:<input type="text" name="login" /><br/>
    Password:<input type="text" name="pass" /><br/>
    Repeat password:<input type="text" name="repeatPass" /><br/>
    <input type="submit" value="register" />
</form>
</body>
</html>
