import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ladder {

    private long people, height;
    private Line[] lineStatus;

    public Ladder() {

        setValue();

    }

    public void setValue() {

        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        this.people = sc.nextLong();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.height = sc.nextLong();

    }

    public void initLine() {

        lineStatus = new Line[(int) this.height];
        for(int i = 0 ; i < height ; i++) {
            lineStatus[i] = new Line();
            lineStatus[i].value = new ArrayList<Long>();
        }

    }

    public void insertLine(int line, int lineSize, Random rd){

        for(int i = 0 ; i < lineSize ; i++) {
            lineStatus[line].value.add((long) rd.nextInt((int) people) - 1);
        }

        lineStatus[line].value.sort(Long::compareTo);

    }

    public void shuffle() {

        Random rd = new Random();

        for(int i = 0 ; i < height ; i++) {
            int lineSize = rd.nextInt((int) people - 1);
            insertLine(i, lineSize, rd); //lineSize 개수의 라인을 i 번째 높이에 랜덤으로 생성.
        }

    }

    public int updateLineIdx(int line, int column, int lineIdx) {

        //lineIdx 변수 갱신
        while(lineIdx < lineStatus[line].value.size() && lineStatus[line].value.get(lineIdx) == column ) {
            lineIdx++;
        }
        return lineIdx;
    }

    public void printLine(int line){

        int lineIdx = 0;

        StringBuilder sb = new StringBuilder();
        for(int j = 0 ; j < people ; j++) {
            sb.append(line > 0 && j == 0 ? "\n" : ""); //newline check
            sb.append( "|" );
            sb.append( lineIdx < lineStatus[line].value.size() && lineStatus[line].value.get(lineIdx) == j ? "-" : " " );

            //updating lineIdx
            lineIdx = updateLineIdx(line, j, lineIdx);
        }
        System.out.print(sb);

    }


    public void display() {
        for(int i = 0 ; i < height ; i++) {
            printLine(i); //ith height에 대한 정보를 출력
        }
    }

}
