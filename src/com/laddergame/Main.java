package com.laddergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        ArrayList<String> peopleNames = new ArrayList<>(Arrays.asList(in.next().split(",")));
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderNum = in.nextInt();

        Ladder ladder = new Ladder(peopleNames, ladderNum);
        System.out.println(ladder);
    }
}
