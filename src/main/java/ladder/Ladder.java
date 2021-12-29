package ladder;
import java.util.ArrayList;
import java.util.Random;

public final class Ladder {
    private final int width;
    private final int height;
    private final ArrayList<String> result;
    private final Random random;
    private boolean isPrev;

    private Ladder(String[] people, int ladderHeight) {
        this.width = people.length * 2 - 1;
        this.height = ladderHeight;
        this.result = new ArrayList<>();
        this.random = new Random();
        initPeople(people);
        initLadder();
    }

    public static Ladder of(String[] people, int ladderHeight){
        return new Ladder(people, ladderHeight);
    }

    private void initPeople(String[] people) {
        StringBuilder peopleStringBuilder = new StringBuilder();
        for (String person : people) {
            peopleStringBuilder.append(String.format("%-6s", person));
        }
        result.add(peopleStringBuilder.toString());
    }

    private void initLadder() {
        for(int i = 0; i < this.height; ++i) {
            result.add(getLadderString());
        }
    }

    private String getLadderString() {
        StringBuilder ladderStringBuilder = new StringBuilder();
        isPrev = false;
        for(int i = 0; i < width; i++) {
            ladderStringBuilder.append(getLadderShape(i));
        }
        return ladderStringBuilder.toString();
    }

    private String getLadderShape(int number) {
        if(checkEvenNumber(number)) {
            return Shape.COL.getShape();
        }
        if(checkRandomNumber() || isPrev){
            isPrev = false;
            return Shape.BLANK_ROW.getShape();
        }
        isPrev = true;
        return Shape.ROW.getShape();
    }

    private boolean checkEvenNumber(int number) {
        return (number % 2 == 0);
    }

    private boolean checkRandomNumber() {
        return random.nextBoolean();
    }

    public void draw() {
        for (String s : result) {
            System.out.println(s);
        }
    }
}
