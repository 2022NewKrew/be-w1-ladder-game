import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderGame {

    private final Random random;

    private final String BAR = "|";
    private final String CONNECT = "-----";
    private final String BLANK = "     ";

    public LadderGame() {
        random = new Random();
    }

    public void run(String nameInputs, int heightOfLadder) {
        List<String> participantsNames = Arrays.stream(nameInputs.split(","))
            .collect(Collectors.toList());
        int numberOfPerson = participantsNames.size();

        if (numberOfPerson < 2) {
            System.err.println("사다리 게임은 혼자서 플레이할 수 없어요!!!");
            return;
        }

        List<List<Integer>> gameBoard = makeGameBoard(numberOfPerson - 1, heightOfLadder);
        printGameBoard(participantsNames, gameBoard);
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

    private void printGameBoard(List<String> participantsNames, List<List<Integer>> gameBoard) {
        List<String> printBoard = new ArrayList<>();

        printBoard.add(" " + participantsNames.stream().map(this::formatName)
            .collect(Collectors.joining(" ")));

        for (List<Integer> line : gameBoard) {
            printBoard.add(shapeLine(line));
        }

        System.out.println(String.join(System.lineSeparator(), printBoard));
    }

    private String formatName(String name) {
        return String.format("%5s", name.length() <= 5 ? name : name.substring(0, 5));
    }

    private String shapeLine(List<Integer> line) {
        StringBuilder stringBuilder = new StringBuilder("    ");
        for (int space : line) {
            stringBuilder.append(BAR)
                .append(isConnected(space) ? CONNECT : BLANK);
        }
        return stringBuilder.append(BAR)
            .toString();
    }

    private boolean isConnected(int value) {
        return value > 0;
    }
}
