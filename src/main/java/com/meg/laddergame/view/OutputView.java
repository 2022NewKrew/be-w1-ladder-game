package com.meg.laddergame.view;

import com.meg.laddergame.domain.Line;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class OutputView {

    public static void printLadder(List<Line> ladder, List<String> users, List<String> results) {
        System.out.println("사다리 결과");
        printNames(users, 5);
        for (Line row : ladder) {
            printLadderLine(row);
        }
        printNames(results, 5);
    }

    private static void printNames(List<String> users, int space) {
        for (String user : users) {
            printNameWithSpace(user, space+1);
        }
        System.out.println();
    }

    private static void printNameWithSpace(String user, int space) {
        int frontSpace = (space - user.length()) / 2;
        for (int i = 0; i < frontSpace; i++) {
            System.out.print(" ");
        }
        System.out.print(user);
        for (int i = 0; i < space - frontSpace - user.length(); i++) {
            System.out.print(" ");
        }
    }

    private static void printLadderLine(Line row) {
        System.out.print("  |");
        for (Boolean isTrue : row.getpoints()) {
            System.out.print(isTrue ? "-----|" : "     |");
        }
        System.out.println();
    }

    public static void printResultOfUser(Map<String, String> results, String user) {
        if (!results.containsKey(user)) {
            throw new NoSuchElementException();
        }
        System.out.println("실행결과");
        System.out.println(results.get(user));

    }

    public static void printResultOfAll(Map<String, String> results) {
        System.out.println("실행결과");
        for (Map.Entry<String, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

