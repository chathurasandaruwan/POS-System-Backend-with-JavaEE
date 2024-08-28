package lk.ijse.possystembackend.dto;

import lk.ijse.possystembackend.entity.Item;
import lk.ijse.possystembackend.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements Serializable {
    String order_id;
    String item_code;
    String order_date;
    String customer_id;

    public static Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setOrder_id(dto.getOrder_id());
        order.setItem_code(dto.getItem_code());
        order.setOrder_date(dto.getOrder_date());
        order.setCustomer_id(dto.getCustomer_id());
        return order;
    }
}
