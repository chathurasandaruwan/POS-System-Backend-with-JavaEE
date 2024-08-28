package lk.ijse.possystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDTO implements Serializable {
    private ItemDTO itemDTO;
    private OrderDTO orderDTO;
    private OrderDetailDTO orderDetailDTO;
}
