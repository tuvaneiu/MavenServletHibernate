package com.servlets;

import com.entities.Salary;
import com.provider.FactoryProvider;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateSalaryServlet", value = "/UpdateSalaryServlet")
public class UpdateSalaryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        try {
            int salaryId = Integer.parseInt(request.getParameter("salaryId"));
            double tax = Double.parseDouble(request.getParameter("tax"));
            double numOfDay = Double.parseDouble(request.getParameter("numOfDay"));
            double allowance = Double.parseDouble(request.getParameter("allowance"));

            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Salary salary = session.get(Salary.class, salaryId);

            salary.setTaxRate(tax);
            salary.setNumOfWorkingDay(numOfDay);
            salary.setAllowance(allowance);

            transaction.commit();
            session.close();

            response.sendRedirect("showSalary.jsp?id=" + salaryId);
        } catch (IOException | NumberFormatException | HibernateException ignored) {
        }
    }
}
