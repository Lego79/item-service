package heloo.itemservice.domain;

import lombok.Data;

@Data //위험하다, 메인 엔티티엔 쓰기 위험하고, dto에정도엔 data를 쓸만하다, 확인이 필요
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
