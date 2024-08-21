package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerData {
    boolean save(Customer entity, Connection connection) throws SQLException;

    boolean update(Customer customerEntity, Connection connection) throws SQLException;

    boolean delete(String id, Connection connection) throws SQLException;

    ArrayList<Customer> getAll(Connection connection);
}
