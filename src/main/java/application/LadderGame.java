package application;

import domain.Ladder;
import view.LadderPrinter;

import java.util.List;

public class LadderGame {
    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static void main(String[] args) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> nameList = GameInputScanner.inputNameList();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightLadder = GameInputScanner.inputNumber();

        Ladder ladder = new Ladder(LadderFactory.getLadderRows(nameList.size() - 1, heightLadder));
        LadderPrinter.drawLadder(nameList, ladder);
    }

}