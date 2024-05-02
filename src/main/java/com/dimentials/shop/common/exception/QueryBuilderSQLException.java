package com.dimentials.shop.common.exception;

public class QueryBuilderSQLException extends RuntimeException{

    public QueryBuilderSQLException(String message) {
        super("SQL exception: " + message);
    }
}