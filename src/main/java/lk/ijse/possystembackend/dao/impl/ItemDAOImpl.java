package lk.ijse.possystembackend.dao.impl;

import lk.ijse.possystembackend.dao.ItemDAO;
import lk.ijse.possystembackend.entity.Customer;
import lk.ijse.possystembackend.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    static String SAVE_ITEM = "INSERT INTO item(item_code,item_Name,item_price,item_qty)VALUE(?,?,?,?)";
    static String UPDATE_ITEM = "UPDATE item SET item_Name =? , item_price = ?, item_qty =? WHERE item_code = ?";
    static String DELETE_ITEM = "DELETE FROM item WHERE item_code = ?";
    private static final String GET_ALL_ITEM = "SELECT * FROM item";
    @Override
    public boolean save(Item entity, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_ITEM);

        preparedStatement.setString(1, entity.getItem_code());
        preparedStatement.setString(2, entity.getItem_Name());
        preparedStatement.setString(3, entity.getItem_price());
        preparedStatement.setString(4, entity.getItem_qty());

        return preparedStatement.executeUpdate() != 0;
    }

    @Override
    public boolean update(Item entity, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ITEM);

        preparedStatement.setString(1, entity.getItem_Name());
        preparedStatement.setString(2, entity.getItem_price());
        preparedStatement.setString(3, entity.getItem_qty());
        preparedStatement.setString(4, entity.getItem_code());

        return preparedStatement.executeUpdate() != 0;
    }

    @Override
    public boolean delete(String item_code, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ITEM);
        preparedStatement.setString(1,item_code);
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public ArrayList<Item> getAll(Connection connection) {
        ArrayList<Item> items = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ITEM);
                ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String item_code = rs.getString("item_code");
                String item_Name = rs.getString("item_Name");
                String item_price = rs.getString("item_price");
                String item_qty = rs.getString("item_qty");

                Item item = new Item(item_code, item_Name, item_price, item_qty);
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
