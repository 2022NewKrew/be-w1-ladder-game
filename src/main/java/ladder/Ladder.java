package ladder;
import java.util.ArrayList;
import java.util.Random;

public final class Ladder {
    private final int width;
    private final int height;
    private final ArrayList<String> result;
    private final Random random;

    private Ladder(int people, int ladderHeight) {
        this.width = people * 2 - 1;
        this.height = ladderHeight;
        this.result = new ArrayList<>();
        this.random = new Random();
        initLadder();
    }
    public static Ladder of(int people, int ladderHeight){
        return new Ladder(people, ladderHeight);
    }

    private void initLadder() {
        for(int i = 0; i < this.height; ++i) {
            result.add(getLadderString());
        }
    }

    private String getLadderString() {
        StringBuilder ladderStringBuilder = new StringBuilder();
        for(int i = 0; i < width; i++) {
            ladderStringBuilder.append(getLadderChar(i));
        }
        return ladderStringBuilder.toString();
    }

    private char getLadderChar(int number) {
        if(checkEvenNumber(number)) {
            return '|';
        }
        if(checkRandomNumber()){
            return ' ';
        }
        return '-';
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
