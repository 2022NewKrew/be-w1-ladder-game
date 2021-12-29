package laddergame;

public class Line {
    private final char verticalString = '|';
    private final String horizontalString= "-";
    private final String horizontalEmptyString= " ";
    private final int maxLengthOfPeopleName;
    private final int firstSpaceSize;
    private double[] ladderFloor;

    public Line(int numOfPeople,int maxLengthOfPeopleName,int firstSpaceSize) {
        this.maxLengthOfPeopleName = maxLengthOfPeopleName;
        this.firstSpaceSize = firstSpaceSize;
        ladderFloor = new double[numOfPeople-1];
        for(int i=0;i<numOfPeople-1;i++){
            this.ladderFloor[i] = Math.random();
        }
    }
    public void printLine(){
        String lineString = "";
        lineString+=horizontalEmptyString.repeat(firstSpaceSize);
        lineString+=verticalString;
        for (double room:ladderFloor) {
            lineString+= doubleToChar(room).repeat(maxLengthOfPeopleName);
            lineString+=verticalString;
        }
        System.out.println(lineString);
    }

    public String doubleToChar(double value){
        final double baseValue = 0.5;
        if(value>= baseValue)
            return horizontalString;
        return horizontalEmptyString;
    }
}
