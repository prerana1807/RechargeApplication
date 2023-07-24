<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <form action="DisplayRechargeServlet">
     <c:if test="${requestScope.lst != null and 
not empty requesScope.lst}">
<table border="1" cellpadding="3">
<tr>
   <td>id</td>
   <td>opeName</td>
   <td>planDetails</td>
   <td>planValidity</td>
   <td>price</td>
   <td>&nbsp;</td>
</tr>
  <c:forEach items="${requestScope.lst}" var="e">
  <tr>
  <td>${e.id}</td>
  <td>${e.opeName}</td>
  <td>${e.planDetails}</td>
  <td>${e.planValidity}</td>
  <td>${e.price}</td>
  </tr>
  </c:forEach>
</table>  
</c:if>
     </form>
</body>
</html>