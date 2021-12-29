package com.kakao.exception;

public class IntegerFormatException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("입력 숫자값이 허용 범위가 아닙니다.");
    }
}
