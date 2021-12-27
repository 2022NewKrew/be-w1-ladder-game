import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGame {

    public void run(int person, int ladder) {
        System.out.println("게임 설정");
        System.out.println("사용자 : " + person + "명");
        System.out.println("사다리 높이 : " + ladder + "\n");

        if (person < 2) {
            System.out.println("사다리 게임은 혼자서 플레이할 수 없어요!!!");
            return;
        }

        List<List<Integer>> gameBoard = makeGameBoard(person, ladder);
        printGameBoard(gameBoard);
    }

    private List<List<Integer>> makeGameBoard(int person, int ladder) {
        Random random = new Random();
        List<List<Integer>> gameBoard = new ArrayList<>();

        for (int i = 0; i < ladder; i++) {
            List<Integer> curLine = new ArrayList<>();
            for (int j = 0; j < person - 1; j++) {
                curLine.add(random.nextInt(2));
            }
            gameBoard.add(curLine);
        }

        return gameBoard;
    }

    private void printGameBoard(List<List<Integer>> gameBoard) {
        for (List<Integer> line : gameBoard) {
            String buffer = "";
            for (int space : line) {
                char shape = space == 1 ? '-' : ' ';
                buffer += "|" + shape;
            }
            buffer += "|";
            System.out.println(buffer);
        }
    }
}
