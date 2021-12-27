import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    static private final Random randomGenerator = new Random();
    private final List<String> shape = new ArrayList<>();

    public Ladder(int numberOfPerson, int ladderHeight) throws IllegalArgumentException {
        checkNumberOfPerson(numberOfPerson);
        checkLadderHeight(ladderHeight);
        for (int i = 0; i < ladderHeight; i++) {
            shape.add(generateLadderLine(numberOfPerson));
        }
    }

    private void checkNumberOfPerson(int numberOfPerson) throws IllegalArgumentException {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException("참여하는 사람의 수는 양의 정수여야 합니다.");
        }
    }

    private void checkLadderHeight(int ladderHeight) throws IllegalArgumentException {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("사다리의 높이는 양의 정수여야 합니다.");
        }
    }

    private String generateLadderLine(int numberOfPerson) {
        StringBuilder generatedLine = new StringBuilder();
        int ladderSize = numberOfPerson * 2 - 1;
        for (int i = 0; i < ladderSize; i++) {
            if (i % 2 == 1) {
                generatedLine.append(generateStep());
                continue;
            }
            generatedLine.append("|");
        }
        return generatedLine.toString();
    }

    private char generateStep() {
        if (randomGenerator.nextBoolean()) {
            return '-';
        }
        return ' ';
    }

    public List<String> getShape() {
        return shape;
    }
}
