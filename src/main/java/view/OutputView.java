package view;

import input.InputManager;
import ladder.Ladder;

public class OutputView {

    public static void showOutput(Ladder ladder) {
        ladder.print();
        showResults(ladder);
    }

    private static void showResults(Ladder ladder) {
        String next = getInput();
        if(checkEndCondition(next)) return;
        do {

            //결과출력
            String result = LadderResultViewer.getResult(ladder, next);
            System.out.println(result);
            next = getInput();
        }while(!checkEndCondition(next));
    }

    private static Boolean checkEndCondition(String str) {
        if(str.equals("춘식이")) {
            System.out.println("게임을 종료합니다.");
            return true;
        }
        return false;
    }

    private static String getInput() {
        System.out.println("결과를 보고싶은 사람은?");
        String inputValue = InputManager.nextLine();
        return inputValue;
    }
}
