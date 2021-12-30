import domain.answer.ResultAnswer;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderWithResult;
import domain.ladder.LadderWithResultGenerator;
import view.input.reader.ConfigReader;
import view.input.reader.ConsoleConfigWithResultReader;
import view.input.config.LadderConfig;
import view.output.LadderPrinter;
import view.output.LadderPrinterWithResult;

import java.util.Scanner;

public class LadderGame {

    private static ConfigReader configReader = new ConsoleConfigWithResultReader();
    private static LadderGenerator ladderGenerator = new LadderWithResultGenerator();
    private static LadderPrinter ladderPrinter = new LadderPrinterWithResult();
    private static ResultAnswer resultAnswer = new ResultAnswer();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        LadderConfig ladderConfig = configReader.readLadderConfig(sc);

        // 사다리 만들기
        Ladder ladder = ladderGenerator.createLadder(ladderConfig);

        // 출력
        ladderPrinter.printLadderShape(ladder);

        // 실행 결과 출력
        resultAnswer.answerResult(sc, ((LadderWithResult) ladder));

        sc.close();
    }

}
