package com.laddergame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LadderGameApplication {

    public static void main(String[] args) {
        System.out.println("참여할 사람은 몇 명인가요?");
        Scanner scanner = new Scanner(System.in);
        int participantNumber = scanner.nextInt();
        System.out.println(participantNumber);

        System.out.println("최대 사다리 높이는 몇인가요?");
        int ladderHeight = scanner.nextInt();
        System.out.println(ladderHeight);
        ArrayList<String> result = new ArrayList<>(5);

        for(int i = 0; i < ladderHeight; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < participantNumber - 1; j++) {
                sb.append("|");
                int randomNumber = new Random().nextInt(10);
                String singleResult = randomNumber < 10 / 2 ? "-" : " ";
                sb.append(singleResult);
            }
            sb.append("|");
            result.add(sb.toString());
        }

        result.forEach(System.out::println);
    }
}
