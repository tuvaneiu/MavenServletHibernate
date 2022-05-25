<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="java.util.*"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.provider.FactoryProvider" %>
<%@ page import="com.entities.Salary" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Salary Info Page</title>
</head>
<body>
    <h2>Salary Info</h2>

    <%
        int salaryId = Integer.parseInt(request.getParameter("id"));
        Session s = FactoryProvider.getFactory().openSession();
        Salary salary = s.get(Salary.class, salaryId);
    %>
        <hr>
        <p>Employee ID: <%=salary.getEmployee().getEmployeeId()%></p>
        <p>Tax Rate: <%=salary.getTaxRate()%></p>
        <p>Working Day: <%=salary.getNumOfWorkingDay()%></p>
        <p>Allowance: <%=salary.getAllowance()%></p>
        <br>
        <a href="updateSalary.jsp?id=<%=salaryId%>">Update</a>
        <a href="computeSalary.jsp?id=<%=salaryId%>">Get Income</a>
    <%
        s.close();
    %>
    <hr>
    <a href="index.jsp">Return to home page</a>

</body>
</html>