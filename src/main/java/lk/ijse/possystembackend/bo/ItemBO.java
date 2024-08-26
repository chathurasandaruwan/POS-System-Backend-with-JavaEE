package lk.ijse.possystembackend.bo;

import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    boolean saveItem(ItemDTO dto, Connection connection) throws SQLException;

    boolean updateItem(ItemDTO dto, Connection connection) throws SQLException;

    boolean deleteItem(String id, Connection connection) throws SQLException;

    ArrayList<ItemDTO> getAllItem(Connection connection);
}
