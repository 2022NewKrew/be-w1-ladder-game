package laddergame;

import java.io.IOException;
import java.util.Scanner;

import laddergame.Ladder;
import laddergame.LadderIO;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        LadderIO ladderIO = new LadderIO();
        ladderIO.getNumOfPeopleIO();
        ladderIO.getLadderHeightIO();
        Ladder ladder = ladderIO.constructLadder();

        ladder.printLadder();
    }
}