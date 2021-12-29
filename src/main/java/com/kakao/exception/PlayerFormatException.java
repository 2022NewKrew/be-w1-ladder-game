package com.kakao.exception;

public class PlayerFormatException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("플레이어 이름의 길이가 허용 범위가 아닙니다.");
    }
}
