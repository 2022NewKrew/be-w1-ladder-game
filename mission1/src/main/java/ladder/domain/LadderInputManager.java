package ladder.domain;

import ladder.constant.Const;
import ladder.entity.LadderInput;
import ladder.exception.LadderException;

import java.util.*;

public class LadderInputManager {
    private final Scanner scanner;
    private final LadderInput ladderInput;

    public LadderInputManager(){
        scanner = new Scanner(System.in);
        ArrayList<String> playerList = getPlayers();

        int maxHeight = getInputNumber();

        this.ladderInput = new LadderInput(maxHeight, playerList);
    }

    public LadderInput getLadderInput() {
        return ladderInput;
    }

    private ArrayList<String> getPlayers(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String players = scanner.nextLine();
        String[] playersArray = players.split(",");

        ArrayList<String> playersList = new ArrayList<>();
        Collections.addAll(playersList, playersArray);

        try{
            checkPlayersList(playersList);
        }
        catch(LadderException e){
            playersList = getPlayers();
        }

        return playersList;
    }

    private void checkPlayersList(ArrayList<String> playersList) throws LadderException {
        for(String player : playersList) {
            checkNameLength(player);
        }
    }

    private void checkNameLength(String playerName) throws LadderException{
        if(playerName.length() == 0) {
            throw new LadderException();
        }
        if(playerName.length() > Const.MAX_NAME_LEN) {
            throw new LadderException();
        }
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
