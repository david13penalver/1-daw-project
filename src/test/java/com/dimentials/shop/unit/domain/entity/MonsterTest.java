package test.java.com.dimentials.shop.unit.domain.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import com.dimentials.shop.domain.entity.Monster;

public class MonsterTest {

    @Test
    @DisplayName("Monster constructor with all parameters")
    public void testMonsterConstructorWithAllParameters() {
        Monster monster = new Monster(1, "Monster Name", "Monster Description", 10, 10, "Monster Type",
                "Monster Type2");
        assertAll(
                () -> assertEquals(1, monster.getId()),
                () -> assertEquals("Monster Name", monster.getName()),
                () -> assertEquals("Monster Description", monster.getDescription()),
                () -> assertEquals(10, monster.getAttack()),
                () -> assertEquals(10, monster.getLife()),
                () -> assertEquals("Monster Type", monster.getMainType()),
                () -> assertEquals("Monster Type2", monster.getSecondaryType())

        );

    }

    @Test
    @DisplayName("Monster constructor with all and id, name, description and price")
  public void testConstructor2() {
        Monster monster = new Monster(1, "Monster Name", "Monster Description", new BigDecimal("10.00"), 10, 10, "Monster Type",
                "Monster Type2");

        assertAll(
                () -> assertEquals(1, monster.getId()),
                () -> assertEquals("Monster Name", monster.getName()),
                () -> assertEquals("Monster Description", monster.getDescription()),
                () -> assertEquals(new BigDecimal("10.00"), monster.getPrice()),
                () -> assertEquals(10, monster.getAttack()),
                () -> assertEquals(10, monster.getLife()),
                () -> assertEquals("Monster Type", monster.getMainType()),
                () -> assertEquals("Monster Type2", monster.getSecondaryType()
                )
        );
    }

}
