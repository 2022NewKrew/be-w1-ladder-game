package step3;

import java.util.ArrayList;
import java.util.Arrays;

public class Ladder {

    private ArrayList<String> ladder = new ArrayList<String>();;
    private int peopleNum;
    private int height;
    private ArrayList<String> peoples;
    private StringBuilder sb = new StringBuilder();
    private ArrayList<Line> lines = new ArrayList<Line>();
    private Line line;

    // 사람, 높이를 주지 않으면 자동으로 설정해준다.
    public Ladder() {
        peoples  = new ArrayList<String>(Arrays.asList("A", "B"));
        peopleNum = 2;
        height = 5;
        makeLadder();
    }

    // 사람, 높이를 주었을 때 그에 맞게 초기화해준다. 자동으로 사다리를 만든다.
    public Ladder(ArrayList<String> p, int h) {
        peoples = p;
        peopleNum = p.size();
        height = h;
        makeLadder();
    }

    // bridge를 line에 추가해주고 그에 맞는 String을 return해준다.
    private String makeBridge(boolean canMake) {
        if(canMake) {
            line.addLine(true);
            return "-----";
        }
        line.addLine(false);
        return "     ";
    }

    // 이전에 bridge가 존재하는 경우 "     " 를 추가하고 line에 false 정보를 추가해준다. 이외의 경우는 랜덤하게 설정한다.
    private String getRandomBridge() {
        if(line.getSize() != 0 && line.getLast()) {
            return makeBridge(false);
        }
        double randNum;
        randNum = Math.random();
        if(randNum >= 0.5) {
            return makeBridge(false);
        }
        return makeBridge(true);
    }

    // 사다리를 만들며 랜덤하게 "-----" 또는 "     "를 규칙에 어긋나지 않게 만들어준다.
    private String makeLine() {
        sb.setLength(0);
        line = new Line();
        for(int i=1;i<peopleNum;i++) {
            sb.append('|');
            sb.append(getRandomBridge());
        }
        sb.append('|');
        lines.add(line);
        return sb.toString();
    }

    // 사다리를 만들어준다.
    private void makeLadder() {
        for(int i=0;i<height;i++) {
            ladder.add(makeLine());
        }
    }

    // 이름이 5자 이상인 경우 앞의 5자까지만 추가해준다. 길이에 맞춰서 다음 사람의 이름까지 적절한 공백을 준다.
    private void printPeople(String people) {
        int endIdx = Math.min(people.length(), 5);
        System.out.print(people.substring(0,endIdx));
        for(int i=0;i<6-endIdx;i++)
            System.out.print(" ");
    }

    // 사람 리스트를 출력한다.
    private void printPeoples() {
        for(String people : peoples) {
            printPeople(people);
        }
        System.out.println();
    }

    //전체 사다리를 출력한다.
    public void printLadder() {
        printPeoples();
        for(String s : ladder) {
            System.out.println(s);
        }
    }

}
