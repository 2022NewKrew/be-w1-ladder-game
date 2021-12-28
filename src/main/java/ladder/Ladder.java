package ladder;

public class Ladder {

    private final int participants;
    private final int height;

    public Ladder(int participants, int height) {
        this.participants = participants;
        this.height = height;
    }

    public void print() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < participants - 1; x++) {
                System.out.print("|");
                if (Math.random() > 0.5) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }

}
