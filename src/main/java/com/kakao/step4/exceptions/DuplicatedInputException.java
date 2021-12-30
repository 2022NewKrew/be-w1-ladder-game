package com.kakao.step4.exceptions;

public class DuplicatedInputException extends RuntimeException {
    public DuplicatedInputException(String message) {
        super(message);
    }
}
