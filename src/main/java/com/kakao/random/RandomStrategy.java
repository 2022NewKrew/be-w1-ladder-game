package com.kakao.random;

@FunctionalInterface // 함수 하나만 존재하는 인터페이스 ( lambda 표현 가능 )
public interface RandomStrategy<T>{
    // 인터페이스 제네릭
    public T random();
}
