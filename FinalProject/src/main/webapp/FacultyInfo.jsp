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
            <c:out value='${facultet}' />
        </td>
        </tr>
     <tr>
         <td>
             <c:forEach var="facultySubjectList" items="${facultySubjectList}">
               <tr>
                    <td>
                            ${facultySubjectList}<br/>

                    </td>

                    <td>
                        <form method="post" action="/Logic.DeleteSubjectFromFaculty">
                            <input type=hidden name="idFaculty" value="${facultet.getIdFaculties()}">
                            <input type=hidden name="nameSubject" value="${facultySubjectList.getSubject()}">
                            <input type=hidden name="idSubject" value="${facultySubjectList.getIdSubject()}">
                            <input type="submit" value="Delete subject" />
                        </form>
                    </td>



                </tr>

                 <%--${facultySubjectList}<br/>--%>
             </c:forEach>
         <%--</td>--%>
         <%--<td>--%>
             <%--<form method="post" action="/Logic.InsertSubjectToFaculty">--%>

                 <%--<input type="submit" value="add subject" />--%>
             <%--</form>--%>
         <%--</td>--%>
     <%--</tr>--%>
     <tr>
         <td>
             <c:forEach var="listOfSubjects" items="${listOfSubjects}">
                 <%--<br/>--%>
                <tr>
                    <td>${listOfSubjects.getSubject()}</td>

                <td><form method="post" action="/Logic.InsertSubjectToFaculty">

                    <input type=hidden name="idFaculty" value="${facultet.getIdFaculties()}">
                    <input type=hidden name="idSubject" value="${listOfSubjects.getIdSubject()}">
                    <input type=hidden name="addSubject" value="${listOfSubjects.getSubject()}">
                    <input type=hidden name="facultySubjectList" value="${facultySubjectList}">
                    <input type=hidden name="facultetName" value="${facultet.getNameFaculty()}">
                    <input type="submit" value="add subject" />
                </form>
                    </td>
                </tr>
             </c:forEach>
         </td>
     </tr>


     <tr>
         <td>
             <form method="post" action="/Logic.Faculty.AddSubjectToFaculty">
                 new subject:<input type="text" name="addSubject" /><br/>
                 <input type="submit" value="Add subject" /><br/>
             </form>
         </td>
     </tr>

 </table>
</body>
</html>


