package view;

import domain.Ladder;
import view.scanner.PositiveIntScanner;
import view.scanner.StringScanner;

import java.util.List;

public class GameInputOutputManager {
    private final LadderPrinter ladderPrinter;
    private final GameResultPrinter gameResultPrinter;

    public GameInputOutputManager(){
        ladderPrinter = new LadderPrinter();
        gameResultPrinter = new GameResultPrinter();
    }

    public List<String> getParticipantsInfo(){
        return StringScanner.getStringList("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", 5);
    }

    public List<String> getResultsInfo(){
        return StringScanner.getStringList("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", 5);
    }

    public int getLadderInfo(){
        return PositiveIntScanner.getPositiveInt("최대 사다리 높이는 몇 개인가요?");
    }

    public String getSelectedName(){
        return StringScanner.getString("결과를 보고 싶은 사람은?");
    }

    public void printLadder(Ladder ladder){
        ladderPrinter.print(ladder);
    }

    public void printGameResult(Ladder ladder, String name){
        gameResultPrinter.printGameResult(ladder, name);
    }
}
