public interface Connector {

    void connectLine(Line prevLine, Line nextLine);

    boolean isConnected(Line prevLine, Line nextLine, int position);
}
