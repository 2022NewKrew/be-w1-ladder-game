import java.util.Scanner;

public class Main {

    private static Setting setting = new Setting();

    private static boolean[][] ladderGame;

    private static Scanner scanner = new Scanner(System.in);

    private static int height;

    private static int width;

    public static void main(String[] args) throws Exception {

        // 1. 사용자로부터 게임 설정 입력 받기
        try{
            initializeGameSetting();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 2. 입력 받은 설정을 기반으로 사다리게임 초기화하기
        initializeLadderGame();

        // 3. 사다리 라인 생성하기
        generateLadder();

        // 4. 사다리 게임 출력하기
        printLadder();

    }

    public static void initializeLadderGame() {
        height = setting.getMaxHeightOfLadder();
        width = setting.getNumberOfMan() - 1;
        if(isNegativeValue(width)) {
            width = 0;
        }

        ladderGame = new boolean[height][width];
    }

    public static void initializeGameSetting() throws Exception{
        try {
            System.out.println("참여할 사람은 몇 명인가요?");
            int numberOfMan = scanner.nextInt();
            if(isNegativeValue(numberOfMan)) {
                throw new Exception("양수를 입력해주세요.");
            }

            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int maxHeightOfLadder = scanner.nextInt();
            if(isNegativeValue(maxHeightOfLadder)) {
                throw new Exception("양수를 입력해주세요.");
            }

            setting.setNumberOfMan(numberOfMan);
            setting.setNumberOfMan(maxHeightOfLadder);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static boolean isNegativeValue(int num) {
        return num < 0;
    }

    public static void generateLadder() {
        for(int row = 0; row < height; row++) {
            for(int col = 0; col < width; col++) {
                int randomValue = (int) (Math.random() * 2);
                ladderGame[row][col] = (randomValue == 1) ? true : false;
            }
        }
    }

    public static void printLadder() {
        for(int row = 0; row < height; row++) {
            for(int col = 0; col < width; col++) {
                System.out.print("|");
                if(ladderGame[row][col]) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }

}
