import java.util.*;

public class Ladder {
    private final int numOfPeople;
    private final int depth;
    private final ArrayList<Line> ladder = new ArrayList<>();
    private final int maxLength;
    private final ArrayList<String> names;
    private final ArrayList<String> results;


    public Ladder(LadderInput li){
        this.numOfPeople = li.numOfPeople;
        this.depth = li.depth;
        this.maxLength = LadderInput.maxLength;
        this.names = li.names;
        this.results = li.results;
        setLadder();
    }


    private void setLadder(){
        for(int i=0;i<depth;i++){
            Line line = new Line(numOfPeople);
            ladder.add(line);
        }
    }

    public void printLadder(){
        String maxLengthString = String.valueOf(maxLength);
        String formatString = "%" + maxLengthString + "." + maxLengthString + "s ";
        for(String name : names){
            System.out.printf(formatString, name);
        }
        System.out.println();
        for(Line line : ladder){
            line.printLine(maxLength);
        }
        for(String result : results){
            System.out.printf(formatString, result);
        }
        System.out.println();
    }

    private static class Line {
        private final ArrayList<String> statusCase = new ArrayList<>(List.of("-", " "));
        private final String defaultCase = "|";
        private final int numOfStatus;
        private final Random rd = new Random();
        private ArrayList<Integer> line;


        Line(int numOfPeople){
            this.numOfStatus = numOfPeople-1;
            setLine();
        }


        private void setLine(){
            int previousStatusIdx = 1;
            int currentStatusIdx;
            line = new ArrayList<>();

            for(int i=0;i<numOfStatus;i++){
                currentStatusIdx = validCheck(previousStatusIdx);
                line.add(currentStatusIdx);
                previousStatusIdx = currentStatusIdx;
            }
        }

        private int validCheck(int previousIdx){
            if(previousIdx == 0) {
                return 1;
            }
            return rd.nextInt(2);
        }

        public void printLine(int maxLength){
            System.out.print(" ".repeat(maxLength/2));
            for(int i : line)
                System.out.print(defaultCase + statusCase.get(i).repeat(maxLength));
            System.out.println(defaultCase);
        }
    }

}