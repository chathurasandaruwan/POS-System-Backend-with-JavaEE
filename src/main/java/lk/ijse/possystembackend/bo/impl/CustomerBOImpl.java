package lk.ijse.possystembackend.bo.impl;

import lk.ijse.possystembackend.bo.CustomerBO;
import lk.ijse.possystembackend.dao.CustomerDAO;
import lk.ijse.possystembackend.dao.impl.CustomerDAOImpl;
import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerData = new CustomerDAOImpl();
    @Override
    public boolean saveCustomer(CustomerDTO dto, Connection connection) throws SQLException {
        Customer entity =CustomerDTO.toEntity(dto);
        return customerData.save(entity,connection);
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto, Connection connection) throws SQLException {
        Customer entity =CustomerDTO.toEntity(dto);
        return customerData.update(entity,connection);
    }
    @Override
    public boolean deleteCustomer(String id, Connection connection) throws SQLException {
        return customerData.delete(id,connection);
    }
    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) {
        ArrayList<Customer> customers = customerData.getAll(connection);
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOS.add(CustomerDTO.toDTO(customer));
        }
        return customerDTOS;
    }
}
