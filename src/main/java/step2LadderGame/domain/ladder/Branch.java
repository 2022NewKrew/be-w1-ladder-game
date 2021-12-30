package step2LadderGame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Branch {
    // (i%2 == 0) 이면 유저 라인
    // 가지는 유저라인을 제외하고 만든다.
    private final List<BranchType> isConnected = new ArrayList<>();

    private Branch() {
    }

    protected static Branch of(int width) {
        final Branch branch = new Branch();
        IntStream.range(0, width)
                .forEach(branch::connectIfUserLine);
        return branch;
    }

    private void connectIfUserLine(int i) {
        if (isUserLine(i)) {
            isConnected.add(BranchType.USER_LINE);
            return;
        }

        isConnected.add(BranchType.DISCONNECTED);
    }

    public void setConnect(int index, BranchType value) {
        isConnected.set(index, value);
    }

    public void disConnectIfConnectedToLeft(int index) {
        if (index > 1 && isConnected(index - 2))
            isConnected.set(index, BranchType.DISCONNECTED);
    }

    public int getWidth() {
        return isConnected.size();
    }

    public boolean isConnected(int index) {
        return isConnected.get(index).equals(BranchType.CONNECTED);
    }

    public boolean isDisConnected(int index){
        return isConnected.get(index).equals(BranchType.DISCONNECTED);
    }

    public boolean isUserLine(int index) {
        return index % 2 == 0;
    }

    public List<BranchType> getConnectedInfoList() {
        return isConnected;
    }
}
