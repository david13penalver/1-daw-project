package com.dimentials.shop.unit.persistence.dao;

import com.dimentials.shop.domain.entity.Card;
import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.entity.CardEntity;
import com.dimentials.shop.persistence.dao.entity.MonsterEntity;
import com.dimentials.shop.persistence.dao.entity.SpellEntity;
import com.dimentials.shop.persistence.dao.impl.jdbc.CardDaoJdbc;
import com.dimentials.shop.persistence.dao.impl.jdbc.rawSql.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardDaoJdbcTest {
    private final CardDao cardDao = new CardDaoJdbc();
    private static final DatabaseConnection connection = DatabaseConnection.getInstance();
    public final List<CardEntity> expectedLlibreList = List.of(
            new CardEntity(1, "Lavacus", "Escudo (1): Genera 1 de armadura al final de cada uno de tus turnos. La armadura se suma a la vida y se consume cuando tu legión dimensional es atacada. La armadura de esta habilidad es acumulable y la que no es consumida permanece incluso cuando la legión evoluciona.", new BigDecimal(7), "image"),
            new CardEntity(2, "Pyromagmus", "Armadura (6): Al entrar en combate, se suma 6 de armadura hasta el principio de su siguiente turno. La armadura se suma a la vida y se consume primero cuando la legión dimential es atacada.", new BigDecimal(7), "image")
    );
    @BeforeAll
    static void setup() throws SQLException {
        connection.executeScript("schema.sql");
        connection.executeScript("data.sql");
        connection.getConnection().setAutoCommit(false);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.getConnection().rollback();
    }

    @Test
    void findAll_shouldReturnAllCards() {
        List<CardEntity> result = cardDao.findAll();
        assertEquals(expectedLlibreList, result);
    }

    @Test
    void findById_shouldReturnCard() {
        CardEntity result = cardDao.findById(1);
        assertEquals(expectedLlibreList.get(0), result);
    }

}
