package game;

import game.frontendapi.apptouser.UserScreenOutput;
import game.frontendapi.usertoapp.UserInput;
import game.ladder.LadderWhole;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LadderGame implements Game {

    private final String INPUT_MESSAGE_FOR_NAMES = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String INPUT_MESSAGE_FOR_RESULT = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final String INPUT_MESSAGE_FOR_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private final String INPUT_MESSAGE_FOR_SINGLE_RESULT = "\n결과를 보고 싶은 사람은?";

    // 유저와의 인터페이스 방법을 저장하는 맴버 변수
    private final UserInput<String, ArrayList<String>> userPlayersNamesInput;
    private final UserInput<String, Integer> userLadderHeightInput;
    private final UserScreenOutput<String> userScreenOutput;

    // 사다리 객체
    private LadderWhole ladder;

    public LadderGame(UserInput<String, ArrayList<String>> userPlayersNamesInput, UserInput<String, Integer> userLadderHeightInput, UserScreenOutput<String> userScreenOutput) {
        // 게임 생성 시 유저 인터페이스 방법을 매개변수로 받아서 저장
        this.userPlayersNamesInput = userPlayersNamesInput;
        this.userLadderHeightInput = userLadderHeightInput;
        this.userScreenOutput = userScreenOutput;
    }


    @Override
    public void init() throws Exception {
        // 참여자 수 및 최대 사다리 높이 저장
        ArrayList<String> playerNameArrayList = userPlayersNamesInput.askToUser(INPUT_MESSAGE_FOR_NAMES);
        int numOfPlayer = playerNameArrayList.size();
        ArrayList<String> ladderResultList = userPlayersNamesInput.askToUser(INPUT_MESSAGE_FOR_RESULT);

        //  사다리 수와 결과 수가 일치하는지 확인
        if (numOfPlayer != ladderResultList.size()) {
            throw new Exception("참여자 수와 결과값 수가 다릅니다!");
        }

        int heightOfLadder = userLadderHeightInput.askToUser(INPUT_MESSAGE_FOR_HEIGHT);
        // 사다리 객체 생성
        ladder = new LadderWhole(heightOfLadder, numOfPlayer, playerNameArrayList, ladderResultList);
    }

    @Override
    public void start() {
        // 사다리 가로줄 여부를 랜덤으로 지정하여 사다리 생성
        ladder.makeRandomBridgesAll();
    }

    // 클래스의 ladder 변수에 저장된 정보를 바탕으로 사다리 인쇄
    @Override
    public void printResult() {
        userScreenOutput.output(ladder.printLadder());
    }

    @Override
    public void printPlayerResult() {
        singleResult();
    }

    public void singleResult() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (!Objects.equals(input, "춘식이")) {
            System.out.println(INPUT_MESSAGE_FOR_SINGLE_RESULT);
            input = sc.nextLine().strip();
            findResultAndPrint(input);
        }
    }

    private void findResultAndPrint(String input) {
        if (Objects.equals(input, "춘식이")) {
            return;
        }
        this.userScreenOutput.output(ladder.getResultByPlayerName(input));


    }
}
