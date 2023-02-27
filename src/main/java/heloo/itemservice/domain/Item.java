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

    public Item(String itemName, Integer price, Integer quantity) { //생성자를 만들어 두지 않으면 어노테이션이 제대로 작동하지 않음
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
