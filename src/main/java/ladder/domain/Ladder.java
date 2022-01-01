package ladder.domain;

import ladder.view.LadderView;

import java.util.*;
import static util.LadderUtil.*;

public class Ladder {
    private List<String> names;
    private long peopleCount, height;
    private List<Line> lineStatus;

    public LadderView ladderView; //ladderView를 ladder객체 내부에서 관리하도록 수정

    public Ladder() throws Exception {
        ladderView = new LadderView(this);
    }

    //getter
    public List<String> getNames() {
        return names;
    }

    public long getPeopleCount() {
        return peopleCount;
    }

    public long getHeight() {
        return height;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setPeopleCount(long peopleCount) {
        this.peopleCount = peopleCount;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public List<Line> getLineStatus() {
        return lineStatus;
    }



    public void initLine() {

        lineStatus = new ArrayList<Line>() ;
        for(int i = 0 ; i < height ; i++) {
            lineStatus.add(new Line());
            lineStatus.get(i).value = new ArrayList<Long>();
        }

    }

    private void checkDeletion(int line, int column){

        //if line inserted sequencial order, delete.
        while(column + 1 < lineStatus.get(line).value.size() && lineStatus.get(line).value.get(column) + 1 == lineStatus.get(line).value.get(column + 1)){
            lineStatus.get(line).value.remove(column + 1);
        }

    }

    private void validUpdateLine(int line){

        for(int i = lineStatus.get(line).value.size() - 2 ; i >= 0 ; i--){
            checkDeletion(line, i);
        }

    }

    private void insertLine(int line, int lineSize){

        for(int i = 0 ; i < lineSize ; i++) {
            lineStatus.get(line).value.add((long) rd.nextInt((int) peopleCount - 1));
        }

        lineStatus.get(line).value.sort(Long::compareTo);

    }


    public void shuffle() {


        for(int i = 0 ; i < height ; i++) {
            int lineSize = rd.nextInt((int) peopleCount - 1);
            insertLine(i, lineSize); //lineSize 개수의 라인을 i 번째 높이에 랜덤으로 생성.
            validUpdateLine(i); //i번째 height에 연속적인 line이 생성된경우 제거로직 추가
        }

    }







}
