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

@WebServlet(name = "UpdateEmployeeServlet", value = "/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
//            String employee_id = request.getParameter("employee_id");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Date dob = Date.valueOf(request.getParameter("dob"));
            Position position = Position.valueOf(request.getParameter("position"));

            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);

            employee.setFirstName(fname);
            employee.setLastName(lname);
            employee.setPhone(phone);
            employee.setEmail(email);
            employee.setDateOfBirth(dob);
            employee.setPosition(position);

            transaction.commit();
            session.close();

            response.sendRedirect("showAllEmployee.jsp");
        } catch (IOException | NumberFormatException | HibernateException ignored) {
        }
    }
}
