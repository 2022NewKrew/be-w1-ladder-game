import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ladder {

    private final List<List<Boolean>> ladders = new ArrayList<>();
    private final Random random = new Random();
    private int width, height;

     Ladder(int width,int height){
        this.width = width;
        this.height = height;
        makeLadders();
        printLadders();
    }


    private void makeLadders() {
        for (int i = 0; i < height; i++) {
            setLaddersData();
        }
    }

    private void setLaddersData() {
        List<Boolean> line = new ArrayList<>();
        for (int j = 0; j < width - 1; j++) {
            line.add(random.nextBoolean());
        }
        ladders.add(line);
    }

    private void printLadders() {
        for (List<Boolean> ladder : ladders) {
            ladder.forEach(it -> System.out.print(it ? "|-" : "| "));
            System.out.println("|");
        }
    }

}
