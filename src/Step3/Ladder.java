package Step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final int people;
    private final int height;
    private final List<StringBuilder> ladder = new ArrayList<>();
    private final List<String> names;

    private Ladder(int people, int height, List<String> names) {
        this.people = people;
        this.height = height;
        this.names = names;
        makeLadder();
    }

    public static Ladder createLadder(String people, int height) {
        // try, catch를 통해 입력 확인
        List<String> names = new ArrayList<>(Arrays.asList(people.split(",")));
        int num = names.size();
        return new Ladder(num, height, names);
    }

    private void makeLadder() {
        for(int i=0; i<height; i++) {
            ladder.add(makeWidth());
        }
    }

    private StringBuilder makeWidth() {
        Line line = new Line(people);
        return line.getLine();
    }

    public void printLadder() {
        printName();
        for(StringBuilder sb : ladder) {
            System.out.println(sb);
        }
    }

    private void printName() {
        // TODO
    }
}
