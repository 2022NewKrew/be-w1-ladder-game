package com.kakao.ladder;

import com.kakao.ladder.controller.LadderGameController;

public class LadderMain {
    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController();
        controller.start();
    }
}