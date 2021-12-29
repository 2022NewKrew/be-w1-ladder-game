package laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final char verticalString = '|';
    private final String horizontalString= "-";
    private final String horizontalEmptyString= " ";
    private final int maxLengthOfPeopleName;
    private final int firstSpaceSize;
    private List<Boolean> isLBarList;

    Random random = new Random();
    public Line(int numOfPeople,int maxLengthOfPeopleName,int firstSpaceSize) {
        this.maxLengthOfPeopleName = maxLengthOfPeopleName;
        this.firstSpaceSize = firstSpaceSize;
        isLBarList = new ArrayList<Boolean>();
        for(int i=0;i<numOfPeople-1;i++){
            addRandomLineNoDuplicate();
        }
    }

    public void addRandomLineNoDuplicate(){
        if(isLBarList.size()>0 && isLBarList.get(isLBarList.size()-1)) {
            isLBarList.add(false);
            return ;
        }
        this.isLBarList.add(random.nextBoolean());
    }

    public void printLine(){
        String lineString = "";
        lineString+=horizontalEmptyString.repeat(firstSpaceSize);
        lineString+=verticalString;
        for (boolean isBar : isLBarList) {
            lineString+=boolToString(isBar).repeat(maxLengthOfPeopleName);
            lineString+=verticalString;
        }
        System.out.println(lineString);
    }

    //라인의 좌표에 선이 있는지를 통해 해당 위치에 적절한 String 을 return.
    public String boolToString(boolean isBar){
        if(isBar)
            return horizontalString;
        return horizontalEmptyString;
    }
}
