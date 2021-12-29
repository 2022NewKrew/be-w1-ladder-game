package com.kakaocorp.laddergame.ladder;

import java.util.*;

public class SimpleLadder extends Ladder {

    final private List<String> rowItems = Arrays.asList("-", " ");

    @Override
    public boolean start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        setNumber(sc.nextInt());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        setHeight(sc.nextInt());
        sc.close();

        // SimpleLadder에서는 입력 값 검증 X
        return true;
    }

    @Override
    public void makeLadder() {
        ladder = new ArrayList<>();

        for (int i = 0; i < getHeight(); i++) {
            ladder.add(makeRow());
        }
    }

    @Override
    public void printLadder() {
        ladder.forEach(System.out::println);
    }

    private String makeRow() {
        StringBuilder sb = new StringBuilder();

        sb.append("|");
        for (int j = 0; j < getNumber() - 1; j++) {
            String barOrBlank = getBarOrBlank();
            sb.append(barOrBlank);
            sb.append("|");
        }

        return sb.toString();
    }

    public String getBarOrBlank() {
        return rowItems.get(rand.nextInt(rowItems.size()));
    }
}
