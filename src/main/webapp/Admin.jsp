<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <form action="AdmRegisterController">
         Registration Number<input type="text" name="regNo"><br>
         Name <input type="text" name="name"><br>
         UserName <input type="text" name="uname"><br>
         Mail Id<input type="email" name="mail"><br>
         Password <input type="text" name="pass"><br>
         <input type="submit" value="save">
         
     </form>
     <a href="Login.jsp">Login Here</a><br>
     <a href="Recharge.jsp">Create new plan</a><br>
     <a href="SearchRecharge.jsp">for search plan</a><br> 
     <a href="UpdateRecharge.jsp">for Update plan</a><br>
     <a href="DeleteRecharge.jsp">For Delete Plan</a><br>
     <a href="DisplayRechargeServlet">View Plan</a><br>
    
</body>
</html>