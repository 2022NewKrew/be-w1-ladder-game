package com.meg.laddergame.validation;

import java.util.List;

public class Validator {

    public static void checkHeight(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("1자 이상 입력하세요.");
        }
    }

    public static void checkName(List<String> names) {
        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() <= 0 || name.length() > 5) {
            throw new IllegalArgumentException("단어는 1자 이상 5자 이하로 입력하세요.");
        }
    }
}
