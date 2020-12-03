<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.List,java.util.ArrayList,com.test.util.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Library</title>
</head>
<body>
<%

List<Student> stdList = new ArrayList<Student>();
stdList.add(new Student(1, "Karim"));
stdList.add(new Student(2, "Suresh"));

session.setAttribute("stdList", stdList);
%>

<c:out value="${stdList}"/><p> 
<table border="1">
  <thead>
    <td>
      <th>id</th>
      <th>Name</th>
   </td>
  </thead>
  <tbody>
   <c:forEach items="${stdList}" var="std">
                <tr>
                    <td>${std.id}</td>
                    <td>${std.name}</td>
                </tr>
    </c:forEach>   
  </tbody>
</table>


<c:out value="${'Welcome to jstl1234'}"/>  
</body>
</html>