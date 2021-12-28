import java.util.*;

public class Ladder {
    private final int numOfPeople;
    private final int depth;
    private final ArrayList<Line> ladder = new ArrayList<>();


    Ladder(int numOfPeople, int depth){
        this.numOfPeople = numOfPeople;
        this.depth = depth;
        setLadder();
    }


    private void setLadder(){
        for(int i=0;i<depth;i++){
            Line line = new Line(numOfPeople);
            ladder.add(line);
        }
    }

    public void printLadder(){
        for(int i=0;i<depth;i++){
            ladder.get(i).printLine();
        }
    }

    private static class Line {
        private final ArrayList<String> statusCase = new ArrayList<>(List.of("-", " "));
        private final String defaultCase = "|";
        private final int numOfStatus;
        private final Random rd = new Random();
        private ArrayList<String> line;


        Line(int numOfPeople){
            this.numOfStatus = numOfPeople-1;
            setLine();
        }


        private void setLine(){
            line = new ArrayList<>();
            for(int i=0;i<numOfStatus;i++){
                line.add(statusCase.get(rd.nextInt(numOfStatus)));
            }
        }

        public void printLine(){
            for(int i=0;i<numOfStatus;i++)
                System.out.print(defaultCase + line.get(i));
            System.out.println(defaultCase);
        }
    }

}