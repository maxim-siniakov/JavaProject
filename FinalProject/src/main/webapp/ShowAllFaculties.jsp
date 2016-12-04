<%@ page import="Obj.Actor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
<table table cellspacing="2" border="1" cellpadding="5" width="1200">
    <c:forEach var="listOfFaculties" items="${listOfFaculties}" >
        <%--var link=""--%>
        <tr>
            <td>${listOfFaculties.getNameFaculty()}</td>
            <td><form method="post" action="/Logic.Faculty.ShowFacultyInformation">
                <input type=hidden name="idFaculties" value="${listOfFaculties.getIdFaculties()}">
                <input type=hidden name="name_faculty" value="${listOfFaculties.getNameFaculty()}">
                <input type=hidden name="min_scores" value="${listOfFaculties.getMinScores()}">
                <input type=hidden name="limit_students" value="${listOfFaculties.getLimitScores()}">
                <input type=hidden name="listOfSubjects" value="${listOfSubjects}">
                <input type="submit" value="Show listInformation" />
            </form>
            </td>
        </tr>

        <%--<form action="/Logic.Faculty.ShowFacultyInformation" method="post">--%>
            <%--<input type=hidden name="name_faculty" value="${listOfFaculties.getNameFaculty()}">--%>
            <%--<input type=hidden name="min_scores" value="${listOfFaculties.getMinScores()}">--%>
            <%--<input type=hidden name="limit_students" value="${listOfFaculties.getLimitScores()}">--%>
            <%--<input type=submit></form>--%>


    </c:forEach>
   </table>

<form method="post" action="Logic.Faculty.DeleteFaculty">

    faculty:<input type="text" name="name_faculty" /><br/>
    <input type="submit" value="DELETE" />
</form>

<form method="post" action="InsertFaculty.jsp">

    <%--faculty:<input type="text" name="name_faculty" /><br/>--%>
    <input type="submit" value="insert faculty" />
</form>


<form method="post" action="UpdateFaculty.jsp">
    <%--faculty:<input type="text" name="name_faculty" /><br/>--%>
    <input type="submit" value="update faculty" />
</form>


<form method="post" action="Faculties.jsp">
    <%--faculty:<input type="text" name="name_faculty" /><br/>--%>
    <input type="submit" value="back to main menu" />
</form>

</body>
</html>

