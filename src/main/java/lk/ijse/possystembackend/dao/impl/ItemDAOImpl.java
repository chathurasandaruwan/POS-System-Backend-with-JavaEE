package lk.ijse.possystembackend.dao.impl;

import lk.ijse.possystembackend.dao.ItemDAO;
import lk.ijse.possystembackend.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item entity, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Item entity, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Item> getAll(Connection connection) {
        return null;
    }
}
