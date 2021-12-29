import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderGame {

    private final Random random;

    private List<LadderLine> gameBoard;
    private List<String> participantsNames;

    private int width;
    private int height;

    public LadderGame() {
        random = new Random();
        gameBoard = new ArrayList<>();
    }

    public void run(String nameInputs, int heightOfLadder) {
        try {
            initGame(nameInputs, heightOfLadder);
            showGameBoard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initGame(String nameInputs, int heightOfLadder) {
        participantsNames = Arrays.stream(nameInputs.split(","))
            .collect(Collectors.toList());
        width = participantsNames.size() - 1;
        height = heightOfLadder;

        if (width < 1) {
            throw new InputMismatchException("사다리 게임을 플레이하기 위해서는 사용자가 2명 이상 필요해요.");
        }

        makeGameBoard();
    }

    private void showGameBoard() {
        if (gameBoard == null || gameBoard.isEmpty()) {
            throw new NullPointerException("사다리가 생성되지 않았어요.");
        }
        printGameBoard();
    }

    private void makeGameBoard() {
        gameBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            gameBoard.add(makeLine());
        }
    }

    private LadderLine makeLine() {
        LadderLine line = new LadderLine(random);
        line.makeLine(width);
        return line;
    }

    private void printGameBoard() {
        List<String> printBoard = new ArrayList<>();

        printBoard.add(" " + participantsNames.stream().map(this::formatName)
            .collect(Collectors.joining(" ")));
        gameBoard.forEach(line -> printBoard.add(line.shapeLine()));

        System.out.println(String.join(System.lineSeparator(), printBoard));
    }

    private String formatName(String name) {
        return String.format("%5s", name.length() <= 5 ? name : name.substring(0, 5));
    }
}
