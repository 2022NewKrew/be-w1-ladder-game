package com.kakao.step5.domain.model;

import com.kakao.step5.exceptions.DifferentQuantityException;
import com.kakao.step5.exceptions.EmptyInputException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final int MAX_RESULT_LEN = 5;

    private List<String> resultsList;

    public Results(String resultsStr, int namesSize) {
        checkBeforeMakeResultsList(resultsStr);

        this.resultsList = Arrays.stream(resultsStr.split(","))
                .map(String::trim)
                .map(s -> StringUtils.left(s, MAX_RESULT_LEN))
                .collect(Collectors.toList());

        checkAfterMakeResultsList(namesSize);
    }

    private void checkBeforeMakeResultsList(String namesStr) {
        if (namesStr.trim().isEmpty()) {
            throw new EmptyInputException("입력하신 결과에 빈 칸만 존재합니다.");
        }
    }

    private void checkAfterMakeResultsList(int namesSize) {
        if (this.resultsList.isEmpty() || this.resultsList.stream()
                .anyMatch(s -> s.length() == 0))
            throw new EmptyInputException("입력하신 결과 중 빈 칸만 입력된 결과 값이 존재합니다.");
        if (this.resultsList.size() != namesSize)
            throw new DifferentQuantityException(namesSize, this.resultsList.size());
    }

    public String resultOf(int i) {
        return resultsList.get(i);
    }

    @Override
    public String toString() {
        return "   " + resultsList
                .stream()
                .map(s -> StringUtils.center(s, MAX_RESULT_LEN))
                .collect(Collectors.joining(" ")) + "\n";
    }
}
