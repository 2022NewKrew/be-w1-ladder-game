package view;

import domain.Ladder;
import domain.Layer;

import java.util.List;

public class OutputView {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE_FILLED = "-----";
    private static final String HORIZONTAL_LINE_EMPTY = "     ";
    private static final String LEFT_PADDING = "  ";
    private static final String RIGHT_PADDING = "  ";
    private static final String NAME_DELIMITER = " ";

    private static final int NAME_OUTPUT_LENGTH = 5;

    public OutputView() {

    }

    public void printLadder(Ladder ladder) {
        this.printPeople(ladder.getParticipants());
        for (Layer layer : ladder.getLayers()) {
            printLayer(layer);
        }
        this.printResults(ladder.getResults());
    }

    private void printLayer(Layer layer) {
        System.out.print(LEFT_PADDING);
        System.out.print(VERTICAL_LINE);
        for (Boolean horizontalLine : layer.getHorizontalLines()) {
            System.out.print(horizontalLineToString(horizontalLine));
            System.out.print(VERTICAL_LINE);
        }
        System.out.println(RIGHT_PADDING);
    }

    private void printPeople(List<String> people) {
        StringBuilder peopleString = new StringBuilder();
        for (String person : people) {
            peopleString.append(padName(person));
            peopleString.append(NAME_DELIMITER);
        }
        System.out.println(peopleString);
    }

    private void printResults(List<String> results) {
        StringBuilder resultString = new StringBuilder();
        for (String result : results) {
            resultString.append(padName(result));
            resultString.append(NAME_DELIMITER);
        }
        System.out.println(resultString);
    }

    private String horizontalLineToString(Boolean horizontalLine) {
        if (horizontalLine) {
            return HORIZONTAL_LINE_FILLED;
        }
        return HORIZONTAL_LINE_EMPTY;
    }

    private String padName(String name) {
        int leftPaddingSize = (NAME_OUTPUT_LENGTH + 1 - name.length()) / 2;
        int rightPaddingSize = (NAME_OUTPUT_LENGTH - name.length()) / 2;
        return " ".repeat(leftPaddingSize) + name + " ".repeat(rightPaddingSize);
    }
}