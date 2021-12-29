import domain.Ladder;
import domain.LadderBuilder;
import domain.LadderWithNameBuilder;
import view.input.ConfigReader;
import view.input.ConfigReaderNameAndHeight;
import view.input.LadderConfig;
import view.output.LadderPrinter;
import view.output.LadderPrinterWithNameImpl;

public class LadderGame {

    private static ConfigReader configReader = new ConfigReaderNameAndHeight();
    private static LadderBuilder ladderBuilder = new LadderWithNameBuilder();
    private static LadderPrinter ladderPrinter = new LadderPrinterWithNameImpl();

    public static void main(String[] args) {

        // 입력 받기
        LadderConfig ladderConfig = configReader.readLadderConfig();

        // 사다리 만들기
        Ladder ladder = ladderBuilder.createLadder(ladderConfig);

        // 출력
        ladderPrinter.printLadderShape(ladder);
    }

}
