package com.gunyoung.one.view;

import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public int inputIntWithMessage(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public void output(String str) {
        System.out.println(str);
    }
}
