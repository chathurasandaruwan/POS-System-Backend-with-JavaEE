package lk.ijse.possystembackend.bo;

import lk.ijse.possystembackend.dto.ItemDTO;
import lk.ijse.possystembackend.dto.OrderDTO;
import lk.ijse.possystembackend.dto.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO {
    boolean updateItem(ItemDTO dto, Connection connection) throws SQLException;

    boolean saveOrder(OrderDTO dto, Connection connection) throws SQLException;

    boolean saveOD(OrderDetailDTO dto, Connection connection) throws SQLException;

    ArrayList<OrderDetailDTO> getAllOrders(Connection connection);
}
