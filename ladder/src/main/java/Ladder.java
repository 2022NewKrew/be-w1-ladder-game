import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder{
    private final List<List<Boolean>> ladderShape = new ArrayList<>();
    private final int numOfParticipants;
    private final int numOfLadderHeight;

    public Ladder(int numOfParticipants, int numOfLadderHeight){
        this.numOfParticipants = numOfParticipants;
        this.numOfLadderHeight = numOfLadderHeight;
    }

    public void build(){
        Random random = new Random(System.currentTimeMillis());
        List<Boolean> newRow;

        for (int row = 0; row < numOfLadderHeight; row++) {
            newRow = new ArrayList<>();
            for (int bar = 0; bar < numOfParticipants - 1; bar++)
                newRow.add(random.nextBoolean());
            ladderShape.add(newRow);
        }
    }

    public void printShape(){
        ladderShape.forEach(
                row -> {
                    row.stream()
                            .map(this::mapBar)
                            .forEach(bar -> System.out.print("|" + bar));
                    System.out.println("|");
                });
    }

    private String mapBar(Boolean barExists){
        return barExists? " ": "-";
    }
}