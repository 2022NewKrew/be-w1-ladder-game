package com.gunyoung.one.ladder;

import com.gunyoung.one.bridge.BridgeInfo;
import com.gunyoung.one.precondition.Precondition;
import com.gunyoung.one.user.UserInfo;

// todo: 추후 User 클래스 추가 시 Drawer 클래스 추가하여 그리기 위임, (User, Ladder, Bridge) 정보 --> (Drawer) = 그림 구조
//
public final class Ladder {

    private static Ladder INSTANCE;

    private final UserInfo userInfo;
    private final int ladderHeight;
    private final BridgeInfo bridgeInfo;

    public static Ladder getInstance() {
        Precondition.notNull(INSTANCE, "Ladder is not initialized");
        return INSTANCE;
    }

    public static void init(String userNames, int ladderHeight) {
        INSTANCE = new Ladder(userNames, ladderHeight);
        INSTANCE.bridgeInfo.makeBridges();
    }

    private Ladder(String userNames, int ladderHeight) {
        Precondition.notLessThanInt(ladderHeight, 1, "사다리의 높이는 1 이상이여야 합니다.");

        this.userInfo = UserInfo.of(userNames);
        this.ladderHeight = ladderHeight;
        this.bridgeInfo = new BridgeInfo(this);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public int getNumOfUser() {
        return userInfo.getNumOfUsers();
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public BridgeInfo getBridgeInfo() {
        return bridgeInfo;
    }
}
