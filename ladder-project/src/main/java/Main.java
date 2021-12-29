import controller.LadderGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LadderGame game = new LadderGame(sc);
            game.play();
        }
    }

}
