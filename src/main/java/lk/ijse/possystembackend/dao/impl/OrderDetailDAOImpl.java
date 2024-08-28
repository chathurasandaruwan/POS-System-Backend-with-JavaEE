package lk.ijse.possystembackend.dao.impl;

import lk.ijse.possystembackend.dao.OrderDetailDAO;
import lk.ijse.possystembackend.entity.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    static String SAVE_ORDER_DT = "INSERT INTO orderDetail(id,order_id,item_code,qty,Order_date,customer_id)VALUE(?,?,?,?)";
    private static final String GET_ALL_ORDERS = "SELECT * FROM orderDetail";
    @Override
    public boolean save(OrderDetail entity, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_ORDER_DT);

        preparedStatement.setString(1, entity.getId());
        preparedStatement.setString(2, entity.getOrder_id());
        preparedStatement.setString(3, entity.getItem_code());
        preparedStatement.setString(4, entity.getQty());
        preparedStatement.setString(4, entity.getOrder_date());
        preparedStatement.setString(4, entity.getCustomer_id());

        return preparedStatement.executeUpdate() != 0;
    }
    @Override
    public ArrayList<OrderDetail> getAll(Connection connection) {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS);
                ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String Order_id = rs.getString("order_id");
                String Item_code = rs.getString("item_code");
                String Qty = rs.getString("qty");
                String Order_date = rs.getString("Order_date");
                String Customer_id = rs.getString("customer_id");

                OrderDetail orderDetail = new OrderDetail(id, Order_id, Item_code, Qty,Order_date,Customer_id);
                orderDetails.add(orderDetail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetails;
    }
}
