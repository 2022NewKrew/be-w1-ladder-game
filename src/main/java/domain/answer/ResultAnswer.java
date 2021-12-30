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

    private static int RIGHT = 1;
    private static int LEFT = -1;
    private static int JUMP_TO_RIGHT = 2;
    private static int JUMP_TO_LEFT = -2;

    private LadderWithResult ladder;

    public void answerResult(Scanner sc, LadderWithResult ladder){
        this.ladder = ladder;

        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            String question = sc.nextLine();
            if (question.equals("춘식이")) AnswerPrinter.endAnswer();
            if (question.equals("all")) answerAllResult();
            if (ladder.getNames().contains(question)) answerOneResult(question);

        }
    }

    private void answerAllResult() {
        Map<String, String> allResult = ladder.getNames().stream()
                .collect(Collectors.toMap(String::toString, this::getOneResult));
        AnswerPrinter.printAllResult(allResult);
    }

    private void answerOneResult(String question) {
        String oneReault = getOneResult(question);
        AnswerPrinter.printOneResult(oneReault);
    }

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
