package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class LadderInput{
    public final ArrayList<Integer> ladderInputData;
    public ArrayList<String> names;
    public ArrayList<String> results;

    public LadderInput() throws Exception {
        NameInput ni = new NameInput();
        ResultInput ri = new ResultInput(ni.getSize());
        DepthInput di = new DepthInput();

        ladderInputData = new ArrayList<>();
        ladderInputData.add(ni.getSize());
        ladderInputData.add(di.getInput());

        names = ni.getInput();
        results = ri.getInput();
    }

    public ArrayList<Integer> getLadderInputData() { return ladderInputData; }
    public ArrayList<String> getNames(){ return names; }
    public ArrayList<String> getResults() { return results; }
}