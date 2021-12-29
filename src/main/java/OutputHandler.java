public class OutputHandler {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE_FILLED = "-----";
    private static final String HORIZONTAL_LINE_EMPTY = "     ";

    public OutputHandler() {

    }

    public void printLadder(Ladder ladder) {
        for (Layer layer : ladder.getLayers()) {
            printLayer(layer);
        }
    }

    private void printLayer(Layer layer) {
        System.out.print(VERTICAL_LINE);
        for (Boolean horizontalLine : layer.getHorizontalLines()) {
            System.out.print(horizontalLineToString(horizontalLine));
            System.out.print(VERTICAL_LINE);
        }
        System.out.println();
    }

    private String horizontalLineToString(Boolean horizontalLine) {
        if (horizontalLine) {
            return HORIZONTAL_LINE_FILLED;
        }
        return HORIZONTAL_LINE_EMPTY;
    }
}
