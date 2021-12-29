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

        List<List<Boolean>> gameBoard = makeGameBoard(numberOfPerson - 1, heightOfLadder);
        printGameBoard(participantsNames, gameBoard);
    }

    private List<List<Boolean>> makeGameBoard(int width, int height) {
        List<List<Boolean>> gameBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            gameBoard.add(makeLine(width));
        }

        return gameBoard;
    }

    private List<Boolean> makeLine(int width) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            line.add(decideNextConnection(line, i));
        }

        return line;
    }

    private boolean decideNextConnection(List<Boolean> currentLine, int idx) {
        if (idx > 0 && currentLine.get(idx - 1) == true) {
            return false;
        }
        return random.nextBoolean();
    }

    private void printGameBoard(List<String> participantsNames, List<List<Boolean>> gameBoard) {
        List<String> printBoard = new ArrayList<>();

        printBoard.add(" " + participantsNames.stream().map(this::formatName)
            .collect(Collectors.joining(" ")));

        for (List<Boolean> line : gameBoard) {
            printBoard.add(shapeLine(line));
        }

        System.out.println(String.join(System.lineSeparator(), printBoard));
    }

    private String formatName(String name) {
        return String.format("%5s", name.length() <= 5 ? name : name.substring(0, 5));
    }

    private String shapeLine(List<Boolean> line) {
        StringBuilder stringBuilder = new StringBuilder("    ");
        for (boolean connected : line) {
            stringBuilder.append(BAR)
                .append(connected ? CONNECT : BLANK);
        }
        return stringBuilder.append(BAR)
            .toString();
    }
}
