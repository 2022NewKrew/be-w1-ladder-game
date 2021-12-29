package main.domain.line;

public class Connection {

    private ConnectionState STATE = ConnectionState.UNCONNECTED;
    private Line targetLine;

    public void connect(Line targetLine) {
        this.targetLine = targetLine;
        this.STATE = ConnectionState.CONNECTED;
    }

    public boolean isConnected() {
        return this.STATE == ConnectionState.CONNECTED;
    }

    public Line getTargetLine() {
        return this.targetLine;
    }
}
