package com.kakao.ladder.step4.view;

import com.kakao.ladder.step4.domain.Ladder;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /*
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    */

    @Test
    public void lengthMoreThanFiveTest() {

        Ladder ladder = new Ladder();
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        System.setOut(new PrintStream(outContent));

        String name = "abcdefgh";
        ladderPrinter.printPeople(name);
        assertEquals("abcde ", outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void lengthFiveTest() {

        Ladder ladder = new Ladder();
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        System.setOut(new PrintStream(outContent));

        String name = "abcde";
        ladderPrinter.printPeople(name);
        assertEquals("abcde ", outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void lengthFourTest() {

        Ladder ladder = new Ladder();
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        System.setOut(new PrintStream(outContent));

        String name = "abcd";
        ladderPrinter.printPeople(name);
        assertEquals("abcd  ", outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void lengthThreeTest() {

        Ladder ladder = new Ladder();
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        System.setOut(new PrintStream(outContent));

        String name = "abc";
        ladderPrinter.printPeople(name);
        assertEquals("abc   ", outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void lengthTwoTest() {

        Ladder ladder = new Ladder();
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        System.setOut(new PrintStream(outContent));

        String name = "ab";
        ladderPrinter.printPeople(name);
        assertEquals("ab    ", outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void lengthOneTest() {

        Ladder ladder = new Ladder();
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        System.setOut(new PrintStream(outContent));

        String name = "a";
        ladderPrinter.printPeople(name);
        assertEquals("a     ", outContent.toString());

        System.setOut(originalOut);
    }

}