package view;

public final class LadderShape {

    private final String ladderShape;

    private LadderShape(String ladderShape) {
        this.ladderShape = ladderShape;
    }

    public static LadderShape create(int[][] ladder) {
        return new LadderShape(generateLadderShape(ladder));
    }

    public String getShape() {
        return ladderShape;
    }

    public void printLadderShape() {
        System.out.println(getShape());
    }

    private static String generateLadderShape(int[][] ladder) {
        StringBuilder sb = new StringBuilder();
        for (int[] ladderLine : ladder) {
            sb.append(generateLadderLine(ladderLine));
            sb.append("\n");
        }
        return sb.toString();
    }

    private static StringBuilder generateLadderLine(int[] line) {
        StringBuilder sb = new StringBuilder();
        for (int block : line) {
            sb.append(LadderComponent.LADDER_ROW_LINE.getValue());
            checkBlock(block, sb);
        }
        sb.append(LadderComponent.LADDER_ROW_LINE.getValue());
        return sb;
    }

    private static void checkBlock(int block, StringBuilder sb) {
        if (block == 0) {
            sb.append(LadderComponent.LADDER_EMPTY_COLUMN.getValue());
        }
        if (block == 1) {
            sb.append(LadderComponent.LADDER_COLUMN_LINE.getValue());
        }
    }
}
