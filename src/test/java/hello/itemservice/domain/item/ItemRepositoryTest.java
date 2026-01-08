package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void tearDown() {
        itemRepository.clear();
    }

    @Test
    void save() {
        Item item = new Item("test", 1000, 10);

        Item savedItem = itemRepository.save(item);

        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        Item item1 = new Item("test1", 1000, 10);
        Item item2 = new Item("test2", 2000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        Assertions.assertThat(itemRepository.findAll()).contains(item1, item2);
    }

    @Test
    void updateItem() {
        Item item = new Item("test", 1000, 10);

        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        Item updateParam = new Item("updated", 10000, 100);
        itemRepository.update(itemId, updateParam);

        Item findItem = itemRepository.findById(itemId);

        Assertions.assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        Assertions.assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        Assertions.assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}