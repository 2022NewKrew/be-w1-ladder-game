package com.kakao.step3_2.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final int MAX_NAME_LEN = 5;

    private final List<String> namesList;

    public Names(String namesStr) throws Exception {
        if (namesStr.trim().isEmpty()) {
            throw new Exception("조건에 맞지 않는 이름이 입력되었습니다.");
        }

        this.namesList = Arrays.stream(namesStr.split(","))
                .map(String::trim)
                .map(s -> StringUtils.left(s, MAX_NAME_LEN))
                .collect(Collectors.toList());
    }

    public int getSize() {
        return namesList.size();
    }

    @Override
    public String toString() {
        return "   " + namesList
                .stream()
                .map(this::makeNameWithBlank)
                .collect(Collectors.joining(" ")) + "\n";
    }

    private String makeNameWithBlank(String name) {
        int blanks = MAX_NAME_LEN - name.length();
        StringBuilder sb = new StringBuilder(name);

        fillFrontOfName(blanks, sb);
        fillBackOfName(blanks, sb);

        return sb.toString();
    }

    private void fillFrontOfName(int blanks, StringBuilder sb) {
        int quotient = blanks / 2;
        int remainder = blanks % 2;

        for (int i = 0; i < quotient + remainder; i++) {
            sb.insert(0, " ");
        }
    }

    private void fillBackOfName(int blanks, StringBuilder sb) {
        int quotient = blanks / 2;

        sb.append(" ".repeat(Math.max(0, quotient)));
    }
}
