package lk.ijse.possystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    String customerId;
    String customerName;
    String customerAdd;
    String customerSalary;
}
