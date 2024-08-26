package lk.ijse.possystembackend.bo.impl;

import lk.ijse.possystembackend.bo.ItemBO;
import lk.ijse.possystembackend.dao.ItemDAO;
import lk.ijse.possystembackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    @Override
    public boolean saveItem(ItemDTO dto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean updateItem(ItemDTO dto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteItem(String id, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<ItemDTO> getAllItem(Connection connection) {
        return null;
    }
}
