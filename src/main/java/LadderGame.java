import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args){
        UserInterface userInterface = new UserInterface(new Scanner(System.in));
        userInterface.makeLadder();
        userInterface.printLadder();
    }
}
