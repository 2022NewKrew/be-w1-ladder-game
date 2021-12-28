package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private int width;
    private int height;
    private List<String> ladder;

    public Ladder(int width, int height, List<String> ladder) {
        this.width = width;
        this.height = height;
        this.ladder = ladder;
    }

    public void print() {
        for (String floor : ladder) {
            System.out.println(floor);
        }
    }

    public List<String> getLadder() {
        return ladder;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}


