package com.servlets;

import com.entities.Employee;
import com.entities.Position;
import com.provider.FactoryProvider;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddEmployeeServlet", value = "/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
			String employee_id = request.getParameter("employee_id");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Date dob = Date.valueOf(request.getParameter("dob"));
            Position position = Position.valueOf(request.getParameter("position"));

            Employee employee = new Employee(employee_id, fname, lname, phone, email, dob, position);

            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();

            session.save(employee);
            transaction.commit();

            session.close();
            response.sendRedirect("showAllEmployee.jsp");
        } catch (IOException | HibernateException ignored) {
        }
    }
}
