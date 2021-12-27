package com.kakaocorp.laddergame;

import java.util.*;

public class LadderGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int number = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        sc.close();

        List<String> ladder = getLadder(number, height);
        ladder.forEach(System.out::println);
    }

    public static List<String> getLadder(int number, int height) {
        List<String> ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            for (int j = 0; j < number - 1; j++) {
                String barOrBlank = getBarOrBlank();
                sb.append(barOrBlank);
                sb.append("|");
            }
            ladder.add(sb.toString());
        }

        return ladder;
    }

    public static String getBarOrBlank() {
        List<String> items = Arrays.asList("-", " ");
        Random rand = new Random();

        return items.get(rand.nextInt(items.size()));
    }

}
