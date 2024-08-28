package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDetailDAO {
    boolean save(OrderDetail entity, Connection connection) throws SQLException;
}
