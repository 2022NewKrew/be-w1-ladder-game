package view;

import data.LadderInfo;

import java.util.Scanner;

public class LadderInfoScanner {
    private static final String DELIMITER = ",";
    private static final String DELIMITER_NAME = "쉼표";
    private static final Scanner scanner = new Scanner(System.in);

    private LadderInfoScanner() {
        //instance 생성 제한용 생성자
    }

    public static LadderInfo getLadderInfo() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)\n",DELIMITER_NAME,DELIMITER);
        String inputString = scanner.nextLine();
        String[] participants = inputString.split(DELIMITER);

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();

        return new LadderInfo(participants, height);
    }
}
