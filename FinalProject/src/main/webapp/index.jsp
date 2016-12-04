<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 15.05.16
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:forward page="Logic.Registration.jsp"></jsp:forward>--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

<%--<form method="post" action="Logic.Faculty.Check">--%>
<%--<form method="post" action="Logic.FilterAccess">--%>
<form method="post" action="Logic.Autorization">

  login:<input type="text" name="login" /><br/>
  Password:<input type="text" name="pass" /><br/>
  <input type="submit" value="signin" />
</form>

<form method="post" action="Registration.jsp">
  Logic.Registration:
  <input type="submit" value="Registrate" />
</form>


  </body>
</html>
