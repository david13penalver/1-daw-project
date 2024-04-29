package com.dimentials.shop.common.exception;

public class AppReaderException extends RuntimeException{

    public AppReaderException(String message) {
        super("AppReader exception: " + message);
    }
}