package heloo.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //Component 스캔의 대상이 됨
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //실제로는 해쉬맵 쓰면 안됨
    //여러개가 동시에 접근하는 경우 해쉬맵 쓰면안됨, 싱글톤이 깨짐 //Conqurent 해쉬맵 써야함
    private static long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence); //++를 사용해서 더하는 로직
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return  new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId); //
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {

        store.clear();
    }


}
