package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDAO {
    boolean save(Order entity, Connection connection) throws SQLException;
}
