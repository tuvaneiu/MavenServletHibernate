<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.provider.FactoryProvider" %>
<%@ page import="com.entities.Salary" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Employee Page</title>
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
    <hr>
    <b>Income: <%=String.format("%,.2f", salary.getEmployee().computeSalary(salary))%> VNĐ</b>

    <hr>
    <a href="index.jsp">Return to home page</a>
    <%
        s.close();
    %>
</body>
</html>