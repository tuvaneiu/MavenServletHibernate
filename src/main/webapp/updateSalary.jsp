<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@page import="java.util.*"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.provider.FactoryProvider" %>
<%@ page import="com.entities.Salary" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Employee Page</title>

    <style type="text/css">
        .content{
            height: 610px;
            padding: 20px;
            text-align: center;
        }
        table tr td{
            padding-bottom: 10px;
        }
        label, input, select {
            float: left;
        }
        select {
            padding: 2px;
        }
    </style>
</head>
<body>
    <%
        int salaryId = Integer.parseInt(request.getParameter("id"));
        Session s = FactoryProvider.getFactory().openSession();
        Salary salary = s.get(Salary.class, salaryId);
    %>
    <div class="content">
        <!--<div class="invalidId">Please enter another ID!</div>-->
        <h2 style="margin-bottom: 40px;">Edit Salary</h2>
        <form action="UpdateSalaryServlet" method="post" style="margin: 0px">
            <input name="salaryId" id="salaryId" type="hidden" value="<%=salaryId%>">
            <table style="margin: auto;">
                <tr>
                    <td><label for="employee_id">Employee ID:</label></td>
                    <td><input type="text" id="employee_id" name="employee_id" readonly="readonly" value="<%=salary.getEmployee().getEmployeeId()%>"></td>
                </tr>
                <tr>
                    <td><label for="tax">Tax Rate:</label></td>
                    <td><input type="number" step="0.01" id="tax" name="tax" value="<%=salary.getTaxRate()%>" required="required"></td>
                </tr>
                <tr>
                    <td><label for="numOfDay">Working Day:</label></td>
                    <td><input type="number" step="0.5" id="numOfDay" name="numOfDay" value="<%=salary.getNumOfWorkingDay()%>" required="required"></td>
                </tr>
                <tr>
                    <td><label for="allowance">Allowance:</label></td>
                    <td><input type="number" id="allowance" name="allowance" value="<%=salary.getAllowance()%>" required="required"></td>
                </tr>
            </table>
            <br>
            <button style="font-size: 20px;" type="submit">Edit</button>
            <button style="font-size: 20px;" type="reset">Reset</button>
        </form>
    </div>
    <%
        s.close();
    %>
</body>
</html>