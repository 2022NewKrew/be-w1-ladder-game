package com.laddergame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int peopleNum = in.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderNum = in.nextInt();

        for(int i = 0; i < ladderNum; i++) {
            System.out.println(createLadderLine(peopleNum));
        }
    }

    private static String createLadderLine(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('|');
        Random rand = new Random();
        for(int i = 0; i < n-1; i++)
            if(rand.nextBoolean())
                sb.append(" |");
            else
                sb.append("-|");
        return sb.toString();
    }
}
