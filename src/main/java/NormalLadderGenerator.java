import java.util.ArrayList;

public class NormalLadderGenerator implements LadderGenerator{
    @Override
    public Ladder buildLadder(int heights, int noParticipants){
        Ladder ladderDTO = new Ladder(heights, noParticipants);
        ArrayList<StringBuilder> ladder = ladderDTO.getLadder();
        for (int i = 0; i < ladderDTO.getHeights(); i++) {
            StringBuilder line = ladder.get(i);
            for (int j = 0; j < noParticipants * 2 - 1; j++) {
                if (j % 2 == 0) line.append("|");
                else line.append(RandomConnection.randomConnection());
            }
        }
        return ladderDTO;
    }
}
