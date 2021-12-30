package ladder.domain;

enum BridgeType {
    CONNECTED("-----"), DISCONNECTED("     ");

    private final String bridge;

    BridgeType(String bridge) {
        this.bridge = bridge;
    }

    protected String getBridge() {
        return bridge;
    }
}
