package com.kakao.step4.domain.model;

import com.kakao.step4.exceptions.DuplicatedInputException;
import com.kakao.step4.exceptions.EmptyInputException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final int MAX_NAME_LEN = 5;

    private final List<String> namesList;

    public Names(String namesStr) {
        checkBeforeMakeNamesList(namesStr);

        this.namesList = Arrays.stream(namesStr.split(","))
                .map(String::trim)
                .map(s -> StringUtils.left(s, MAX_NAME_LEN))
                .collect(Collectors.toList());

        checkAfterMakeNamesList();
    }

    private void checkBeforeMakeNamesList(String namesStr) {
        if (namesStr.trim().isEmpty()) {
            throw new EmptyInputException("입력하신 이름에 빈 칸만 존재합니다.");
        }
    }

    private void checkAfterMakeNamesList() {
        if (this.namesList.isEmpty() ||
                this.namesList.stream()
                .anyMatch(s -> s.length() == 0)) {
            throw new EmptyInputException("입력하신 이름 중 빈 칸만 입력된 이름이 존재합니다.");
        }

        if (new HashSet<>(namesList).size() != this.namesList.size())
            throw new DuplicatedInputException("입력하신 이름 중 중복된 이름이 존재합니다.");
    }

    public int getSize() {
        return namesList.size();
    }

    @Override
    public String toString() {
        return "   " + namesList
                .stream()
                .map(s -> StringUtils.center(s, MAX_NAME_LEN))
                .collect(Collectors.joining(" ")) + "\n";
    }
}
