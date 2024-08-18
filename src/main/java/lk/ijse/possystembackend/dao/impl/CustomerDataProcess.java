package lk.ijse.possystembackend.dao.impl;

import lk.ijse.possystembackend.dao.CustomerData;
import lk.ijse.possystembackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDataProcess implements CustomerData {
    static String SAVE_CUSTOMER = "INSERT INTO customer(id,name,address,salary)VALUE(?,?,?,?)";

    @Override
    public boolean save(CustomerDTO dto, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);

        preparedStatement.setString(1, dto.getCustomerId());
        preparedStatement.setString(2, dto.getCustomerName());
        preparedStatement.setString(3, dto.getCustomerAdd());
        preparedStatement.setString(4, dto.getCustomerSalary());

        return preparedStatement.executeUpdate() != 0;

    }

}
