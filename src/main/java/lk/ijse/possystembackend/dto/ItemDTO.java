package lk.ijse.possystembackend.dto;

import lk.ijse.possystembackend.entity.Customer;
import lk.ijse.possystembackend.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements Serializable {
    String item_code;
    String item_Name;
    String item_price;
    String item_qty;

    public static Item toEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItem_code(itemDTO.getItem_code());
        item.setItem_Name(itemDTO.getItem_Name());
        item.setItem_price(itemDTO.getItem_price());
        item.setItem_qty(itemDTO.getItem_qty());
        return item;
    }
    public static ItemDTO toDTO(Item item) {
        return new ItemDTO(
                item.getItem_code(),
                item.getItem_Name(),
                item.getItem_price(),
                item.getItem_qty()
        );
    }
}
