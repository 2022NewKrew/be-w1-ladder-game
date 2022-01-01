package view;

import DTO.OutputDTO;
import domain.LadderLine;

import java.util.List;

public class LadderRenderer {
    private final String VERTICAL_LINE = "|";
    private final int nameLength = 5;
    private final String BAR = "-".repeat(nameLength);
    private final String BLANK = " ".repeat(nameLength);

    private List<String> people;
    private List<String> results;
    private int heightOfLadder;
    private List<LadderLine> ladderLines;

    public LadderRenderer(OutputDTO outputDTO) {
        this.people = outputDTO.getPeople();
        this.results = outputDTO.getResults();
        this.heightOfLadder = outputDTO.getHeightOfLadder();
        this.ladderLines = outputDTO.getLadderLines();
    }

    public void printAll() {
        System.out.println(printItems(people));
        for(LadderLine ladderLine: ladderLines) {
            System.out.println(printLine(ladderLine));
        }
        System.out.println(printItems(results));
    }

    private String printItems(List<String> items) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item: items) {
            stringBuilder.append(printItem(item)+" ");
        }
        return stringBuilder.toString();
    }

    private String printItem(String item) {
        int nameLength = item.length();
        if (nameLength >= 5) {
            return item.substring(0,5);
        }
        return " ".repeat((6-nameLength)/2) + item + " ".repeat((5-nameLength)/2);
    }

    public String printLine(LadderLine ladderLine) {
        StringBuilder stringBuilder = new StringBuilder("  ");
        List<Boolean> points = ladderLine.getPoints();
        stringBuilder.append(VERTICAL_LINE);
        for (int i = 0 ; i < people.size() - 1 ; i++) {
            stringBuilder.append(printBarOrBlank(points.get(i)));
            stringBuilder.append(VERTICAL_LINE);
        }
        return stringBuilder.toString();
    }

    private String printBarOrBlank(Boolean point) {
        if (point) {
            return BAR;
        }
        return BLANK;
    }
}
