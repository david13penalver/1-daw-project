//package com.dimentials.shop.persistence.dao.impl.jdbc.rawSql;
//
//import com.dimentials.shop.common.AppPropertiesReader;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.logging.LogManager;
//
//public class DBConnection {
//
//    private final Connection connection;
//
//    public DBConnection() {
//        LogManager.getLogManager().getLogger("").info("Establishing connection with the database...");
//        try {
//            connection = DriverManager.getConnection(
//                    AppPropertiesReader.getProperty("dimentials.datasource.url"),
//                    AppPropertiesReader.getProperty("dimentials.datasource.username"),
//                    AppPropertiesReader.getProperty("dimentials.datasource.password"));
//            String autocommitPropertyValue = AppPropertiesReader.getProperty("dimentials.autocommit");
//            if (autocommitPropertyValue != null) {
//                boolean autocommitValue = Boolean.parseBoolean(autocommitPropertyValue);
//                connection.setAutoCommit(autocommitValue);
//            }
//            LogManager.getLogManager().getLogger("").info("Connection established with the database");
//        } catch (SQLException e) {
//            LogManager.getLogManager().getLogger("")
//                    .severe("Error connecting to the database. Connection parameters: " + getParameters());
//            throw new RuntimeException("Connection paramaters :\n\n" + getParameters()
//                    + "\nOriginal exception message: " + e.getMessage());
//        }
//    }
//
//    private String getParameters() {
//        String url = AppPropertiesReader.getProperty("dimentials.datasource.url");
//        String username = AppPropertiesReader.getProperty("dimentials.datasource.username");
//        String password = AppPropertiesReader.getProperty("dimentials.datasource.password");
//
//        if (url == null) {
//            throw new RuntimeException("URL not found in properties");
//        }
//        if (username == null) {
//            throw new RuntimeException("Username not found in properties");
//        }
//        if (password == null) {
//            throw new RuntimeException("Password not found in properties");
//        }
//
//        return String.format("url: %s\nUser: %s\nPassword: %s\n", url, username, password);
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//}