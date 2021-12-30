package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

public class LadderView {

    private final static int GAP = 5;

    private Ladder ladderObject;

    public List<String> names;
    public Long peopleCount, height;
    public Line[] lineStatus;

    public LadderView(Ladder ladderObject) {
        this.ladderObject = ladderObject;
        ladderViewInit();
    };

    private void ladderViewInit(){
        this.names = ladderObject.names;
        this.peopleCount = ladderObject.peopleCount;
        this.height = ladderObject.height;
        this.lineStatus = ladderObject.lineStatus;
    }


    public void display() {
        System.out.println("실행결과");
        printName();
        for(int i = 0 ; i < height ; i++) {
            System.out.print(" ".repeat((GAP + 1) / 2));
            printLine(i); //ith height에 대한 정보를 출력
            System.out.print("\n");
        }
    }

    public void printName(){
        for(int i = 0 ; i < names.size() ; i++){
            System.out.printf("%6s", names.get(i));
        }
        System.out.print("\n");
    }

    public void printLine(int line){

        int lineIdx = 0;
        StringBuilder sb = new StringBuilder();
        for(int j = 0 ; j < peopleCount ; j++) {
            sb.append("|");
            sb.append( (lineIdx < lineStatus[line].value.size() && lineStatus[line].value.get(lineIdx) == j ? "-" : " ").repeat(GAP) );

            //updating lineIdx
            lineIdx = updateLineIdx(line, j, lineIdx);
        }
        System.out.print(sb);

    }


    public int updateLineIdx(int line, int column, int lineIdx) {

        //lineIdx 변수 갱신
        while(lineIdx < lineStatus[line].value.size() && lineStatus[line].value.get(lineIdx) == column ) {
            lineIdx++;
        }
        return lineIdx;
    }

}
