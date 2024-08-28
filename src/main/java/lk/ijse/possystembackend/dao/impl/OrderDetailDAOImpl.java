package lk.ijse.possystembackend.dao.impl;

import lk.ijse.possystembackend.dao.OrderDetailDAO;
import lk.ijse.possystembackend.entity.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    static String SAVE_ORDER_DT = "INSERT INTO item(item_code,item_Name,item_price,item_qty)VALUE(?,?,?,?)";
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
}
