package ladder.domain;

public enum LadderBridge {
    BRIDGE_CONNECTED("-----"), BRIDGE_DISCONNECTED("     ");
    final String line;

    LadderBridge(String line) {
        this.line = line;
    }

    public boolean isConnected() {
        return BRIDGE_CONNECTED.line.equals(line);
    }
    
}
