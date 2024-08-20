package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerData {
    boolean save(CustomerDTO dto, Connection connection) throws SQLException;

    boolean update(CustomerDTO customerDTO, Connection connection) throws SQLException;

    boolean delete(String id, Connection connection) throws SQLException;
}
