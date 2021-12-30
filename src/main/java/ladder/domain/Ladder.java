package ladder.domain;

import java.util.*;

public class Ladder {
    public List<String> names;
    public long peopleCount, height;
    public Line[] lineStatus;

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







}
