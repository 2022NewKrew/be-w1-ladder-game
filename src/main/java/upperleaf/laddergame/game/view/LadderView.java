package upperleaf.laddergame.game.view;

public class LadderView {

    private final StringBuilder resultBuilder;

    public LadderView() {
        this.resultBuilder = new StringBuilder();
    }

    public LadderView appendResult(String result) {
        resultBuilder.append(result);
        return this;
    }

    public String getResult() {
        return resultBuilder.toString();
    }

    public void printResult() {
        System.out.print(resultBuilder + "\n");
    }
}
