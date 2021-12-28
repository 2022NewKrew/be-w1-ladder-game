package step2.domain;

import step2.util.BranchChar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Branch {
    // (i%2 == 0) 이면 유저 라인
    // 가지는 유저라인을 제외하고 만든다.
    private final List<Boolean> isConnected = new ArrayList<>();

    private Branch() {
    }

    protected static Branch of(int width) {
        Branch branch = new Branch();
        IntStream.range(0, width)
                .forEach(branch::connectIfUserLine);

        return branch;
    }

    private void connectIfUserLine(int i) {
        isConnected.add(isUserLine(i));
    }

    public void setConnect(int index, boolean value) {
        isConnected.set(index, value);
    }

    public void disConnectIfConnectedToLeft(int index) {
        if (index > 1 && isConnected(index - 2))
            isConnected.set(index, false);
    }

    public int getWidth() {
        return isConnected.size();
    }

    public boolean isConnected(int index) {
        return isConnected.get(index);
    }

    public boolean isUserLine(int index) {
        return index % 2 == 0;
    }

    private char branchToChar(int index) {
        if (isUserLine(index)) {
            return BranchChar.USER_LINE.getCh();
        }

        if (isConnected(index)) {
            return BranchChar.CONNECTED.getCh();
        }

        return BranchChar.DISCONNECTED.getCh();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, isConnected.size())
                .forEach(index -> sb.append(branchToChar(index)));

        return sb.toString();
    }
}
