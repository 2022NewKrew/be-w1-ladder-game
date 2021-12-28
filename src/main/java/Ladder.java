import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final int numParticipant;
    private final int height;
    private List<ArrayList<Boolean>> ladder;

    public Ladder(int numParticipant, int height) {
        this.numParticipant = numParticipant;
        this.height = height;
        createLadder();
    }

    private void createLadder(){
        ladder = new ArrayList<>();
        for(int i = 0; i < height; i++){
            ladder.add(createRow());
        }
    }

    private ArrayList<Boolean> createRow(){
        ArrayList<Boolean> row = new ArrayList<>();
        for(int j = 0; j < numParticipant - 1; j++){
            row.add(createCell(row, j));
        }
        return row;
    }

    private Boolean createCell(ArrayList<Boolean> row, int colIndex){
        Random random = new Random();
        if(colIndex == 0 || Boolean.FALSE.equals(row.get(colIndex - 1))){
            return random.nextBoolean();
        }
        return Boolean.FALSE;
    }

    public void draw(){
        ladder.stream().forEach(row -> {
            System.out.print("|");
            row.forEach(item -> System.out.print(item ? "─|" : " |"));
            System.out.println();
        });
    }
}
