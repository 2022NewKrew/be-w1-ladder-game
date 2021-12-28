import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Setting setting = new Setting();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static boolean[][] ladderGame;

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
            int numberOfMan = getUserInputInt("참여할 사람은 몇 명인가요?");
            if(isNegativeValue(numberOfMan)) {
                throw new Exception("양수를 입력해주세요.");
            }

            int maxHeightOfLadder = getUserInputInt("최대 사다리 높이는 몇 개인가요?");
            if(isNegativeValue(maxHeightOfLadder)) {
                throw new Exception("양수를 입력해주세요.");
            }

            setting.setNumberOfMan(numberOfMan);
            setting.setMaxHeightOfLadder(maxHeightOfLadder);
        } catch (Exception ex) {
            throw ex;
        }

    }

    public static int getUserInputInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static void generateLadder() {
        for(int row = 0; row < height; row++) {
            generateLadderRow(row);
        }
    }

    public static void generateLadderRow(int rowIndex) {
        for(int col = 0; col < width; col++) {
            ladderGame[rowIndex][col] = random.nextBoolean();
        }
    }

    public static void printLadder() {
        for(int row = 0; row < height; row++) {
            printLadderRow(row);
            System.out.println();
        }
    }

    public static void printLadderRow(int rowIndex) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int col = 0; col < width; col++) {
            stringBuilder.append("|");

            String ladder = existsLadder(rowIndex, col) ? "-" : " ";
            stringBuilder.append(ladder);
        }
        stringBuilder.append("|");

        System.out.print(stringBuilder);
    }

    public static boolean existsLadder(int rowIndex, int colIndex) {
        return ladderGame[rowIndex][colIndex];
    }

    public static boolean isNegativeValue(int num) {
        return num < 0;
    }

}