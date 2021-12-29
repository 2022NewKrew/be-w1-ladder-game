package main.java;

public enum Line {
    LADDER("|"), BRIDGE_CONNECTED("-----"), BRIDGE_DISCONNECTED("     ");

    final String line;

    Line(String line) {
        this.line = line;
    }
}
