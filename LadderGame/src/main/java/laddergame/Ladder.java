package laddergame;

class Ladder{
    private int playerNum;      // 참가자 수
    private int height;         // 사다리의 높이
    Line line;                  // 사다리의 가로줄에 대한 정보를 담는 인스턴스

    Ladder(){}
    Ladder(int pn, int h){
        this.playerNum = pn;
        this.height = h;
        this.line = new Line(pn-1, h);
        this.line.makeLine();
    }

    // 사다리 출력 메소드
    public void printLadder(){
        for(int row=0; row<this.height; row++){
            this.line.printRow(row);
        }
    }
}