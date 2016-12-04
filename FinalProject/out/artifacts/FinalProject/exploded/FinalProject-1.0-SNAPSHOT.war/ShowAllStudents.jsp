<%@ page import="Obj.Actor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
<table table cellspacing="2" border="1" cellpadding="5" width="1200">
    <c:forEach var="list" items="${list}" >
    <tr> <td>${list}</td> </tr>
    </c:forEach>
</table>
<form method="post" action="Logic.Student.DeleteStudent">

    login student:<input type="text" name="subject" /><br/>
    <input type="submit" value="delete" />
</form>
    <form method="post" action="Logic.Student.UpdateStudent">

        <input type="submit" value="update" />

</form>
</body>
</html>

