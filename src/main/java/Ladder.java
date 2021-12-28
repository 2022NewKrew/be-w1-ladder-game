import java.util.ArrayList;
import java.util.Random;

public class Ladder {

    private final int numParticipants;
    private final int maxLadderHeight;
    private ArrayList<ArrayList<Boolean>> rungArray;

    public Ladder(int numParticipants, int maxLadderHeight) {
        this.numParticipants = numParticipants;
        this.maxLadderHeight = maxLadderHeight;
        createLadder();
    }

    private void createLadder() {
        rungArray = new ArrayList<>();
        for (int i = 0; i < maxLadderHeight; ++i) {
            rungArray.add(createRungColumn());
        }
    }

    private ArrayList<Boolean> createRungColumn() {
        ArrayList<Boolean> rungCol = new ArrayList<>();
        boolean leftRungExist = false;
        for (int i = 0; i < numParticipants - 1; ++i) {
            boolean rungExist = !leftRungExist && isLadderExist();
            rungCol.add(rungExist);
            leftRungExist = rungExist;
        }
        return rungCol;
    }

    private boolean isLadderExist() {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    public void draw() {
        for (ArrayList<Boolean> rungCol : rungArray) {
            drawCol(rungCol);
        }
    }

    private void drawCol(ArrayList<Boolean> rungCol) {
        for (Boolean rungExist : rungCol) {
            System.out.print("|");
            System.out.print(getRungString(rungExist));
        }
        System.out.println("|");
    }

    private String getRungString(boolean isRungExist) {
        if (isRungExist) {
            return "-";
        }
        return " ";
    }
}
