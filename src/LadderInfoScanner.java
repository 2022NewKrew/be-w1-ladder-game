import java.util.Scanner;

public class LadderInfoScanner {
    private static final Scanner scanner = new Scanner(System.in);

    private LadderInfoScanner() {
        //instance 생성 제한용 생성자
    }

    public static LadderInfo getLadderInfo() {
        System.out.println("참여할 사람은 몇 명인가요?");
        int width = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        return new LadderInfo(width, height);
    }
}
