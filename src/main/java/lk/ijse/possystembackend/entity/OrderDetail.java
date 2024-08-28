package lk.ijse.possystembackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {
    @Id
    String id;
    String itemCode;
    String itemName;
    String price;
    String qty;
    String total;

}
