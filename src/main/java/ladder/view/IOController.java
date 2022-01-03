package ladder.view;

import ladder.domain.LadderLine;
import ladder.domain.FormattedString;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class IOController {
    private static final Scanner sc = new Scanner(System.in);

    public int inputInt(String msg) {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public String inputString(String msg){
        System.out.println(msg);
        return sc.nextLine();
    }

    public String[] inputStringArray(String msg) {
        return inputString(msg).split(",");
    }

    public void printLadder(@NotNull List<LadderLine> currentLadder,
                            List<FormattedString> playerList,
                            List<FormattedString> resultList) {
        printStringCenter(playerList);
        for (LadderLine line : currentLadder) {
            System.out.printf("  %s\n", line.print());
        }
        printStringCenter(resultList);
    }

    private void printStringCenter(@NotNull List<FormattedString> stringList) {
        for (var str : stringList) {
            System.out.print(StringUtils.center(str.getStr(), 6));
        }
        System.out.println();
    }
}
