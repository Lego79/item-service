package heloo.itemservice.web;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.List;
@Controller
@RequestMapping("/basic/items") //BASIC, ITEMS를 경로 설정해서 들어오는 요청을 응답해줌
@RequiredArgsConstructor //final이 붙은 부분만 생성자를 생성한다
public class BasicItemController {
    private final ItemRepository itemRepository;
    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll(); //
        model.addAttribute("items", items);
        return "basic/items"; // URL 리턴하면서 받은 값을 담아서 리턴
    }
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct //의존성 주입이 이루어진 후 초기화를 수행하는 메서드이다. @PostConstruct가 붙은 메서드는 클래스가 service(로직을 탈 때? 로 생각 됨)를 수행하기 전에 발생한다. 이 메서드는 다른 리소스에서 호출되지 않는다해도 수행된다.
    public void init() {
        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 20000, 20));
    }

    @GetMapping("/{itemId}") //GET으로 오는 요청 처리
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }
}