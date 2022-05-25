package com.servlets;

import com.entities.Employee;
import com.provider.FactoryProvider;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteEmployeeServlet", value = "/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Session session = FactoryProvider.getFactory().openSession();
            Employee employee = session.get(Employee.class, id);
            Transaction transaction = session.beginTransaction();

            session.delete(employee);
            transaction.commit();

            response.sendRedirect("showAllEmployee.jsp");
            session.close();
        } catch (IOException | NumberFormatException | HibernateException ignored) {
        }
    }
}
