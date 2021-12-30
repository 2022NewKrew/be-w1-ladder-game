package com.kakao.ladder.step5;

import com.kakao.ladder.step5.domain.Ladder;
import com.kakao.ladder.step5.view.InputLadder;
import com.kakao.ladder.step5.view.LadderPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {

        List<String> peoples = InputLadder.inputPeoples();
        List<String> resultList = InputLadder.inputResults();
        int height = InputLadder.inputHeight();
        System.out.println();

        Ladder ladder = new Ladder(peoples, resultList, height);
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        ladderPrinter.printLadder();
        ladderPrinter.printResults();
    }
}
