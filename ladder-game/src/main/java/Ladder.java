import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    static final private Random randomGenerator = new Random();
    private final List<String> shape = new ArrayList<>();

    public Ladder(int numberOfPerson, int ladderHeight){
        for(int i = 0; i < ladderHeight; i++){
            shape.add(generateLadderLine(numberOfPerson));
        }
    }

    private String generateLadderLine(int numberOfPerson){
        StringBuilder generatedLine = new StringBuilder();
        int ladderSize = numberOfPerson * 2 - 1;
        for(int i = 0 ; i < ladderSize; i++){
            if(i % 2 == 1){
                generatedLine.append(generateBranch());
                continue;
            }
            generatedLine.append("|");
        }
        return generatedLine.toString();
    }

    private char generateBranch(){
        if(randomGenerator.nextBoolean()){
            return '-';
        }
        return ' ';
    }

    public List<String> getShape() {
        return shape;
    }
}
