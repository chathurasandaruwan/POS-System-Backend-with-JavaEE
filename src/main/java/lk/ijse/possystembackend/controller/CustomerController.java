package lk.ijse.possystembackend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.possystembackend.bo.CustomerBO;
import lk.ijse.possystembackend.bo.impl.CustomerBOProcess;
import lk.ijse.possystembackend.dao.CustomerData;
import lk.ijse.possystembackend.dao.impl.CustomerDataProcess;
import lk.ijse.possystembackend.dto.CustomerDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    CustomerData customerData = new CustomerDataProcess();
    CustomerBO customerBO = new CustomerBOProcess();
    Connection connection;
    @Override
    public void init() throws ServletException {
         try {
            var driverclass = getServletContext().getInitParameter("driver-class");
            var dbURL = getServletContext().getInitParameter("dbURL");
            var dbUserName = getServletContext().getInitParameter("dbUserName");
            var dbPassword = getServletContext().getInitParameter("dbPassword");

            Class.forName(driverclass);
            this.connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null) {
//            send error
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        }
        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader() , CustomerDTO.class);
        System.out.println(customerDTO);
        try {
            boolean isSaved = customerBO.saveStudent(customerDTO,connection);
            if (isSaved) {
                resp.getWriter().write("Save Customer");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                resp.getWriter().write("unable to save Customer");
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
