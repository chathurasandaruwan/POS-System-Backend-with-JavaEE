package lk.ijse.possystembackend.dao.impl;

import lk.ijse.possystembackend.dao.OrderDAO;
import lk.ijse.possystembackend.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO {
    static String SAVE_ORDER = "INSERT INTO Order(order_id,item_code,order_date,customer_id)VALUE(?,?,?,?)";
   @Override
    public boolean save(Order entity, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_ORDER);

        preparedStatement.setString(1, entity.getOrder_id());
        preparedStatement.setString(2, entity.getItem_code());
        preparedStatement.setString(3, entity.getOrder_date());
        preparedStatement.setString(4, entity.getCustomer_id());

        return preparedStatement.executeUpdate() != 0;
    }
}
