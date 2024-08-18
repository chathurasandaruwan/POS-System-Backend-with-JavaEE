package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerData {
    boolean save(CustomerDTO dto, Connection connection) throws SQLException;
}
