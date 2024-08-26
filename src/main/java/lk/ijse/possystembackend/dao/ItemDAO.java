package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    boolean save(Item entity, Connection connection) throws SQLException;

    boolean update(Item entity, Connection connection) throws SQLException;

    boolean delete(String id, Connection connection) throws SQLException;

    ArrayList<Item> getAll(Connection connection);
}
