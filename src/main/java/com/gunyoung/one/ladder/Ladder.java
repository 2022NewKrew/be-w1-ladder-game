package com.gunyoung.one.ladder;

import com.gunyoung.one.bridge.BridgeInfo;
import com.gunyoung.one.messages.ErrorMessage;
import com.gunyoung.one.precondition.Precondition;
import com.gunyoung.one.user.UserInfo;

public final class Ladder {

    private static Ladder INSTANCE;

    private final int ladderHeight;
    private final UserInfo userInfo;
    private final BridgeInfo bridgeInfo;

    public static Ladder getInstance() {
        Precondition.notNull(INSTANCE, ErrorMessage.LADDER_NOT_INITIALIZED);
        return INSTANCE;
    }

    public static void init(String userNames, int ladderHeight) {
        INSTANCE = new Ladder(userNames, ladderHeight);
        INSTANCE.bridgeInfo.makeBridges();
    }

    private Ladder(String userNames, int ladderHeight) {
        Precondition.notEmpty(userNames, ErrorMessage.EMPTY_USER_NAME);
        Precondition.notLessThanInt(ladderHeight, 1, ErrorMessage.WRONG_LADDER_HEIGHT);

        this.ladderHeight = ladderHeight;
        this.userInfo = UserInfo.of(userNames);
        this.bridgeInfo = new BridgeInfo(ladderHeight, userInfo.getNumOfUsers() - 1);
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public BridgeInfo getBridgeInfo() {
        return bridgeInfo;
    }
}
