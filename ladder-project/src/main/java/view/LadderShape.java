package view;

import java.util.List;

public final class LadderShape {

    private final String ladderShape;

    private LadderShape(String ladderShape) {
        this.ladderShape = ladderShape;
    }

    public static LadderShape create(List<List<Boolean>> ladder) {
        return new LadderShape(generateLadderShape(ladder));
    }

    public String getShape() {
        return ladderShape;
    }

    public void printLadderShape() {
        System.out.println(getShape());
    }

    private static String generateLadderShape(List<List<Boolean>> ladder) {
        StringBuilder sb = new StringBuilder();
        for (List<Boolean> ladderLine : ladder) {
            sb.append(generateLadderLine(ladderLine));
            sb.append("\n");
        }
        return sb.toString();
    }

    private static StringBuilder generateLadderLine(List<Boolean> line) {
        StringBuilder sb = new StringBuilder();
        for (boolean block : line) {
            sb.append(LadderComponent.LADDER_ROW_LINE.getValue());
            checkBlock(block, sb);
        }
        sb.append(LadderComponent.LADDER_ROW_LINE.getValue());
        return sb;
    }

    private static void checkBlock(boolean block, StringBuilder sb) {
        if (!block) {
            sb.append(LadderComponent.LADDER_EMPTY_COLUMN.getValue());
        }
        if (block) {
            sb.append(LadderComponent.LADDER_COLUMN_LINE.getValue());
        }
    }
}
