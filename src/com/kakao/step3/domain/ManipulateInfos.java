package com.kakao.step3.domain;

import static com.kakao.step3.config.Constants.MAX_NAME_LEN;

public class ManipulateInfos {
    public static String makeNameLine(String[] names) {
        StringBuilder sb = new StringBuilder();

        for (String name : names) {
            sb.append(makeNameWithBlank(name));
            sb.append(" ");
        }

        return sb.toString();
    }

    private static String makeNameWithBlank(String name) {
        int blanks = MAX_NAME_LEN - name.length();
        StringBuilder sb = new StringBuilder(name);

        fillFrontOfName(blanks, sb);
        fillBackOfName(blanks, sb);

        return sb.toString();
    }

    private static void fillFrontOfName(int blanks, StringBuilder sb) {
        int quotient = blanks / 2;
        int remainder = blanks % 2;

        for (int i = 0; i < quotient + remainder; i++) {
            sb.insert(0, " ");
        }
    }

    private static void fillBackOfName(int blanks, StringBuilder sb) {
        int quotient = blanks / 2;

        for (int i = 0; i < quotient; i++) {
            sb.append(" ");
        }
    }

    public static String[] trimAllNames(String[] names) {
        for (int i = 0, size = names.length; i < size; i++) {
            names[i] = names[i].trim();
        }

        return names;
    }
}
