package com.gradle.geatrigger;

import java.util.Scanner;

public class LadderGame {
    static int[][] ladder;
    static int cnt, height;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        cnt = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
        ladder = new int[height][cnt];
        MakeLadder();
        DrawLadder();
    }

    private static void MakeLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < cnt - 1; j++) {
                if (Math.random() > 0.5)
                    ladder[i][j] = 1;
                else
                    ladder[i][j] = 0;
            }
            ladder[i][cnt - 1] = 0;
        }
    }

    private static void DrawLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < cnt; j++) {
                DrawVertical();
                DrawHorizon(ladder[i][j]);
            }
            System.out.println();
        }
    }

    private static void DrawHorizon(int cnt) {
        for (int i = 0; i < cnt; i++)
            System.out.print("-");
        if (cnt == 0)
            System.out.print(" ");
    }

    private static void DrawVertical() {
        System.out.print("|");
    }
}
