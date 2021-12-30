package com.gunyoung.one.exceptions;

public class EmptyUserNameException extends BusinessException {
    public EmptyUserNameException(String message) {
        super(message);
    }
}
