package lk.ijse.possystembackend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.possystembackend.bo.ItemBO;
import lk.ijse.possystembackend.bo.impl.ItemBOImpl;
import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.dto.ItemDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/item")
public class ItemController extends HttpServlet {
    ItemBO itemBO = new ItemBOImpl();
    Connection connection;
    @Override
    public void init() throws ServletException {
        /*try {
            var driverclass = getServletContext().getInitParameter("driver-class");
            var dbURL = getServletContext().getInitParameter("dbURL");
            var dbUserName = getServletContext().getInitParameter("dbUserName");
            var dbPassword = getServletContext().getInitParameter("dbPassword");

            Class.forName(driverclass);
            this.connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        try {
            var ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/posSystem");
            this.connection =  pool.getConnection();
        }catch (NamingException | SQLException e){
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
        ItemDTO itemDTO = jsonb.fromJson(req.getReader() , ItemDTO.class);
        System.out.println(itemDTO);
        try {
            boolean isSaved = itemBO.saveItem(itemDTO, connection);
            if (isSaved) {
                resp.getWriter().write("Save Item");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                resp.getWriter().write("unable to save Item");
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null) {
//            send error
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        }
        Jsonb jsonb = JsonbBuilder.create();
        ItemDTO itemDTO = jsonb.fromJson(req.getReader() , ItemDTO.class);
        System.out.println(itemDTO);
        try {
            boolean isUpdate = itemBO.updateItem(itemDTO, connection);
            if (isUpdate) {
                resp.getWriter().write("Update Item");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                resp.getWriter().write("unable to Update Item");
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemCode = req.getParameter("id");
        try {
            boolean isDelete = itemBO.deleteItem(itemCode,connection);
            if (isDelete){
                resp.getWriter().write(itemCode+" : Delete successfully!!!");
            }else {
                resp.getWriter().write("Some thing wrong!! Please Try again!!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<ItemDTO> itemDTOS =itemBO.getAllItem(connection);
        try (var writer = resp.getWriter()){
            resp.setContentType("application/json");
            Jsonb jsonb = JsonbBuilder.create();
            jsonb.toJson(itemDTOS,writer);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        /*for (ItemDTO dto : itemDTOS) {
            resp.getWriter().write(dto.getItem_code()+"\n");
            resp.getWriter().write(dto.getItem_Name()+"\n");
            resp.getWriter().write(dto.getItem_price()+"\n");
            resp.getWriter().write(dto.getItem_qty()+"\n");
            resp.getWriter().write("======================"+"\n");
        }*/
    }
}
