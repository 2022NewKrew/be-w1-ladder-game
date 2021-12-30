package ladder.view;

import ladder.domain.Ladder;

import java.util.List;
import java.util.Scanner;

public class IOController {
    private static final Scanner sc = new Scanner(System.in);

    public int inputInt(String msg) {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public String inputString(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    public void print(List<Ladder.Line> currentLadder, String[] username) {
        for (String name : username) {
            System.out.print(alignName(name));
        }
        System.out.println();

        for (Ladder.Line line : currentLadder) {
            System.out.printf("   %s\n", line.toString());
        }
    }

    //name 길이에 맞춰 앞 뒤로 공백 추가 - 가운데 정렬
    private String alignName(String name) {
        final int maxLength = 5;
        String ret = " ";
        int prefixCount = (maxLength - name.length()) / 2;
        int suffixCount = maxLength - name.length() - prefixCount;

        ret = addSpace(ret, prefixCount);
        ret = ret.concat(name);
        ret = addSpace(ret, suffixCount);

        return ret;
    }

    private String addSpace(String target, int spaceCount) {
        for (int i = 0; i < spaceCount; i++) {
            target = target.concat(" ");
        }
        return target;
    }
}
