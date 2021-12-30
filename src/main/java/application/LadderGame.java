package application;

import domain.Ladder;
import domain.User;
import view.LadderPrinter;

import java.util.List;

public class LadderGame {
    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static void main(String[] args) {
        ladderGamePlay();
    }

    public static void ladderGamePlay() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<User> nameList = GameInputScanner.inputNameList();

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> resultList = GameInputScanner.inputResultList(nameList.size());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightLadder = GameInputScanner.inputNumber();

        Ladder ladder = new Ladder(LineGeneratorFactory.getLadderLines(nameList.size() - 1, heightLadder));
        LadderPrinter.drawLadder(nameList, ladder, resultList);

        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            String nameCheckResult = GameInputScanner.inputNameCheckResult(nameList);
            User user = nameList.stream()
                    .filter(e -> nameCheckResult.equals(e.getName()))
                    .distinct()
                    .findAny()
                    .get();
            System.out.println(resultList.get(user.getResultCol(ladder)));
        }
    }

}