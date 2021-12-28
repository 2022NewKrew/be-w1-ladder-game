import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

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

    @Override
    public String toString() {
        StringBuilder convertResult = new StringBuilder();
        for (String ladderLine : shape) {
            convertResult.append(ladderLineToString(ladderLine));
        }
        return convertResult.toString();
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
        for (int i = 0; i < numberOfPerson; i++) {
            generatedLine.append(generateStep());
        }
        return generatedLine.toString();
    }

    private char generateStep() {
        if (randomGenerator.nextBoolean()) {
            return '-';
        }
        return ' ';
    }

    private String ladderLineToString(String ladderLine) {
        StringJoiner stringJoiner = new StringJoiner("|", "|", "|\n");
        for (String step : ladderLine.split("")) {
            stringJoiner.add(step);
        }
        return stringJoiner.toString();
    }

    public List<String> getShape() {
        return shape;
    }
}
