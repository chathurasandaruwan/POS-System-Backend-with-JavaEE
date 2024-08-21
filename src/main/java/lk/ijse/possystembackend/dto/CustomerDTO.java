package lk.ijse.possystembackend.dto;

import lk.ijse.possystembackend.entity.Customer;
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

    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getCustomerAdd(),
                customer.getCustomerSalary()
        );
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerAdd(customerDTO.getCustomerAdd());
        customer.setCustomerSalary(customerDTO.getCustomerSalary());
        return customer;
    }
}
