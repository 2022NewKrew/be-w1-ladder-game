import java.util.*;

public class LadderInputManager {
    private final int maxHeight;
    private final int nameLen;
    private final ArrayList<String> playerList;
    private final Scanner scanner;

    public LadderInputManager(int nameLen) {
        this.nameLen = nameLen;
        scanner = new Scanner(System.in);

        playerList = getPlayers();
        maxHeight = getInputNumber();
    }

    public ArrayList<String> getPlayerList() {
        return playerList;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    private ArrayList<String> getPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String players = scanner.nextLine();
        String[] playersArray = players.split(",");

        ArrayList<String> playersList = new ArrayList<>();
        Collections.addAll(playersList, playersArray);

        if (!checkNameLength(playersList)){
            System.out.printf("이름은 %d자 이내로 입력해주세요.", nameLen);
            System.out.println();
        }
        return playersList;
    }

    private boolean checkNameLength(ArrayList<String> playerList) {
        boolean result = true;
        for (String name : playerList) {
            result = result && name.length() > 0 && name.length() <= nameLen;
        }
        return result;
    }

    private int getInputNumber() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
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
