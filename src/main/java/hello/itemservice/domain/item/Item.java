package hello.itemservice.domain.item;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
