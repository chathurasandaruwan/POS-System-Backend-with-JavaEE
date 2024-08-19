package lk.ijse.possystembackend.bo;

import lk.ijse.possystembackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerBO {
    boolean saveStudent(CustomerDTO dto, Connection connection) throws SQLException;
}
