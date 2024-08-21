package lk.ijse.possystembackend.dao.impl;

import lk.ijse.possystembackend.dao.CustomerData;
import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.entity.Customer;

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
    public boolean save(Customer entity, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);

        preparedStatement.setString(1, entity.getCustomerId());
        preparedStatement.setString(2, entity.getCustomerName());
        preparedStatement.setString(3, entity.getCustomerAdd());
        preparedStatement.setString(4, entity.getCustomerSalary());

        return preparedStatement.executeUpdate() != 0;
    }
    @Override
    public boolean update(Customer customerEntity, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
        preparedStatement.setString(1,customerEntity.getCustomerName());
        preparedStatement.setString(2, customerEntity.getCustomerAdd());
        preparedStatement.setString(3, customerEntity.getCustomerSalary());
        preparedStatement.setString(4, customerEntity.getCustomerId());

        return preparedStatement.executeUpdate() != 0;
    }
    @Override
    public boolean delete(String id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
        preparedStatement.setString(1,id);
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public ArrayList<Customer> getAll(Connection connection) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String salary = rs.getString("salary");

                Customer customer = new Customer(id, name, address, salary);
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }


}
