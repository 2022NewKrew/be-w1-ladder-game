import java.util.Random;
import java.util.Vector;

public class LadderGame {

    public void run(int person, int ladder) {
        System.out.println("게임 설정");
        System.out.println("사용자 : " + person + "명");
        System.out.println("사다리 높이 : " + ladder + "\n");

        if (person < 2) {
            System.out.println("사다리 게임은 혼자서 플레이할 수 없어요!!!");
            return;
        }

        Vector<Vector<Integer>> gameBoard = makeGameBoard(person, ladder);
        printGameBoard(gameBoard);
    }

    private Vector<Vector<Integer>> makeGameBoard(int person, int ladder) {
        Random random = new Random();
        Vector<Vector<Integer>> gameBoard = new Vector<>();

        for (int i = 0; i < ladder; i++) {
            Vector<Integer> curLine = new Vector<>();
            for (int j = 0; j < person - 1; j++) {
                curLine.add(random.nextInt(2));
            }
            gameBoard.add(curLine);
        }

        return gameBoard;
    }

    private void printGameBoard(Vector<Vector<Integer>> gameBoard) {
        for (int i = 0; i < gameBoard.size(); i++) {
            for (int j = 0; j < gameBoard.get(0).size(); j++) {
                char shape = gameBoard.get(i).get(j) > 0 ? '-' : ' ';
                System.out.print("|" + shape);
            }
            System.out.println("|");
        }
    }
}
