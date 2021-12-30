package com.kakao.ladder.step5.view;

import com.kakao.ladder.step5.domain.Ladder;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LadderPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public void printTest(String people, String result) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Ladder ladder = new Ladder();
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        System.setOut(new PrintStream(outContent));
        Method method = ladderPrinter.getClass().getDeclaredMethod("printPeople", String.class);
        method.setAccessible(true);

        method.invoke(ladderPrinter, people);
        assertEquals(result, outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void lengthMoreThanFiveTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String people = "abcdefgh";
        String result = "abcde ";
        printTest(people, result);
    }

    @Test
    public void lengthFiveTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String people = "abcde";
        String result = "abcde ";
        printTest(people, result);
    }

    @Test
    public void lengthFourTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String people = "abcd";
        String result = "abcd  ";
        printTest(people, result);
    }

    @Test
    public void lengthThreeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String people = "abc";
        String result = "abc   ";
        printTest(people, result);
    }

    @Test
    public void lengthTwoTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String people = "ab";
        String result = "ab    ";
        printTest(people, result);
    }

    @Test
    public void lengthOneTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String people = "a";
        String result = "a     ";
        printTest(people, result);
    }

}