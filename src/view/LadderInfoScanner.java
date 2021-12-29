package view;

import data.LadderInfo;

import java.util.Scanner;

public class LadderInfoScanner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String delimiter = ",";

    private LadderInfoScanner() {
        //instance 생성 제한용 생성자
    }

    public static LadderInfo getLadderInfo() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputString = scanner.nextLine();
        String[] participants = inputString.split(delimiter);

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();

        return new LadderInfo(participants, height);
    }
}
