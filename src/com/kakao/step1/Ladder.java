package com.kakao.step1;

import java.util.Scanner;

public class Ladder {
    private static final char LADDER_VERT = '|';
    private static final char LADDER_HORI = '-';
    private static final char LADDER_EMP = ' ';

    private static int n, m;
    private static char[][] ladder;

    private static void init() {
        Scanner scan = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        n = scan.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        m = scan.nextInt();

        ladder = new char[m][2 * n + 1];
    }

    private static void drawLadder() {
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < 2 * n + 1; col++) {
                ladder[row][col] = checkLine(col);
            }
        }
    }

    private static char checkLine(int col) {
        if (col % 2 == 0) {
            return LADDER_VERT;
        }

        if ((int) Math.round(Math.random()) == 1) {
            return LADDER_HORI;
        }

        return LADDER_EMP;
    }

    private static void printLadder() {
        StringBuilder sb = new StringBuilder(System.getProperty("line.separator"));

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < 2 * n + 1; col++) {
                sb.append(ladder[row][col]);
            }
            sb.append(System.getProperty("line.separator"));
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        init();
        drawLadder();
        printLadder();
    }
}