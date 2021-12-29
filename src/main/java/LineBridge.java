package main.java;

public enum LineBridge {
    CONNECTED('-'), DISCONNECTED(' ');

    final char line;
    LineBridge(char line) {
        this.line = line;
    }
}
