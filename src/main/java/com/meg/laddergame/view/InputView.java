package com.meg.laddergame.view;

import com.meg.laddergame.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> askNames() {
        try {
            System.out.println("참여할 사람이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> names = Arrays.asList(sc.next().split(","));
            Validator.checkName(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askNames();
        }
    }

    public static List<String> askResult() {
        try {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            List<String> results = Arrays.asList(sc.next().split(","));
            Validator.checkName(results);
            return results;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askNames();
        }
    }

    public static int askHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int height = sc.nextInt();
            Validator.checkHeight(height);
            return height;
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 높이를 1자 이상 입력해주세요.");
            return askHeight();
        }
    }

    public static String askResultOfUser() {
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.next();
    }

}
