package com.kakao.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    private final List<String> participants = new ArrayList<>();

    LineTest() {
        for (int i = 0; i < 3; i++) {
            participants.add("test" + i);
        }
    }

    @DisplayName("Step 만들기")
    @RepeatedTest(10)
    void testMakeStep(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());

        Line line = new Line(participants);
        List<Step> stepLine = line.getStepLine();
        Step lastStep = stepLine.get(stepLine.size()-1);
//        Step newStep = line.makeStep();

//        if (lastStep.isStep()) {
//            assertFalse(newStep.isStep());
//        }
//
//        System.out.println(lastStep.isStep() + " " + newStep.isStep() + "\n");

//        # Reflection을 이용한 private method 테스트를 하려 했으나 실패하였습니다..
//
//        Method[] methods = Line.class.getDeclaredMethods();
//        Method method = (Method) Arrays.stream(methods).filter(method1 ->
//                method1.getName() == "makeStep"
//        ).toArray()[0];
//        method.setAccessible(true);
//
//        Step step = method.invoke(line);
//        System.out.println(step);

    }

}