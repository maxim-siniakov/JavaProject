<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 19.05.16
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
welcome to our university. Here you can choose faculty, what you want.
<table cellspacing="2" border="1" cellpadding="5" width="600">
    <tr>
        <%--<td>Show stuff in our magazine</td>--%>
        <td><a href="ENF.jsp">ENF</a></td>
    </tr>
    <tr>
        <%--<td>Add stuff in the shop </td>--%>
        <td><a href="form.jsp">Add informaion about new medicine</a></td>
    </tr>
    <tr>
        <%--<td>Add stuff in the shop </td>--%>
        <td><a href="Logic.Faculty.AllFaculties">Show all Faculties</a></td>
    </tr>
    <tr>
        <%--<td>Delete stuff from the shop</td>--%>
        <td><a href="deleteRecord.jsp">Delete some medicine</a></td>
    </tr>

    <tr>
        <%--<td>Delete stuff from the shop</td>--%>
        <td><a href="Logic.Subject.AllSubjects">Show all subjects</a></td>
    </tr>

    <tr>
        <%--<td>Delete stuff from the shop</td>--%>
        <td><a href="Logic.Student.CheckStateStudent">Show list of students, who has passed exam</a></td>
    </tr>

    <tr>
        <%--<td>Delete stuff from the shop</td>--%>
        <td><a href="Logic.Student.ShowStudentInformation">Show self data</a></td>
    </tr>

    <tr>
        <%--<td>Delete stuff from the shop</td>--%>
        <td><a href="Logic.Logout">quit </a></td>
    </tr>

</table>



</body>
</html>
