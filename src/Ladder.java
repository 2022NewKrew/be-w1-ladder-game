import java.util.ArrayList;

public class Ladder {
    private final ArrayList<Line> ladder = new ArrayList<>();
    private final int height;

    public Ladder(int numOfPeople, int height) {
        this.height = height;

        for(int i=0; i<height; i++){
            ladder.add(new Line(numOfPeople));
        }
    }

    public String printLadder(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<height; i++){
            sb.append("  |");
            ladder.get(i)
                    .getLine()
                    .forEach(line -> sb.append(makeLine(line)).append("|"));
            sb.append("\n");
        }

        return sb.toString();
    }

    private String makeLine(boolean line){
        if(line)
            return "-----";

        return "     ";
    }
}
