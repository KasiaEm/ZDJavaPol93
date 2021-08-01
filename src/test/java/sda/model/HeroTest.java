package sda.model;

import org.junit.jupiter.api.Test;
import sda.model.enums.Race;

import static org.assertj.core.api.Assertions.assertThat;

class HeroTest {

    @Test
    void addToInventoryNotExisting() {
        //given
        Hero hero = new Hero("Andrzej", Race.HUMAN);
        InventoryObject obj1 = new InventoryObject("Apple", 0.1);

        //when
        hero.addToInventory(obj1);

        //then
        assertThat(hero.getInventory()[0]).isEqualTo(obj1);
    }
}