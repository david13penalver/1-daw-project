package com.dimentials.shop.persistence.dao.impl.jdbc.rawSql;

import com.dimentials.shop.common.AppPropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.LogManager;


public class DBConnection {

    private final Connection connection;

    public DBConnection() {
        LogManager.getLogManager().getLogger("").info("Establishing connection with the database...");
        try {
            connection = DriverManager.getConnection(
                    AppPropertiesReader.getProperty("dimentials.datasource.url"),
                    AppPropertiesReader.getProperty("dimentials.datasource.username"),
                    AppPropertiesReader.getProperty("dimentials.datasource.password")
            );
            String autocommitPropertyValue = AppPropertiesReader.getProperty("dimentials.autocommit");
            if(autocommitPropertyValue != null) {
                boolean autocommitValue = Boolean.parseBoolean(autocommitPropertyValue);
                connection.setAutoCommit(autocommitValue);
            }
            LogManager.getLogManager().getLogger("").info("Connection established with the database");
        } catch (SQLException e) {
            LogManager.getLogManager().getLogger("").severe("Error connecting to the database. Connection parameters: " + getParameters());
            throw new RuntimeException("Connection paramaters :\n\n" + getParameters() + "\nOriginal exception message: " + e.getMessage());
        }
    }


    private String getParameters (){
        return String.format("url: %s\nUser: %s\nPassword: %s\n",
                AppPropertiesReader.getProperty("dimentials.datasource.url"),
                AppPropertiesReader.getProperty("dimentials.datasource.username"),
                AppPropertiesReader.getProperty("dimentials.datasource.password")
        );
    }

    public Connection getConnection() {
        return connection;
    }
}