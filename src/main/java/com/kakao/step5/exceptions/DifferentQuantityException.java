package com.kakao.step5.exceptions;

public class DifferentQuantityException extends RuntimeException {
    public DifferentQuantityException(int namesSize, int resultsSize) {
        super(String.format("입력하신 결과와 이름의 개수가 일치하지 않습니다. (이름 개수 = %d, 결과 개수 = %d", namesSize, resultsSize));
    }
}
