<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@page import="java.util.*"%>
<%@ page import="com.entities.Employee" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="com.provider.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Page</title>
</head>
<body>
	<h2>All Employees</h2>
	
	<%
		Session s = FactoryProvider.getFactory().openSession();
		Query query = s.createQuery("from Employee");
		List<Employee> employeeList = query.list();

		for(Employee employee : employeeList){
		%>
			<hr>
			<p>Employee ID: <%=employee.getEmployeeId()%></p>
			<p>Name: <%=employee.getFirstName()%> <%=employee.getLastName()%></p>
			<p>Phone: <%=employee.getPhone()%></p>
			<p>Email: <%=employee.getEmail()%></p>
			<p>Date of birth: <%=employee.getDateOfBirth()%></p>
			<p>Position: <%=employee.getPosition()%></p>
			<br>
			<a href="DeleteEmployeeServlet?id=<%=employee.getId()%>" onclick="return confirmFunction()">Delete</a>
			<a href="updateEmployee.jsp?id=<%=employee.getId()%>">Update</a>
		<%
		}
		s.close();
	%>
	<hr>
	<a href="index.jsp">Return to home page</a>
	
	<script type="text/javascript">
	    function confirmFunction () {
	    	return confirm("Are you sure to delete this employee?");
	    }
	</script>
	
</body>
</html>