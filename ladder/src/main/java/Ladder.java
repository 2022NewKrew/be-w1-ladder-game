import java.util.Arrays;
import java.util.Random;

public class Ladder{
    // 연결되는 곳 true, 아닌 곳 false 로 저장
    private final Boolean[][] ladderShape;
    private final int numOfParticipants;
    private final int numOfLadderHeight;

    public Ladder(int numOfParticipants, int numOfLadderHeight){
        this.numOfParticipants = numOfParticipants;
        this.numOfLadderHeight = numOfLadderHeight;
        ladderShape = new Boolean[numOfLadderHeight][numOfParticipants - 1];
    }

    public void build(){
        for (int row = 0; row < numOfLadderHeight; row++)
            createRow(row);
    }

    private void createRow(int row){
        Random random = new Random();
        for (int bar = 0; bar < numOfParticipants - 1; bar++)
            ladderShape[row][bar] = isValid(row, bar) && random.nextBoolean();
    }

    private boolean isValid(int row, int bar){
        if (bar == 0)
            return true;
        return !ladderShape[row][bar - 1];
    }

    public void printShape(){
        Arrays.stream(ladderShape).forEach(
                row -> {
                    Arrays.stream(row)
                            .map(this::mapBar)
                            .forEach(bar -> System.out.print("|" + bar));
                    System.out.println("|");
                });
    }

    private String mapBar(Boolean barExists){
        return barExists? "-": " ";
    }
}