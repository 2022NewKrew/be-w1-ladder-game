package org.cs.finn.laddergame.domain.ladder;

import java.security.SecureRandom;

public enum BridgeType {
    EMPTY("     "),
    LINE("-----");

    private final String bridge;

    BridgeType(String bridge) {
        if (bridge == null || bridge.isEmpty()) {
            throw new IllegalArgumentException("BridgeType String is null or empty!");
        }
        this.bridge = bridge;
    }

    @Override
    public String toString() {
        return this.bridge;
    }

    private static final BridgeType[] VALUES = values();
    private static final int SIZE = VALUES.length;

    public static BridgeType getRandomBridge(final SecureRandom sRand) {
        if (sRand == null) {
            throw new IllegalArgumentException("SecureRandom is null!");
        }
        return VALUES[sRand.nextInt(SIZE)];
    }
}
