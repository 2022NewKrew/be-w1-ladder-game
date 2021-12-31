package repository;

import java.util.HashMap;

public class PointToResultMapping {
    private final HashMap<Integer, String> pointToResult;
    private int sequence;

    public PointToResultMapping() {
        pointToResult = new HashMap<>();
        sequence = 0;
    }

    public void swapResult(int idx) {
        String tempResult = getResult(idx);
        setResult(idx, getResult(idx + 1));
        setResult(idx+1, tempResult);
    }

    public void addResult(String result) { pointToResult.put(sequence++, result); }
    public String getResult(int idx) { return pointToResult.get(idx); }
    private void setResult(int idx, String result) { pointToResult.put(idx, result); }
}
