package com.kakaocorp.laddergame.ladder.domain;

import com.kakaocorp.laddergame.ladder.view.LadderView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

class NameLadderTest {

    private static final Random rand = new Random();

    // lineTypes 리스트 조건 만족 랜덤 테스트 10000번
    @Test
    void lineTypesConditionRandomTest() {
        for (int i = 0; i < 10000; i++) {
            Line line = new Line(rand.nextInt(10000));
            List<Boolean> lineTypes = line.getLineTypes();

            // 무작위로 생성한 lineTypes 리스트에 true 값이 연속으로 나오는 경우가 있는지 체크
            testLine(lineTypes);
        }
    }

    private void testLine(List<Boolean> lineTypes) {
        for (int j = 0; j < lineTypes.size()-1; j++) {
            Assertions.assertFalse(lineTypes.get(j) && lineTypes.get(j + 1));
        }
    }

    @Test
    void printLimitTest() throws FileNotFoundException {
        LadderView ladderView = new LadderView();
        String resourceName = "PrintLimitTest.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        Scanner sc = new Scanner(new File(classLoader.getResource(resourceName).getFile()));

        List<String> members = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        for (String member : members) {
            Assertions.assertEquals(6, ladderView.sliceName(member).length());
        }
    }
}