package lk.ijse.possystembackend.dao.impl;

import lk.ijse.possystembackend.dao.CustomerData;
import lk.ijse.possystembackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDataProcess implements CustomerData {
    static String SAVE_CUSTOMER = "INSERT INTO customer(id,name,address,salary)VALUE(?,?,?,?)";
    static String UPDATE_CUSTOMER = "UPDATE customer SET name =? , address = ?, salary =? WHERE id = ?";
    static String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?";
    private static final String GET_ALL_CUSTOMER = "SELECT * FROM customer";

    @Override
    public boolean save(CustomerDTO dto, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);

        preparedStatement.setString(1, dto.getCustomerId());
        preparedStatement.setString(2, dto.getCustomerName());
        preparedStatement.setString(3, dto.getCustomerAdd());
        preparedStatement.setString(4, dto.getCustomerSalary());

        return preparedStatement.executeUpdate() != 0;
    }
    @Override
    public boolean update(CustomerDTO customerDTO, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
        preparedStatement.setString(1,customerDTO.getCustomerName());
        preparedStatement.setString(2, customerDTO.getCustomerAdd());
        preparedStatement.setString(3, customerDTO.getCustomerSalary());
        preparedStatement.setString(4, customerDTO.getCustomerId());

        return preparedStatement.executeUpdate() != 0;
    }
    @Override
    public boolean delete(String id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
        preparedStatement.setString(1,id);
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public ArrayList<CustomerDTO> getAll(Connection connection) {
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String salary = rs.getString("salary");

                CustomerDTO customer = new CustomerDTO(id, name, address, salary);
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }


}
