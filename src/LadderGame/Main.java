package LadderGame;

import LadderGame.domain.LadderGame;

public class Main {

    public static void main(String[] args) {

        try {
            new LadderGame();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
