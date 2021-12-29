import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final int RANDOM_FLAG_THRESHOLD = 40;

    private int width;
    private int height;
    private ArrayList<ArrayList<Boolean>> lineFlags;

    Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        this.lineFlags = setLineFlags();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Boolean getLineFlag(int row, int col) {
        return lineFlags.get(row).get(col);
    }

    private ArrayList<ArrayList<Boolean>> setLineFlags() {
        ArrayList<ArrayList<Boolean>> lineFlags = new ArrayList<ArrayList<Boolean>>();
        for (int i = 0; i < height; i++)
            lineFlags.add(makeLineFlagsByRow());
        return lineFlags;
    }

    private ArrayList<Boolean> makeLineFlagsByRow() {
        ArrayList<Boolean> row = new ArrayList<Boolean>();
        for (int i = 0; i < width; i++)
            row.add(getRandomFlag(i));
        return row;
    }

    private boolean getRandomFlag(int index) {
        int randomValue = new Random().nextInt(100);
        return randomValue <= RANDOM_FLAG_THRESHOLD;
    }
}