import java.util.ArrayList;
import java.util.List;

public class NormalLadderGenerator implements LadderGenerator{
    private final List<StringBuilder> ladder = new ArrayList<>();

    @Override
    public Ladder buildLadder(int heights, int numberOfParticipants){
        for (int i = 0; i < heights; i++){
            ladder.add(new StringBuilder());
        }
        for (StringBuilder ladderLine : ladder) {
            for (int j = 0; j < numberOfParticipants * 2 - 1; j++) {
                if (j % 2 == 0) ladderLine.append(LadderCharacter.column);
                else ladderLine.append(RandomConnection.randomConnection());
            }
        }
        return new Ladder(ladder);
    }
}
