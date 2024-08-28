package lk.ijse.possystembackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    String order_id;
    String item_code;
    String qty;
    String order_date;
    String customer_id;
}
