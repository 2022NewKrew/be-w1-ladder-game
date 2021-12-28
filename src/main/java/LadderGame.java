import entity.LadderBuilder;
import entity.StuffType;
import input.ConfigReader;
import input.ConfigReaderHeightAndWidthImpl;
import input.LadderConfig;
import entity.Ladder;
import output.LadderPrinter;
import output.LadderPrinterImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderGame {

    private static ConfigReader configReader = new ConfigReaderHeightAndWidthImpl();
    private static LadderBuilder ladderBuilder = new LadderBuilder();
    private static LadderPrinter ladderPrinter = new LadderPrinterImpl();

    public static void main(String[] args) {

        // 입력 받기
        LadderConfig ladderConfig = configReader.readLadderConfig();

        // 사다리 만들기
        Ladder ladder = ladderBuilder.createLadder(ladderConfig.getWidth(), ladderConfig.getHeight());

        // 출력
        ladderPrinter.printLadderShape(ladder.getLadderShape());
    }

}
