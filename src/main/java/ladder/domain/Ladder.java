package ladder.domain;

import java.util.*;

public class Ladder {

    private final static int GAP = 5;

    private List<String> names;
    private long peopleCount, height;
    private Line[] lineStatus;

    public Ladder() {

        setValue();

    }

    public void setValue() {

        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        names = Arrays.asList(sc.nextLine().split(","));
        this.peopleCount = names.size();

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

    public void checkDeletion(int line, int column){

        //if line inserted sequencial order, delete.
        while(column + 1 < lineStatus[line].value.size() && lineStatus[line].value.get(column) + 1 == lineStatus[line].value.get(column + 1)){
            lineStatus[line].value.remove(column + 1);
        }

    }

    public void validUpdateLine(int line){

        for(int i = lineStatus[line].value.size() - 2 ; i >= 0 ; i--){
            checkDeletion(line, i);
        }

    }

    public void insertLine(int line, int lineSize, Random rd){

        for(int i = 0 ; i < lineSize ; i++) {
            lineStatus[line].value.add((long) rd.nextInt((int) peopleCount - 1));
        }

        lineStatus[line].value.sort(Long::compareTo);

    }


    public void shuffle() {

        Random rd = new Random();

        for(int i = 0 ; i < height ; i++) {
            int lineSize = rd.nextInt((int) peopleCount - 1);
            insertLine(i, lineSize, rd); //lineSize 개수의 라인을 i 번째 높이에 랜덤으로 생성.
            validUpdateLine(i); //i번째 height에 연속적인 line이 생성된경우 제거로직 추가
        }

    }

    public int updateLineIdx(int line, int column, int lineIdx) {

        //lineIdx 변수 갱신
        while(lineIdx < lineStatus[line].value.size() && lineStatus[line].value.get(lineIdx) == column ) {
            lineIdx++;
        }
        return lineIdx;
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


    public void display() {
        System.out.println("실행결과");
        printName();
        for(int i = 0 ; i < height ; i++) {
            System.out.print(" ".repeat((GAP + 1) / 2));
            printLine(i); //ith height에 대한 정보를 출력
            System.out.print("\n");
        }
    }

}
