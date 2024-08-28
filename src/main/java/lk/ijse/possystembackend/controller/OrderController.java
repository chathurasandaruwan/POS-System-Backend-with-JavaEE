package lk.ijse.possystembackend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.possystembackend.bo.PlaceOrderBO;
import lk.ijse.possystembackend.bo.impl.PlaceOrderBOImpl;
import lk.ijse.possystembackend.dto.ItemDTO;
import lk.ijse.possystembackend.dto.OrderDTO;
import lk.ijse.possystembackend.dto.OrderDetailDTO;
import lk.ijse.possystembackend.dto.RequestDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/order")
public class OrderController extends HttpServlet {
    PlaceOrderBO placeOrderBO =new PlaceOrderBOImpl();
    Connection connection;

    @Override
    public void init() throws ServletException {
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
        /*ItemDTO itemDTO = jsonb.fromJson(req.getReader() , ItemDTO.class);
        OrderDTO orderDTO = jsonb.fromJson(req.getReader() , OrderDTO.class);
        OrderDetailDTO detailDTO = jsonb.fromJson(req.getReader() , OrderDetailDTO.class);*/
        RequestDTO requestDTO = jsonb.fromJson(req.getReader() , RequestDTO.class);
        ItemDTO itemDTO=requestDTO.getItemDTO();
        OrderDTO orderDTO = requestDTO.getOrderDTO();
        OrderDetailDTO detailDTO = requestDTO.getOrderDetailDTO();

        System.out.println(itemDTO);
        System.out.println(orderDTO);
        System.out.println(detailDTO);

        try {
            boolean isUpdateI = placeOrderBO.updateItem(itemDTO, connection);
            if (isUpdateI) {
                resp.getWriter().write("Update Item");
                resp.setStatus(HttpServletResponse.SC_CREATED);
                    boolean isSavedO = placeOrderBO.saveOrder(orderDTO,connection);
                    if (isSavedO) {
                        resp.getWriter().write("Save Order");
                        resp.setStatus(HttpServletResponse.SC_CREATED);
                            boolean isSavedOD = placeOrderBO.saveOD(detailDTO,connection);
                            if (isSavedOD) {
                                resp.getWriter().write("Save Order Detail");
                                resp.setStatus(HttpServletResponse.SC_CREATED);
                            } else {
                                resp.getWriter().write("unable to save Order Detail");
                                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                            }
                    } else {
                        resp.getWriter().write("unable to save Order");
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    }
            } else {
                resp.getWriter().write("unable to Update Item");
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
