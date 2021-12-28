import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGame {

    private final Random random;

    private final String CONNECT = "-";
    private final String BLANK = " ";

    public LadderGame() {
        random = new Random();
    }

    public void run(int numberOfPerson, int heightOfLadder) {
        System.out.println("게임 설정");
        System.out.println("사용자 : " + numberOfPerson + "명");
        System.out.println("사다리 높이 : " + heightOfLadder + "\n");

        if (numberOfPerson < 2) {
            System.out.println("사다리 게임은 혼자서 플레이할 수 없어요!!!");
            return;
        }

        List<List<Integer>> gameBoard = makeGameBoard(numberOfPerson - 1, heightOfLadder);
        printGameBoard(gameBoard);
    }

    private List<List<Integer>> makeGameBoard(int width, int height) {
        List<List<Integer>> gameBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            gameBoard.add(makeLine(width));
        }

        return gameBoard;
    }

    private List<Integer> makeLine(int width) {
        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            line.add(random.nextInt(2));
        }

        return line;
    }

    private void printGameBoard(List<List<Integer>> gameBoard) {
        List<String> printBoard = new ArrayList<>();
        for (List<Integer> line : gameBoard) {
            printBoard.add(shapeLine(line));
        }

        System.out.println(String.join("\n", printBoard));
    }

    private String shapeLine(List<Integer> line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int space : line) {
            stringBuilder.append("|")
                .append(isConnected(space) ? CONNECT : BLANK);
        }
        return stringBuilder.append("|")
            .toString();
    }

    private boolean isConnected(int value) {
        return value > 0;
    }
}
