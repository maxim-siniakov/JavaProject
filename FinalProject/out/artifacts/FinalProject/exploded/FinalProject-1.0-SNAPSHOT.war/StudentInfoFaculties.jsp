<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 30.07.16
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Obj.Actor" %>
<%@ page import="java.util.List" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table cellspacing="2" border="1" cellpadding="5" width="1200">
    <tr>
        <td> ${facultet.getNameFaculty()}</td>
        <td>Количество студентов <br>${facultet.getLimitScores()}</td>
        <td>Проходной балл <br> ${facultet.getMinScores()}</td>
    </tr>
<tr>
<td>
    Необходимые предметы для поступления
<c:forEach var="facultySubjectLis" items="${facultySubjectLis}">


    <tr>
        <td>${facultySubjectLis}<br/>
    </td>
    </tr>
    </c:forEach>




    </table>
</body>
</html>
