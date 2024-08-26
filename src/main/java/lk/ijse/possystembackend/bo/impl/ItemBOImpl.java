package lk.ijse.possystembackend.bo.impl;

import lk.ijse.possystembackend.bo.ItemBO;
import lk.ijse.possystembackend.dao.ItemDAO;
import lk.ijse.possystembackend.dao.impl.ItemDAOImpl;
import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.dto.ItemDTO;
import lk.ijse.possystembackend.entity.Customer;
import lk.ijse.possystembackend.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = new ItemDAOImpl();
    @Override
    public boolean saveItem(ItemDTO dto, Connection connection) throws SQLException {
        Item entity = ItemDTO.toEntity(dto);
        return itemDAO.save(entity,connection);
    }

    @Override
    public boolean updateItem(ItemDTO dto, Connection connection) throws SQLException {
        Item entity = ItemDTO.toEntity(dto);
        return itemDAO.update(entity,connection);
    }

    @Override
    public boolean deleteItem(String id, Connection connection) throws SQLException {
        return itemDAO.delete(id,connection);
    }

    @Override
    public ArrayList<ItemDTO> getAllItem(Connection connection) {
        ArrayList<Item> items = itemDAO.getAll(connection);
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            itemDTOS.add(ItemDTO.toDTO(item));
        }
        return itemDTOS;
    }
}
