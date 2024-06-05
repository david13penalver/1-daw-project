package com.dimentials.shop.persistence.dao.impl.jdbc.rawSql;

import java.sql.*;
import java.util.List;
import com.dimentials.shop.common.exception.RawSqlException;

public class RawSql {

    private static final DatabaseConnection dbConnection = DatabaseConnection.getInstance();

    public static ResultSet select(String sql, List<Object> params) {
        try {
            PreparedStatement preparedStatement = setParameters(sql, params);
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            throw new RawSqlException("Error executing SQL query: " + sql + e.getMessage());
        }
    }

    public static Object insert(String sql, List<Object> params) {
        try {
            PreparedStatement preparedStatement = setParameters(sql, params);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getObject(1);
            } else {
                //throw new RawSqlException("Unable to retrieve the last generated ID");
                return 0;
            }
        } catch (SQLException e) {
            throw new RawSqlException("Error executing SQL query:" + sql);
        }
    }

    public static Integer update(String sql, List<Object> params) {
        return RawSql.statement(sql, params);
    }

    public static Integer delete(String sql, List<Object> params) {
        return RawSql.statement(sql, params);
    }

    private static Integer statement(String sql, List<Object> params) {
        try {
            PreparedStatement preparedStatement = setParameters(sql, params);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RawSqlException("Error executing SQL query: " + sql);
        }
    }

    private static PreparedStatement setParameters(String sql, List<Object> values) {
        try {
            Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (values != null) {
                for (Integer i = 0; i < values.size(); i++) {
                    Object value = values.get(i);
                    preparedStatement.setObject(i + 1, value);
                }
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new RawSqlException(e.getMessage());
        }
    }

    public static void commit() {
        try {
            dbConnection.getConnection().commit();
        } catch (SQLException e) {
            throw new RawSqlException("Error committing the transaction");
        }
    }

    public static void rollback() {
        try {
            dbConnection.getConnection().rollback();
        } catch (SQLException e) {
            throw new RawSqlException("\"Error rolling back the transaction");
        }
    }
}