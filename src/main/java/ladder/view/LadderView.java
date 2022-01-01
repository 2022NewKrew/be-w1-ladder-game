package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

import static util.LadderUtil.*;

public class LadderView {

    private final int GAP = 5;

    public Ladder ladderObject;

    private List<String> names;
    private Long peopleCount, height;
    private List<Line> lineStatus;

    public LadderView(Ladder ladderObject) {
        this.ladderObject = ladderObject;
    };

    private void ladderViewInit(){
        this.names = ladderObject.getNames();
        this.peopleCount = ladderObject.getPeopleCount();
        this.height = ladderObject.getHeight();
        this.lineStatus = ladderObject.getLineStatus();
    }


    public void display() {
        ladderViewInit();

        System.out.println("실행결과");
        printName();
        for(int i = 0 ; i < height ; i++) {
            System.out.print(" ".repeat((GAP + 1) / 2));
            printLine(i); //ith height에 대한 정보를 출력
            System.out.print("\n");
        }
    }

    private void printName(){
        for(int i = 0 ; i < names.size() ; i++){
            System.out.printf("%6s", names.get(i));
        }
        System.out.print("\n");
    }

    private void printLine(int line){

        int lineIdx = 0;
        for(int j = 0 ; j < peopleCount ; j++) {
            sb.append("|");
            sb.append( (lineIdx < lineStatus.get(line).value.size() && lineStatus.get(line).value.get(lineIdx) == j ? "-" : " ").repeat(GAP) );

            //updating lineIdx
            lineIdx = updateLineIdx(line, j, lineIdx);
        }
        System.out.print(sb);
        sb.setLength(0);

    }


    private int updateLineIdx(int line, int column, int lineIdx) {

        //lineIdx 변수 갱신
        while(lineIdx < lineStatus.get(line).value.size() && lineStatus.get(line).value.get(lineIdx) == column ) {
            lineIdx++;
        }
        return lineIdx;
    }

}
