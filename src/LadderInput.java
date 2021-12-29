import java.util.ArrayList;

public class LadderInput{
    public static final int maxLength = 5;
    public final int numOfPeople;
    public final int depth;
    public ArrayList<String> names;
    public ArrayList<String> results;

    public LadderInput() {
        NameInput ni = new NameInput();
        ResultInput ri = new ResultInput();

        numOfPeople = ni.getSize();

        DepthInput di = new DepthInput();
        depth = di.getInput();

        names = ni.getCases();
        results = ni.getCases();
    }
}