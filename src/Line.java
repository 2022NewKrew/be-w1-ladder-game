package laddergame;

public class Line {
    private final char verticalChar = '|';
    private final char horizontalChar= '-';
    private final char horizontalEmptyChar= ' ';
    private double[] ladderFloor;
    public Line(int numOfPeople) {
        ladderFloor = new double[numOfPeople];
        for(int i=0;i<numOfPeople-1;i++){
            this.ladderFloor[i] = Math.random();
        }
    }
    public void printLine(){
        String lineString = "";
        lineString+=verticalChar;

        for (double room:ladderFloor) {
            lineString+=doubleToChar(room);
            lineString+=verticalChar;
        }

        System.out.println(lineString);
    }

    public char doubleToChar(double value){
        final double baseValue = 0.5;
        if(value>= baseValue)
            return horizontalChar;
        return horizontalEmptyChar;
    }
}
