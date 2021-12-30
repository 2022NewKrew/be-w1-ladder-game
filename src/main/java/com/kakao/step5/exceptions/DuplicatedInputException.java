package com.kakao.step5.exceptions;

public class DuplicatedInputException extends RuntimeException {
    public DuplicatedInputException(String message) {
        super(message);
    }
}
