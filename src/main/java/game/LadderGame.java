package game;

import game.frontendapi.apptouser.UserScreenOutput;
import game.frontendapi.usertoapp.UserInput;

import java.util.Random;

public class LadderGame implements Game {

    // 사다리 출력 모양 지정을 위한 상수
    private static final char LADDER_LINE = '|';
    private static final char LADDER_CROSS = '-';
    private static final char LADDER_EMPTY = ' ';

    // 사다리 정보를 저장하는 2차원 배열 맴버 변수
    private int[][] ladder;

    // 참여할 사람 및 사다리 높이 저장 맴버 변수
    private Integer numOfPlayer;
    private Integer heightOfLadder;

    // 유저와의 인터페이스 방법을 저장하는 맴버 변수
    private final UserInput<String, Integer> userInput;
    private final UserScreenOutput<String> userScreenOutput;

    public LadderGame(UserInput<String, Integer> userInput, UserScreenOutput<String> userScreenOutput) {
        // 게임 생성 시 유저 인터페이스 방법을 매개변수로 받아서 저장
        this.userInput = userInput;
        this.userScreenOutput = userScreenOutput;
    }

    @Override
    public void init() {
        // 참여자 수 및 최대 사다리 높이 저장
        numOfPlayer = this.userInput.askToUser("참여할 사람은 몇명인가요?");
        heightOfLadder = this.userInput.askToUser("최대 사다리 높이는 몇 개인가요?");
    }

    @Override
    public void start() {
        // 사다리 가로줄 여부를 랜덤으로 지정하여 사다리 생성
        makingLadder();
    }

    // 클래스의 ladder 변수에 저장된 정보를 바탕으로 사다리 인쇄
    @Override
    public void printResult() {
        StringBuilder sb = new StringBuilder();
        makeOutputString(sb);
        userScreenOutput.output(sb.toString());
    }

    // 유저에게 보여줄 최종 결과를 StringBuilder 에 저장하는 메서드
    private void makeOutputString(StringBuilder sb) {
        // 사다리의 높이 만큼 반복하여 출력문을 작성한다.
        for (int i = 0; i < heightOfLadder; i++) {
            sb.append("\n|");
            // 사다리 1개 층의 출력문을 생성한다.
            makeOutputStringOneLayer(sb, i);
        }
    }


    // 유저에게 보여줄 최종 결과물 중 한개 라인을 작성하는 메서드
    private void makeOutputStringOneLayer(StringBuilder sb, int floor) {
        for (int j = 0; j < (numOfPlayer - 1); j++) {
            sb.append((ladder[floor][j] == 0) ? LADDER_EMPTY : LADDER_CROSS).append(LADDER_LINE);
        }
    }


    // 랜덤 사다리 정보를 2차원 int 배열로 생성하여 클래스의 ladder 멤버 변수에 저장
    private void makingLadder() {
        Random random = new Random();
        ladder = new int[heightOfLadder][numOfPlayer];
        for (int i = 0; i < heightOfLadder; i++) {
            makingLadderOneFloor(i, random);
        }
    }

    private void makingLadderOneFloor(int floor, Random random) {
        for (int j = 0; j < (numOfPlayer - 1); j++) {
            ladder[floor][j] = (random.nextInt() < 1) ? 0 : 1;
        }
    }
}
