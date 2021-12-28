import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder{
    private final List<List<Boolean>> ladderShape;
    private final int numOfParticipants;
    private final int numOfLadderHeight;

    public Ladder(int numOfParticipants, int numOfLadderHeight){
        this.numOfParticipants = numOfParticipants;
        this.numOfLadderHeight = numOfLadderHeight;
        ladderShape = new ArrayList<>();
    }

    public void build(){
        for (int row = 0; row < numOfLadderHeight; row++)
            ladderShape.add(createRow());
    }

    private List<Boolean> createRow(){
        List<Boolean> newRow = new ArrayList<>();
        Random random = new Random();

        for (int bar = 0; bar < numOfParticipants - 1; bar++)
            newRow.add(random.nextBoolean());

        return newRow;
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