package com.gunyoung.one.ladder;

import com.gunyoung.one.precondition.Precondition;
import com.gunyoung.one.user.User;

import java.util.ArrayList;
import java.util.List;

// todo: 추후 User 클래스 추가 시 Drawer 클래스 추가하여 그리기 위임, (User, Ladder, Bridge) 정보 --> (Drawer) = 그림 구조
//
public final class Ladder {

    private static Ladder INSTANCE;

    private final List<User> users;
    private final int ladderHeight;
    private final Bridge bridge;

    public static Ladder getInstance() {
        Precondition.notNull(INSTANCE, "Ladder is not initialized");
        return INSTANCE;
    }

    public static void init(String userNames, int ladderHeight) {
        INSTANCE = new Ladder(userNames, ladderHeight);
    }

    private Ladder(String userNames, int ladderHeight) {
        Precondition.notLessThanInt(ladderHeight, 1, "사다리의 높이는 1 이상이여야 합니다.");

        this.users = User.getListOfUserFromNames(userNames);
        this.ladderHeight = ladderHeight;
        this.bridge = new Bridge(this);
        this.bridge.makeBridges();
    }

    public List<User> getUsers() {
        return users;
    }

    public int getNumOfUser() {
        return users.size();
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public static class Bridge {
        private final boolean[][] bridges;
        private final BridgeMakeStrategy makeStrategy;

        private Bridge(Ladder ladder) {
            this(ladder, new RandomBridgeStrategy());
        }

        private Bridge(Ladder ladder, BridgeMakeStrategy makeStrategy) {
            int ladderHeight = ladder.getLadderHeight();
            int maxNumOfBridgesForEachRow = ladder.getNumOfUser() - 1;
            this.bridges = new boolean[ladderHeight][maxNumOfBridgesForEachRow];
            this.makeStrategy = makeStrategy;
        }

        private void makeBridges() {
            makeStrategy.makeBridges(bridges);
        }

        public char[] getSignaturesOf(int row) {
            char[] signatures = new char[bridges[row].length];
            for (int i = 0; i < signatures.length; i++) {
                signatures[i] = getSignatureOf(row, i);
            }
            return signatures;
        }

        private char getSignatureOf(int row, int col) {
            if (bridges[row][col])
                return '-';
            return ' ';
        }

    }
}
