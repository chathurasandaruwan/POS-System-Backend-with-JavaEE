package lk.ijse.possystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceOrderDTO implements Serializable {
    String id;
    String itemCode;
    String itemName;
    String price;
    String qty;
    String total;
}
