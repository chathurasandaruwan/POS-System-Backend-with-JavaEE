package lk.ijse.possystembackend.bo.impl;

import lk.ijse.possystembackend.bo.CustomerBO;
import lk.ijse.possystembackend.dao.CustomerData;
import lk.ijse.possystembackend.dao.impl.CustomerDataProcess;
import lk.ijse.possystembackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerBOProcess implements CustomerBO {
    CustomerData customerData = new CustomerDataProcess();
    @Override
    public boolean saveCustomer(CustomerDTO dto, Connection connection) throws SQLException {
        return customerData.save(dto,connection);
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto, Connection connection) throws SQLException {
        return customerData.update(dto,connection);
    }
}
