package com.kakao.step3.domain;

import java.util.ArrayList;

import static com.kakao.step3.config.Constants.*;

public class Validator {
    public static boolean checkPeopleNames(String[] names) {
        for (String name : names) {
            if (name.trim().length() > MAX_NAME_LEN) return false;
        }

        return true;
    }

    public static boolean checkLine(ArrayList<Boolean> points, int i) {
        return (Math.random() > RANDOM_RATE) && i == 0 ||
                (Math.random() > RANDOM_RATE) && (i > 0 && !points.get(i - 1));
    }

    public static String checkEachPoints(ArrayList<Boolean> points, int col) {
        if (col % 2 == 0) return LADDER_VERT;

        if (col > 0 && points.get((col - 1) / 2)) return LADDER_HORI;

        return LADDER_EMP;
    }
}
