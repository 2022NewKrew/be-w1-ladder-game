package domain.answer;

import domain.ladder.LadderWithResult;
import domain.ladder.Line;
import type.StuffType;
import view.output.AnswerPrinter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultAnswer {

    // LadderShape 2차원 리스트에서 사다리 결과를 뽑기위해 확인 및 이동하는 거리 상수
    private static int RIGHT = 1;
    private static int LEFT = -1;
    private static int JUMP_TO_RIGHT = 2;
    private static int JUMP_TO_LEFT = -2;

    // ladder 를 받아서 멤버변수로 넣어줌 - 아래 결과를 산출하는 함수에서 사용
    private LadderWithResult ladder;

    public void answerResult(Scanner sc, LadderWithResult ladder){
        // ladder 설정
        this.ladder = ladder;

        // while(질문 입력) 종료 flag
        Boolean questionEndFlag = true;

        while (questionEndFlag) {
            System.out.println("결과를 보고 싶은 사람은?");
            String question = sc.nextLine();
            if (question.equals("춘식이")) questionEndFlag = AnswerPrinter.endAnswer();
            if (question.equals("all")) answerAllResult();
            // 입력이 이름 목록에 있는 경우
            if (ladder.getNames().contains(question)) answerOneResult(question);

        }
    }

    // 아래 Map<이름, 순서>에 Stream + getOneResult 함수 를 통해 결과 산출
    private void answerAllResult() {
        Map<String, String> allResult = ladder.getNames().stream()
                .collect(Collectors.toMap(String::toString, this::getOneResult));
        // AnswerPrinter(출력 담당) 에게 넘겨 출력하도록 함
        AnswerPrinter.printAllResult(allResult);
    }

    // param: 이름
    private void answerOneResult(String question) {
        String oneReault = getOneResult(question);
        AnswerPrinter.printOneResult(oneReault);
    }

    // param: 이름, return: 결과(꽝 등)
    private String getOneResult(String name) {
        List<Line> ladderShape = ladder.getLadderShape();
        int x = ladder.getNameToNumMap().get(name)*2;
        int LINE_SIZE = ladderShape.get(0).getPoints().size();
        for(int y = 0; y < ladderShape.size(); y++){
            int MOVE_POINT = 0;
            if (x > 0 && x <= LINE_SIZE-1) MOVE_POINT += ladderShape.get(y).getPoints().get(x+LEFT) == StuffType.BRIDGE.getNum() ? JUMP_TO_LEFT : 0;
            if (x >= 0 && x < LINE_SIZE-1) MOVE_POINT += ladderShape.get(y).getPoints().get(x+RIGHT) == StuffType.BRIDGE.getNum() ? JUMP_TO_RIGHT : 0;
            x += MOVE_POINT;
        }
        return ladder.getResults().get(x/2);
    }
}
