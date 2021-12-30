package ladder.view;

import ladder.domain.LadderLine;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IOController {
    private static final Scanner sc = new Scanner(System.in);

    public int inputInt(String msg) {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public List<String> inputStringArray(String msg) {
        System.out.println(msg);
        return Arrays.stream(sc.nextLine().split(","))
                .map(StringUtils::deleteWhitespace)
                .map(str -> StringUtils.substring(str, 0, 5))
                .collect(Collectors.toList());
    }

    public void print(List<LadderLine> currentLadder, List<String> username) {
        for (String name : username) {
            System.out.print(StringUtils.center(name, 6));
        }
        System.out.println();

        for (LadderLine line : currentLadder) {
            System.out.printf("  %s\n", line.print());
        }
    }
}
