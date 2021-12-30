package com.kakao.exception;

public class RewardFormatException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("입력 결과가 유효하지 않습니다.");
    }
}
