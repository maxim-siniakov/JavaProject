<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 19.05.16
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/TestDB">
    select min_scores from Faculties where idFaculties = 1
</sql:query>

<sql:query var="ns" dataSource="jdbc/TestDB">
    select limit_students from Faculties where idFaculties = 1
</sql:query>


<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome, you are on the ENF page. You can to see some information about us
<table cellspacing="2" border="1" cellpadding="5" width="600">
    <tr>
        <td>проходной балл в этом году</td>
        <td><c:forEach var="row" items="${rs.rows}">
            ${row.min_scores}<br/>
        </c:forEach> </td>
    </tr>
    <tr>
        <td>Количество мест на факультете </td>
        <td><c:forEach var="row" items="${ns.rows}">
            ${row.limit_students}<br/>
        </c:forEach> </td>
    </tr>
    <tr>
        <td>Если хотите поступить к нам нажмите ввести данные  </td>
        <td><a href="Logout">Выйти</a></td>
    </tr>
    <tr>
        <td>Посмотреть список всех подавших документы</td>
        <td><a href="Logic.Student.AllStudentsList">Посмотреть список поступивших</a></td>
    </tr>

</table>
</body>
</html>
