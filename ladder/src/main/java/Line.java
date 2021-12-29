public class Line {
    private final int lineNum;
    // 높이별 어떤 라인과 연결됐는지를 나타내는 정보
    private final Line[] connections;
    private final Participant participant;

    public Line(int lineNum, int height, Participant participant){
        this.lineNum = lineNum;
        this.participant = participant;
        this.connections = new Line[height];
    }

    public int getLineNum(){
        return lineNum;
    }

    public Line[] getConnections(){
        return connections;
    }

    public void setConnection(Line connectTo, int curHeight){
        connections[curHeight] = connectTo;
        connectTo.getConnections()[curHeight] = this;
    }

    public Participant getParticipant(){
        return participant;
    }

    public Boolean checkConnected(int height){
        return connections[height] != null;
    }
}
