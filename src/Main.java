import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Reader scanner = new Reader();
        scanner.readNumbers();
        int MaxHeight = scanner.getMaxheight();
        int Npeople = scanner.getNpeople();
        

        Ladder test1 = new Ladder(Npeople, MaxHeight);
        test1.printLadder();

    }
}
