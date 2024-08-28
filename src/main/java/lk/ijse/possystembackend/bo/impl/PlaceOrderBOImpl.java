package lk.ijse.possystembackend.bo.impl;

import lk.ijse.possystembackend.bo.PlaceOrderBO;
import lk.ijse.possystembackend.dao.ItemDAO;
import lk.ijse.possystembackend.dao.OrderDAO;
import lk.ijse.possystembackend.dao.OrderDetailDAO;
import lk.ijse.possystembackend.dao.impl.ItemDAOImpl;
import lk.ijse.possystembackend.dao.impl.OrderDAOImpl;
import lk.ijse.possystembackend.dao.impl.OrderDetailDAOImpl;
import lk.ijse.possystembackend.dto.ItemDTO;
import lk.ijse.possystembackend.dto.OrderDTO;
import lk.ijse.possystembackend.dto.OrderDetailDTO;
import lk.ijse.possystembackend.entity.Item;
import lk.ijse.possystembackend.entity.Order;
import lk.ijse.possystembackend.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    ItemDAO itemDAO = new ItemDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

    @Override
    public boolean updateItem(ItemDTO dto, Connection connection) throws SQLException {
        Item entity = ItemDTO.toEntity(dto);
        return itemDAO.update(entity,connection);
    }
    @Override
    public boolean saveOrder(OrderDTO dto, Connection connection) throws SQLException {
        Order entity = OrderDTO.toEntity(dto);
        return orderDAO.save(entity,connection);
    }
    @Override
    public boolean saveOD(OrderDetailDTO dto,Connection connection) throws SQLException {
        OrderDetail entity = OrderDetailDTO.toEntity(dto);
        return orderDetailDAO.save(entity,connection);
    }
}
