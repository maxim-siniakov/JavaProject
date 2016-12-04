<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<sql:query var="rs" dataSource="jdbc/TestDB">--%>
  <%--select name from users--%>
<%--</sql:query>--%>

<%--<html>--%>
<%--<head></head>--%>
<%--<body>--%>
<%--<c:forEach var="row" items="${rs.rows}">--%>
  <%--Name ${row.name}<br/>--%>

<%--</c:forEach>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>
welcome

<table cellspacing="2" border="1" cellpadding="5" width="600">
  <tr>
  <td>Show stuff in our magazine</td>
    <td><a href="Runner">Click to show</a></td>
  </tr>
  <tr>
    <td>Add stuff in the shop </td>
    <td><a href="form.jsp">Add informaion about new medicine</a></td>
  </tr>
  <tr>
    <td>Delete stuff from the shop</td>
    <td><a href="deleteRecord.jsp">Delete some medicine</a></td>
  </tr>

</table>
<%--<jsp:forward page="test.jsp"></jsp:forward>--%>
</body>
</html>
