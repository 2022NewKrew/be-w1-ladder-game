import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {
        Ladder ladderObject = new Ladder();

        ladderObject.initLine();
        ladderObject.shuffle();
        ladderObject.display();
    }
}
