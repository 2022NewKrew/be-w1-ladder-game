package step1;

import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    private Boolean[][] ladder;

    private int numOfPeople;
    private int height;

    public void start() {
        inputHeightAndNumOfPeople();
        generateLadder();
        printLadder();
    }

    private void inputHeightAndNumOfPeople() {
        try (Scanner sc = new Scanner(System.in)) {
            inputHeight(sc);
            inputNumOfPeople(sc);
        }
    }

    private void inputNumOfPeople(Scanner sc) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    private void inputHeight(Scanner sc) {
        System.out.println("참여할 사람은 몇 명인가요?");
        numOfPeople = sc.nextInt();
    }

    private void generateLadder() {
        initLadderSize();
        generateRandomBranch();
    }

    private void initLadderSize() {
        final int ladderWidth = numOfPeople - 1;
        final int ladderHeight = height;

        ladder = new Boolean[ladderHeight][ladderWidth];
    }

    private void generateRandomBranch() {
        final Random random = new Random();

        for (int i = 0; i < ladder.length; ++i) {
            for (int j = 0; j < ladder[i].length; ++j) {
                ladder[i][j] = random.nextBoolean();
                disconnectIfExistAtLeft(i, j);
            }
        }
    }

    private void disconnectIfExistAtLeft(int row, int col) {
        if (col > 0 && ladder[row][col - 1]) {
            ladder[row][col] = false;
        }
    }

    private void printLadder() {
        final StringBuilder sb = new StringBuilder();

        for (Boolean[] row : ladder) {
            for (Boolean col : row) {
                sb.append('|');
                sb.append(col ? '-' : ' ');
            }
            sb.append("|\n");
        }

        System.out.println(sb);
    }
}
