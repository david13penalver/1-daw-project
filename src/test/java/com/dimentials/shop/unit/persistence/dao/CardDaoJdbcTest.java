package com.dimentials.shop.unit.persistence.dao;

import com.dimentials.shop.persistence.dao.CardDao;
import com.dimentials.shop.persistence.dao.impl.jdbc.CardDaoJdbc;
import com.dimentials.shop.persistence.dao.impl.jdbc.rawSql.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.sql.SQLException;

public class CardDaoJdbcTest {
    private final CardDao cardDao = new CardDaoJdbc();
    private static final DatabaseConnection connection = DatabaseConnection.getInstance();
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
}
