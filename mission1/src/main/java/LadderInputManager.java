import java.util.*;

public class LadderInputManager {
    private final int numOfPlayer;
    private final int maxHeight;
    private final int nameLen;
    private final ArrayList<String> playerList;
    private final Scanner scanner;

    public LadderInputManager() {
        nameLen = 5;

        scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        playerList = getPlayers();
        numOfPlayer = getPlayerList().size();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        maxHeight = getInputNumber();
    }

    public ArrayList<String> getPlayerList() {
        return playerList;
    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getNameLen() {
        return nameLen;
    }

    private ArrayList<String> getPlayers() {
        String players = scanner.nextLine();
        String[] playersArray = players.split(",");

        ArrayList<String> playersList = new ArrayList<>();
        Collections.addAll(playersList, playersArray);

        return playersList;
    }

    private int getInputNumber() {
        try {
            int result = scanner.nextInt();
            return checkInput(result) ? result : getInputNumber();
        }
        catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요.");
            return getInputNumber();
        }
    }

    private boolean checkInput(int value) {
        if (value > 0)
            return true;
        System.out.println("0보다 큰 정수를 입력해주세요.");
        return false;
    }

}
