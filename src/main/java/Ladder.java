import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private List<ArrayList<Boolean>> ladder;
    private final int numParticipant;
    private final int height;

    public Ladder(int numParticipant, int height) {
        this.numParticipant = numParticipant;
        this.height = height;
        createLadder();
    }

    private void createLadder(){
        ladder = new ArrayList<>();

        Random random = new Random();

        for(int i = 0; i < height; i++){
            ArrayList<Boolean> row = new ArrayList<>();
            for(int j = 0; j < numParticipant - 1; j++){
                if(j == 0 || Boolean.FALSE.equals(row.get(j - 1))){
                    row.add(random.nextBoolean());
                }
                else{
                    row.add(Boolean.FALSE);
                }
            }
            ladder.add(row);
        }
    }

    public void draw(){
        for(ArrayList<Boolean> row : ladder){
            System.out.print("|");
            for(Boolean item : row){
                System.out.print(item ? "─|" : " |");
            }
            System.out.println();
        }
    }
}
