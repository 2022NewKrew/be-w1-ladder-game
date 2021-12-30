package domain;

public class Line {
    private final int lineNum;
    // 높이별 어떤 라인과 연결됐는지를 나타내는 정보
    private final Line[] connections;
    private final Participant participant;
    private final Result result;

    public Line(int lineNum, int height, Participant participant, Result result){
        this.lineNum = lineNum;
        this.participant = participant;
        this.result = result;
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

    public Result getResult(){
        return result;
    }

    public Boolean checkConnected(int height){
        return connections[height] != null;
    }

    public Result getResult(int curHeight){
        int firstConnectedHeight = getFirstConnectedHeight(curHeight);

        if (firstConnectedHeight == connections.length)
            return result;
        return connections[firstConnectedHeight].getResult(firstConnectedHeight + 1);
    }

    private int getFirstConnectedHeight(int curHeight){
        while (curHeight < connections.length && connections[curHeight] == null)
            curHeight++;
        return curHeight;
    }
}
