<%@ page import="Obj.Actor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<c:out value="${listOfFaculty.get(0).getNameFaculty()}" />--%>
<table cellspacing="2" border="1" cellpadding="5" width="1200">
    <tr>
        <td>
            <c:out value='${listOfStudents}' />
        </td>
    <tr>
        <td><form method="post" action="/UpdateStudent.jsp">
            <input type="submit" value="Show list Information about person " />
            </form>
        </td>
    </tr>

    <tr>
        <td><c:forEach var="listOfSubjectsForStudent" items="${listOfSubjectsForStudent}">
            ${listOfSubjectsForStudent}<br/>
        </c:forEach> </td>
        <td><c:forEach var="scores" items="${scores}">
            ${scores}<br/>
        </c:forEach> </td>
    </tr>


    <tr>
        <td>
            <c:forEach var="listOfSubjectsAll" items="${listOfSubjectsAll}">
                <%--<br/>--%>
    <tr>
        <td>${listOfSubjectsAll.getSubject()}</td>

        <td><form method="post" action="/Logic.InsertSubjectToStudent">
            enter score:<input type="text" name="score" /><br/>
            <%--<input type=hidden name="idFaculty" value="${facultet.getIdFaculties()}">--%>
            <%--<input type=hidden name="idSubject" value="${listOfSubjects.getIdSubject()}">--%>
            <input type=hidden name="addIdSubject" value="${listOfSubjectsAll.getIdSubject()}">
            <input type=hidden name="addSubject" value="${listOfSubjectsAll.getSubject()}">
            <%--<input type=hidden name="facultySubjectList" value="${facultySubjectList}">--%>
            <%--<input type=hidden name="facultetName" value="${facultet.getNameFaculty()}">--%>
            <input type="submit" value="add subject" />
        </form>
        </td>
    </tr>
    </c:forEach>
    </td>
    </tr>


    <tr>
        <td>
            <c:forEach var="listOfFacultiesSt" items="${listOfFacultiesSt}">
               <tr>
                <td>${listOfFacultiesSt}<br/></td>
                <td><form method="post" action="/Logic.DeleteFacultyFromStudent">
                    <%--<input type=hidden name="idActor"    value="${listOfFacultiesSt.getIdSubject()} ">--%>
                    <input type=hidden name="idFaculty"    value="${listOfFacultiesSt.getIdFaculties()} ">
                    <input type="submit" value="delete Faculty" />
                    </form>
                </td>
            </tr>

            </c:forEach>
        </td>
    </tr>

    <tr>
        <td>
            <c:forEach var="listOfFacultiesAll" items="${listOfFacultiesAll}">
                <%--<br/>--%>
    <tr>
        <td>${listOfFacultiesAll.getNameFaculty()}</td>

        <td><form method="post" action="/Logic.InsertFacultyToStudent">
        <%--<td><form method="post" action="/Logic.SetCharFilter">--%>
                <%--<input type=hidden name="idFaculty" value="${facultet.getIdFaculties()}">--%>
                <%--<input type=hidden name="idSubject" value="${listOfSubjects.getIdSubject()}">--%>


            <input type=hidden name="addIdFaculty" value="${listOfFacultiesAll.getIdFaculties()}">
            <input type=hidden name="addNameFaculty" value="${listOfFacultiesAll.getNameFaculty()}">
            <input type=hidden name="addLimitStudent" value="${listOfFacultiesAll.getLimitScores()}">
            <input type=hidden name="addMinScores" value="${listOfFacultiesAll.getMinScores()}">
                <%--<input type=hidden name="facultySubjectList" value="${facultySubjectList}">--%>
                <%--<input type=hidden name="facultetName" value="${facultet.getNameFaculty()}">--%>
            <input type="submit" value="add faculty" />
        </form>
        </td>
    <td><form method="post" action="/Logic.Student.InfrormationAboutFaculty">
            <%--<td><form method="post" action="/Logic.SetCharFilter">--%>
            <%--<input type=hidden name="idFaculty" value="${facultet.getIdFaculties()}">--%>
            <%--<input type=hidden name="idSubject" value="${listOfSubjects.getIdSubject()}">--%>


        <input type=hidden name="addIdFaculty" value="${listOfFacultiesAll.getIdFaculties()}">
        <input type=hidden name="addNameFaculty" value="${listOfFacultiesAll.getNameFaculty()}">
        <input type=hidden name="addLimitStudent" value="${listOfFacultiesAll.getLimitScores()}">
        <input type=hidden name="addMinScores" value="${listOfFacultiesAll.getMinScores()}">
            <%--<input type=hidden name="facultySubjectList" value="${facultySubjectList}">--%>
            <%--<input type=hidden name="facultetName" value="${facultet.getNameFaculty()}">--%>
        <input type="submit" value="watch information" />
    </form>
    </td>

    </tr>
    </c:forEach>
    </td>
    </tr>


</table>
</body>
</html>
