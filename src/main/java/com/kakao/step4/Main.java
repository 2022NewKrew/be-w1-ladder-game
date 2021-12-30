package com.kakao.step4;

import com.kakao.step4.domain.LadderGame;

public class Main {
    public static void main(String[] args) {
        try {
            new LadderGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}