package lk.ijse.possystembackend.dto;

import lk.ijse.possystembackend.entity.Order;
import lk.ijse.possystembackend.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO implements Serializable {
    String id;
    String order_id;
    String item_code;
    String qty;
    String order_date;
    String customer_id;


    public static OrderDetail toEntity(OrderDetailDTO dto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(dto.getId());
        orderDetail.setOrder_id(dto.getOrder_id());
        orderDetail.setItem_code(dto.getItem_code());
        orderDetail.setQty(dto.getQty());
        orderDetail.setOrder_date(dto.getOrder_date());
        orderDetail.setCustomer_id(dto.getCustomer_id());
        return orderDetail;
    }
}
