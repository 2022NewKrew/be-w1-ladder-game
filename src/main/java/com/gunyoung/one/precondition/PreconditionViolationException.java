package com.gunyoung.one.precondition;

public class PreconditionViolationException extends RuntimeException {
    PreconditionViolationException(String msg) {
        super(msg);
    }
}
