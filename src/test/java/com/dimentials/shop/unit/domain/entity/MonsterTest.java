package com.dimentials.shop.unit.domain.entity;

import com.dimentials.shop.domain.entity.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import com.dimentials.shop.domain.entity.Monster;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {

    @Test
    @DisplayName("Monster constructor withour price")
    public void testMonsterConstructorWithoutPrice() {
        Monster monster = new Monster(1, "Monster Name", "Monster Description", "test.png", 10, 10, "Monster Type",
                "Monster Type2");
        assertAll(
                () -> assertEquals(1, monster.getId()),
                () -> assertEquals("Monster Name", monster.getName()),
                () -> assertEquals("Monster Description", monster.getDescription()),
                () -> assertEquals(10, monster.getAttack()),
                () -> assertEquals(10, monster.getLife()),
                () -> assertEquals("Monster Type", monster.getMainType()),
                () -> assertEquals("Monster Type2", monster.getSecondaryType()),
                () -> assertEquals("test.png", monster.getImgPath())

        );

    }

    @Test
    @DisplayName("Monster constructor with all parameters")
  public void testConstructorWithIdNameDescriptionPriceAttackLifeTypes() {
        Monster monster = new Monster(1, "Monster Name", "Monster Description", new BigDecimal("10.00"), "test.png", 10, 10, "Monster Type",
                "Monster Type2");

        assertAll(
                () -> assertEquals(1, monster.getId()),
                () -> assertEquals("Monster Name", monster.getName()),
                () -> assertEquals("Monster Description", monster.getDescription()),
                () -> assertEquals(new BigDecimal("10.00"), monster.getPrice()),
                () -> assertEquals("test.png", monster.getImgPath()),
                () -> assertEquals(10, monster.getAttack()),
                () -> assertEquals(10, monster.getLife()),
                () -> assertEquals("Monster Type", monster.getMainType()),
                () -> assertEquals("Monster Type2", monster.getSecondaryType()
                )
        );
    }

    @Test
    void testEmptyConstructor() {
        Monster monster = new Monster();
        assertNotNull(monster);
    }

}
