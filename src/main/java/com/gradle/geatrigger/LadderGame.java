package com.gradle.geatrigger;

import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        int cnt, height;
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        cnt = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
        DrawLadder(cnt, height);
    }

    private static void DrawLadder(int cnt, int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < cnt - 1; j++) {
                DrawVertical();
                DrawHorizon();
            }
            DrawVertical();
            System.out.println();
        }
    }

    private static void DrawHorizon() {
        if (Math.random() > 0.5)
            System.out.print("-");
        else
            System.out.print(" ");
    }

    private static void DrawVertical() {
        System.out.print("|");
    }
}
