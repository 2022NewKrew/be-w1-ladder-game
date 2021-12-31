package ladder.domain;

public enum LadderBridge {
    BRIDGE_CONNECTED("-----"), BRIDGE_DISCONNECTED("     ");
    final String line;

    LadderBridge(String line) {
        this.line = line;
    }
}
