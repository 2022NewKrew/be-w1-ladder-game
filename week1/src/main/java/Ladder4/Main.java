package Ladder4;

import Ladder4.Domain.Ladder;

public class Main {

    // 명세에는 없지만 사이즈 조절 기능 추가
    private static final int BRIDGE_SIZE = 5;

    public static void main(String[] args) {
        Ladder ladder = new Ladder(BRIDGE_SIZE);
        System.out.println(ladder);
    }
}
