package com.dimentials.shop.common.exception;

public class RawSqlException extends RuntimeException{

    public RawSqlException(String message) {
        super("Raw SQL exception: " + message);
    }
}