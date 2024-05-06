package com.dimentials.shop.common.exception;

public class ClassCastException extends RuntimeException{
    
    public ClassCastException(String message) {
        super("ClassCastException: " + message);
    }
}
