package lk.ijse.possystembackend.bo;

import lk.ijse.possystembackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    boolean saveCustomer(CustomerDTO dto, Connection connection) throws SQLException;

    boolean updateCustomer(CustomerDTO dto, Connection connection) throws SQLException;

    boolean deleteCustomer(String id, Connection connection) throws SQLException;

    ArrayList<CustomerDTO> getAllCustomers(Connection connection);
}
